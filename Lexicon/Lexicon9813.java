/* Uzzul Hussain cs435 9813 mp */

import java.util.*;
import java.io.*;


public class Lexicon9813 {

   public static String var1 = "";
   public static char[] A;
   public static String[] T;
   public int Asize, Tsize , Acounter = 0; 
   public static int sizeofArray=11;
   
   
   
   public static void main(String[] args) {
	   Lexicon9813 L = new Lexicon9813();
        
       
		File ifile = new File(args[0]);
        try{
			Scanner input = new Scanner(ifile);
			FileWriter output = new FileWriter("output.txt");
			
			
			
			while(input.hasNextLine()){
			var1 = input.nextLine();
			
			
			//operation 14
			if(((var1.split(" "))[0]).equals("14")){
				sizeofArray = Integer.valueOf(((var1.split(" "))[1]));
				L.HashCreate(sizeofArray);}
			
			
			//operation 10
			else if (((var1.split(" "))[0]).equals("10")){
				
				L.HashInsert(((var1.split(" "))[1]).split("(?!^)")); }
			
			// operation 11
			else if (((var1.split(" "))[0]).equals("11")){
				int u = L.HashSearch(((var1.split(" "))[1]).split("(?!^)"));
				if( -1 == (L.HashDelete(((var1.split(" "))[1]).split("(?!^)"))) ){
					output.write(((var1.split(" "))[1]) + " not in Hash");
				}
				else{
					output.write(((var1.split(" "))[1]) + " deleted from slot " + u + (System.getProperty( "line.separator" )));
				}

				}
				
			// operation 12
			else if (((var1.split(" "))[0]).equals("12")){
				 int d = L.HashSearch(((var1.split(" "))[1]).split("(?!^)"));
				 if(d == -1){output.write(((var1.split(" "))[1]) + " not found" + (System.getProperty( "line.separator" )));}
				 
				else {
				 output.write(((var1.split(" "))[1]) + " found at slot " + d + (System.getProperty( "line.separator" )));
				}
				}
			
				
			// operation 13
			else if (((var1.split(" "))[0]).equals("13")){
				output.write("     T         ");
				
				output.write((System.getProperty( "line.separator" )));
				
				for (int i = 0 ; i < sizeofArray; i++){
					if (T[i] == "x"){output.write(i+"  : "+(System.getProperty( "line.separator" )));}
					else{output.write(i+"  : "+T[i]+(System.getProperty( "line.separator" )));}
				
				}

			}
			
			}
			
			input.close(); output.close();
			
        } catch (IOException ex)
        {
           System.out.printf("Command file not found" , ex);
        }
		
		
        }//end main
        Lexicon9813(){
			//constructor 
		}
        public void HashCreate(int m){   // operation 14
			Asize = 15*m;
			Tsize = m;
			A = new char[Asize];
			Arrays.fill(A, ' ');  //A fills with spaces
			T = new String[Tsize];
			Arrays.fill(T, " ");  //T fills with spaces
			
		}
		public int HashSearch(String [] word){
		boolean ans = false;
		int tem = 0;int x=0;int s=0; int loopcnt = sizeofArray*2;
		
		for (int j = 0 ; j < word.length; j++){
			
			tem += (int)((word[j]).charAt(0));
			
		}
		int Tix = tem % sizeofArray ;
		if(T[Tix] == " "){ return -1;}
		if(T[Tix] == "x"){ s++;
				Tix = (tem % sizeofArray) + (s*s);}
		while(!ans && loopcnt > 0){ // check
		x=0;
		if(T[Tix] == "x"){ s++;
				Tix = (tem % sizeofArray) + (s*s);}
		int testind = Integer.parseInt(T[Tix]);
			for ( int i = testind; i < word.length+testind; i++){
				if (A[i] != word[x].charAt(0)){
					ans = false;
				}
				else { ans = true ;}
				x++;
			}
		
		if(ans == false){
			s++;
				Tix = (tem % sizeofArray) + (s*s);
				//System.out.println("collision:" + Tix);
					
				Tix %= (sizeofArray);
				loopcnt--;
		}
		
		}
		
		if(ans){ return Tix; }
		else { return -1 ; }
					
		}
		public int HashDelete(String [] word){
		
		int h = this.HashSearch(word);
		if (h == -1){ return -1;}
		T[h] = "x";
		return 0;
		}
		public void HashInsert(String [] word){
		
		//calculation for index
		int temp =0;
		
		for (int j = 0 ; j < word.length; j++){
			
			temp += (int)((word[j]).charAt(0));
			
		}
		int Tindex = temp % sizeofArray ;
		int v=0;
		
	
		while(!(T[Tindex].equals(" "))){ // collision
					Tindex =  Tindex % (sizeofArray);
					v++;
					Tindex = (temp % sizeofArray) + (v*v);
					

				}
			//System.out.println(T[Tindex]);
			//System.out.println(Tindex);
			T[Tindex] = Integer.toString(Acounter);
			//System.out.println(T[Tindex]);
		
		for (int i = 0 ; i < word.length; i++){
			A[Acounter] = (word[i]).charAt(0);
			Acounter++;
		}
		A[Acounter] = '\0';Acounter++;
			
		
		}
		public void HashPrint(){
			
		}
		public boolean HashFull(){
			
			
			for(int i = 0; i < T.length; i++){
				if ( T[i] == " " ){
				return false ;}
			}
			return true;
		}
		public boolean HashEmpty(){
			boolean t;
			
			for(int i = 0; i < T.length; i++){
				if ( T[i] != " " ){
				return false ;}
			}
			return true;
		}
}


	

        
