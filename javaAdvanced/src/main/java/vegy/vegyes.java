package vegy;

public class vegyes {

    public void writeOut(Integer a){
        for (int i = 1; i <101 ; i++) {
            if (i % 3 == 0 && i%5==0) {
                System.out.println("KrixKrax " + i);
                continue;
            }
            else if(i%3==0){
                System.out.println("Krix");
            }
            else if(i%5==0){
                System.out.println("Krax");
            }
            else{
                System.out.println(i);
            }
        }
    }

    public boolean isPolindrom(String str){
        String newStr=str.replace(" ","").toLowerCase();
        int a=newStr.length()-1;
        boolean result=true;
        System.out.println(newStr);
        for (int i = 0; i <newStr.length(); i++) {
            if(newStr.charAt(i)!=newStr.charAt(a)){
                return false;
            }
            a--;
        }
        System.out.println(true);
        return true;
    }

    public static void main(String[] args) {
        vegyes v=new vegyes();
        v.writeOut(1);
        v.isPolindrom("A cápa ette apáca");

    }
}
