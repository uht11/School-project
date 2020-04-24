class Novel extends ReadingMaterial
{
   public String[] characters;
   
   public Novel(String t, String a, int num, String[] array1)
   {
      super(t, a, num);
      characters = array1;
   }
   
   public void listCaracters()
   {
      for (int i = 0; i < characters.length ; i++ )
      {
         System.out.println(characters[i]);
      }
   }



}
