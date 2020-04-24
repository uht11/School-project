class Article extends ReadingMaterial
{
   public String publication;
   
   public Article(String t, String a, int num, String pub) 
   {
      super(t, a, num);
      publication = pub;
   }
   
   public void summary()
   {
      System.out.println(title+", written by "+author+", published in "+publication+".");
   }
   
}


