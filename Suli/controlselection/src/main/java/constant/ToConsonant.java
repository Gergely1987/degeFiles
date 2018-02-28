package constant;

public class ToConsonant {

    char abcVowels[]={'a', 'e', 'i', 'o', 'u'};
    char abcCons[]={'b','f','j','p','v'};

    public char convertToConsonant(char ch){
        for (int i=0; i<abcVowels.length; i++){
            if(ch==abcVowels[i]){
                ch=abcCons[i];
            }
            else{
                ch=ch;
            }
        }
        return ch;
    }
}
