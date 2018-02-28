package introcontrol.introcontrol;

public class IntroControl {
    public static int substractTenIfGreaterThanTen(int n){
        if(n<10){
            return n;
        }
        else{
            return n-10;
        }

    }

    public static String describeNumber(int n){
        return  (n==0? "zero":"not Zero");
    }

    public static String greetingToJoe(String name){
        return (name.equals("Joe")? "Hello Joe": ":-)");
    }

    public static int CalculateBonus(int i){
        return i>1_000_000? (int) (i * 0.1) :0;
    }

    public static int calculateMeterReadingsDifference(int prev, int next){
        int dif=0;

        if(prev<next){
            dif=next-prev;
        } else{
            dif=9999-prev+next;
        }

        return dif;
    }

    public static void printNumbers(int max){
        for (int i=0; i<=max; i++){
            if(i%2==0){
                System.out.println(i);
            }
        }
    }

    public static void printNumbersBetween(int min, int max){
        for(int i=min; i<=max; i++){
            System.out.println(i);
        }
    }

    public static void printNumbersBetweenAnyDirection(int min, int max){
        if(max>min){
            for (int i=min; i<=max; i++){
                if(i%2==0) {
                    System.out.println(i);
                }
            }
        } else{
            System.out.println("b");
            for (int i=min; i>=max; i--){
                if(i%2==0){
                    System.out.println(i);
                }
            }
        }
    }

    public static void printOddNumber(int max){
        for (int i=0; i<max; i++){
            if(i%2!=0){
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        int a=1;
        int b=10;
        int c=100;

        System.out.println(substractTenIfGreaterThanTen(a));
        System.out.println(substractTenIfGreaterThanTen(b));
        System.out.println(substractTenIfGreaterThanTen(c));

        System.out.println(describeNumber(10));
        System.out.println(describeNumber(0));
        System.out.println(describeNumber(-10));

        System.out.println(greetingToJoe("Joe"));
        System.out.println(greetingToJoe("Anna"));

        System.out.println(CalculateBonus(10000));
        System.out.println(CalculateBonus(2_000_000));

        System.out.println(calculateMeterReadingsDifference(100,200));
        System.out.println(calculateMeterReadingsDifference(9000,100));

        printNumbers(20);
        printNumbersBetween(10,20);
        System.out.println();
        printNumbersBetweenAnyDirection(10,20);
        System.out.println("as");
        printNumbersBetweenAnyDirection(20,10);
        System.out.println();
        printOddNumber(10);
    }

}
