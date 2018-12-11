/* Uzzul Hussain cs435 9813 mp */

import java.io.File;
public class ENC9813 {
	public static void main(String[] args) {
        boolean argCheck = false;

        if (args.length == 1) {

            String input = args[0];
            String output = input + ".huf";
            
            if (FCheck.fileExists(input)) {
                long start = System.currentTimeMillis();

                Huffman9813.encode(input, output);

                long elapsedMillis = System.currentTimeMillis() - start;    
                System.out.println("Elapsed: " + (elapsedMillis / 1000.0) + "sec");
            } else {
                System.out.println("*********File not found!**********");
            }
            
        } else {
            argCheck = true;
        }

        if (argCheck) {
            System.out.println("Please provide valid arguments.");
            System.out.println("Command line example: java ENC9813 filename");
            System.out.println();
        }
	}
   
   public static class FCheck {

    public static boolean fileExists(String address) {
        return new File(address).isFile();
    }
   }
   
   
}