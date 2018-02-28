package stringbuilder;

public class PalindromeValidator {

    public boolean isPalindrome(String word) {
//        if(word==null){
//            throw new IllegalArgumentException("Text must not be null!");
//        }
//      String newWord=word.toLowerCase().trim();
//
//      StringBuilder s1=new StringBuilder(newWord);
//      String newWord2=s1.toString();
//
//      String newWord3=s1.reverse().toString();
//
//      if(newWord2.equals(newWord3)){
//          return true;
//      }
//      return false;

        if (word == null) {
            throw new IllegalArgumentException("Text must not be null!");
        }
        StringBuilder sb=new StringBuilder(word.trim());

        if(sb.toString().equalsIgnoreCase(sb.reverse().toString())){
            return true;
        }
        return false;

    }

}
