package stringscanner;

import java.util.Scanner;

public class StringScanner {
    public int readAndSumValues(String intString, String delimiter) {
        Scanner sc = new Scanner(intString);

        if(isEmpty(intString)|| isEmpty(delimiter)){
            throw new IllegalArgumentException("Incorrect");
        }
        if(intString.matches(".*[a-z].*")){
            throw new IllegalArgumentException("Incorrect");
        }
        if(!delimiter.contains(":")){
            throw new IllegalArgumentException("Incorrect");
        }
        int sum=0;
        sc.useDelimiter(delimiter);
        while(sc.hasNextInt()){
            sum+=sc.nextInt();
        }
        return sum;
    }


    public int readAndSumValues(String intString) {
        int sum = 0;

        Scanner sc = new Scanner(intString);
        if (isEmpty(intString)){
            throw new IllegalArgumentException("Incorrect");
        }
        if(intString.matches("[a-zA-Z]")){
            throw new IllegalArgumentException("Incorrect");
        }

        while (sc.hasNextInt()) {
            sum+=sc.nextInt();
        }
            return sum;
    }

    public String filterLinesWithWordOccurrences(String text, String word) {
        Scanner sc=new Scanner(text);
        sc.useDelimiter(word);

        String containedWord="";
        while (sc.hasNextLine()){
            String piece=sc.nextLine();
            if(piece.contains(word)){
                containedWord+=piece+"\n";
            }
        }
        return containedWord.trim();
    }

    public boolean isEmpty(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        return false;
    }
}
