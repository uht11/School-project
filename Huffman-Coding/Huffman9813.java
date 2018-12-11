/* Uzzul Hussain cs435 9813 mp */

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.RandomAccessFile;

public final class Huffman9813 {
    static final int BITS_PER = 8;
    static final int ASIZE = 256;

    public static void encode(String input, String output) {
        try (RandomAccessFile reader = new RandomAccessFile(input, "r");
            DataOutputStream writer = new DataOutputStream(new FileOutputStream(output))) {
            
            int[] charFreq = new int[ASIZE];
            int value;
			while ((value = reader.read()) >= 0) {
                if (value < ASIZE) {
                    charFreq[value]++;
                } else {
                }
            }
            reader.seek(0);
            
            int validCharCount = 0;
            for (int i = 0; i < charFreq.length; i++) {
                if (charFreq[i] > 0) validCharCount++;
            }

            Tree9813<HNode9813> root = buildHuffmanTree(charFreq);
            HuffmanCharacter[] huffChars = getHuffmanChars(root);
            int totalBitCount = computeBitCount(huffChars, charFreq);

            
            writer.writeInt(validCharCount);
            for (int i = 0; i < charFreq.length; i++) {
                if (charFreq[i] <= 0) continue;
                writer.writeChar((char)i);
                writer.writeInt(charFreq[i]);
            } final int BUFFER_SIZE = 1024 * 64;

            byte[] buffer = new byte[BUFFER_SIZE];
            int bufferSize = 0;

            byte bits = 0;
            int bitCount = 0;
            while ((bufferSize = reader.read(buffer)) > 0) {
                for (int i = 0; i < bufferSize; i++) {
                    value = buffer[i];
                    HuffmanCharacter c = huffChars[value];
                    
                    int remaining = c.getBitCount();
                    while (remaining > 0) {
                        int bitsNeeded = BITS_PER - bitCount;

                        if (remaining <= bitsNeeded) {
                            int shiftBy = bitsNeeded - remaining;
                            int cropped = (c.getBitValue() & ((1 << remaining) - 1)) << shiftBy;
                            bits = (byte)(bits | cropped);
                            bitCount += remaining;
                            remaining = 0;
                        } else {
                            int shiftBy = remaining - bitsNeeded;
                            int cropped = (c.getBitValue() >> shiftBy) & ((1 << bitsNeeded) - 1);
                            bits = (byte)(bits | cropped);
                            remaining -= bitsNeeded;
                            bitCount = BITS_PER;
                        }

                        if (bitCount == BITS_PER) {
                            writer.writeByte(bits);
                            bitCount = 0;
                            bits = 0;
                        }
                    }
                }
            }

            if (bitCount > 0) {               
                writer.writeByte(bits);
            }

		} catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    public static void decode(String input, String output) {
        try (DataInputStream reader = new DataInputStream(new FileInputStream(input));
            BufferedWriter writer = new BufferedWriter(new FileWriter(output))) {
            
            int[] charFreq = new int[ASIZE];
            int validCharCount = reader.readInt();
            for (int i = 0; i < validCharCount; i++) {
                char c = reader.readChar();
                int freq = reader.readInt();
                charFreq[c] = freq;
            }
            Tree9813<HNode9813> root = buildHuffmanTree(charFreq);
            HuffmanCharacter[] huffChars = getHuffmanChars(root);
            int totalBitCount = computeBitCount(huffChars, charFreq);

            Tree9813<HNode9813> curr = root;
            byte bits = 0;
            int bitIndex = BITS_PER;
            int remainingTotalBitCount = totalBitCount;
            while (remainingTotalBitCount > 0) {
                if (bitIndex == BITS_PER) {
                    int value = reader.read();
                    if (value == -1) break;

                    bits = (byte)value;
                    bitIndex = 0;
                }

                int reverseBitIndex = BITS_PER - bitIndex - 1;
                int bit = (bits & (1 << reverseBitIndex)) >> reverseBitIndex;
                bitIndex++;

                if (bit == 0) {
                    curr = curr.getLeft();
                } else if (bit == 1) {
                    curr = curr.getRight();
                }

                if (curr == null) {
                    break; 
                } else if (curr.isLeaf()) {
                    HNode9813 node = curr.getValue();
                    writer.append((char)node.getValue());
                    curr = root;
                }

                remainingTotalBitCount -= 1;
            }

		} catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    static Tree9813<HNode9813> buildHuffmanTree(int[] charFreq) {
        if (charFreq == null || charFreq.length != Huffman9813.ASIZE) {
            throw new IllegalArgumentException();
        }

        Heap9813<Tree9813<HNode9813>> nodes = new Heap9813<Tree9813<HNode9813>>(new HeapHuffmanTreeConstraint());

        
        for (int i = 0; i < charFreq.length; i++) {
            if (charFreq[i] <= 0) continue;

            HNode9813 n = new HNode9813((char)i, charFreq[i]);
            nodes.insert(new Tree9813<HNode9813>(n));
        }
        while (nodes.size() > 1) {
            Tree9813<HNode9813> right = nodes.extract();
            Tree9813<HNode9813> left = nodes.extract();

            HNode9813 parentNode = new HNode9813();
            parentNode.setFreq(left.getValue().getFreq() + right.getValue().getFreq());
            Tree9813<HNode9813> parent = new Tree9813<HNode9813>(parentNode, left, right);
            nodes.insert(parent);
        }
        return nodes.extract();
    }

    static HuffmanCharacter[] getHuffmanChars(Tree9813<HNode9813> root) {
        HuffmanCharacter[] characters = new HuffmanCharacter[ASIZE];

        class Traverser {
            public void traverse(Tree9813<HNode9813> treeNode, int bitValue, int bitCount) {
                if (treeNode == null) return;

                HNode9813 node = treeNode.getValue();
                if (node.getValue() >= 0) {
                    HuffmanCharacter huffChar = new HuffmanCharacter(node);
                    huffChar.setBitValue(bitValue);
                    huffChar.setBitCount(bitCount);
                    characters[node.getValue()] = huffChar;
                }
                traverse(treeNode.getLeft(), bitValue << 1, bitCount + 1);
                traverse(treeNode.getRight(), (bitValue << 1) | 1, bitCount + 1);
            }
        };

        Traverser t = new Traverser();
        t.traverse(root, 0, 0);
        
        return characters;
    }
    
    static int computeBitCount(HuffmanCharacter[] huffChars, int[] charFreq) {
        int bitCount = 0;
        for (int i = 0; i < huffChars.length; i++) {
            if (charFreq[i] <= 0) continue;
            bitCount += huffChars[i].getBitCount() * charFreq[i];
        }
        return bitCount;
    }

    static class HuffmanCharacter {
        HNode9813 node;
        int bitValue, bitCount;

        public HuffmanCharacter(HNode9813 node) {
            this.node = node;
        }

        public HNode9813 getNode() { return node; }
        public void setNode(HNode9813 node) { this.node = node; }

        public int getBitValue() { return bitValue; }
        public void setBitValue(int bitValue) { this.bitValue = bitValue; }

        public int getBitCount() { return bitCount; }
        public void setBitCount(int bitCount) { this.bitCount = bitCount; }
    }

    static class HeapHuffmanTreeConstraint implements HConstraint9813<Tree9813<HNode9813>> {
        @Override
        public boolean isConstraintValid(Tree9813<HNode9813> parent, Tree9813<HNode9813> child) {
            return parent.getValue().getFreq() <= child.getValue().getFreq();
        }
    }
}