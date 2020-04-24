class GraphicNovel extends Novel {
   public String illustrator ;
   
   
   public GraphicNovel(String t, String a, int num, String[] array1, String ill)
   {
      super(t, a, num, array1);
      illustrator = ill;
   }
   
   public void summary()
   {
      System.out.println(title+", written by "+author+", illustrated by "+illustrator+".");
   }

}