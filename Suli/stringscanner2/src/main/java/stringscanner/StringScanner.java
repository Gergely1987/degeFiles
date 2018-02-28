package stringscanner;

import java.util.Scanner;

public class StringScanner {

    public int readAndSumValues(String intString, String delimiter){
        if(intString.matches(".*[a-z].*")){
            throw new IllegalArgumentException("Incorrect");
        }
        Scanner sc=new Scanner(intString);
        sc.useDelimiter(delimiter);

        int sum=0;
        while(sc.hasNextInt()){
            sum+=sc.nextInt();
        }
        return sum;
    }


    public int readAndSumValues(String intString){

        if(isEmpty(intString)){
            throw new IllegalArgumentException("Incorrect");
        }
        int sum=0;
        Scanner sc=new Scanner(intString);
        while (sc.hasNextInt()){
            sum+=sc.nextInt();
        }
        return sum;
    }

    public String filterLinesWithWordOccurrences(String text, String word){

        Scanner sc=new Scanner(text);
        sc.useDelimiter("\n");

        String containedString="";
        while(sc.hasNextLine()){
            String a=sc.nextLine();
            if(a.contains(word)){
                containedString+=a+"\n";
            }
        }

        return containedString.trim();
    }


        public boolean isEmpty(String str){
        if(str==null ||str.isEmpty()){
            return true;
        }
        return false;
        }
}
