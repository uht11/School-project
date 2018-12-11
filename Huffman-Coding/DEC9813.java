/* Uzzul Hussain cs435 9813 mp */

import java.io.File;
public class DEC9813 {
	public static void main(String[] args) {
        boolean argCheck = false;

        if (args.length == 1) {

            String input = args[0];
            
            if (FCheck.fileExists(input)) {                
                if (input.toLowerCase().endsWith(".huf")) {
                    String output = input.substring(0, input.length() - 4);
                    
                    long start = System.currentTimeMillis();
    
                    Huffman9813.decode(input, output);
    
                    long elapsedMillis = System.currentTimeMillis() - start;    
                    System.out.println("Elapsed: " + (elapsedMillis / 1000.0) + "sec");
    
                } else {
                    argCheck = true;
                }
            } else {
                System.out.println("*********File not found!**********");
                return;
            }

        } else {
            argCheck = true;
        }

        if (argCheck) {
            System.out.println("Please provide valid arguments.");
            System.out.println("Command line example: java DEC9813 filename.huf");
            System.out.println();
           
        }
	}
   
   public static class FCheck {

    public static boolean fileExists(String address) {
        return new File(address).isFile();
    }
    }
   
   
}