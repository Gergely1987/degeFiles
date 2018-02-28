package BuildingBlocks;

public class StringMachine {
    String result="abcabc";

   public static void main(String[] args) {
     StringMachine sm=new StringMachine();
      System.out.println(sm.result.replace("a","ab"));

      StringBuilder sb=new StringBuilder("animals");
      StringBuilder sbb=new StringBuilder(sb.substring(5));
      System.out.println(sb);
      System.out.println(sbb);

      StringBuilder strb=new StringBuilder("animal");
      StringBuilder str=new StringBuilder("animal");
      System.out.println(str.equals(strb));

      Operators o=new Operators();
      Operators o1=new Operators();
      System.out.println(o.equals(o1));
      Operators o2=o;
      System.out.println(o==o2);

      String[]strings={"StringValue"};
      Object[]objects=strings;
      String[]againStrings=(String[])objects;

      String[]birds=new String[5];
      for (String s:birds) {
         System.out.print(s+", ");
      }
      String[][][]alma=new String[3][3][3];

   }
}
