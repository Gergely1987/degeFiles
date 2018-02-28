package accents;

public class WithoutAccents {

    char []abc={'á','Á','é','É','í','Í','ó','Ó','ö','Ö','ő','Ő','ú','Ú','ü','Ü','ű','Ű'};
    char []abcA={'a','A','e','E','i','I','o','O','o','O','o','O','u','U','u','U','u','U'};
    public char convertToCharWithoutAccents(char a){

        for (int i=0; i<abc.length; i++){
            if(a==abc[i]){
                a=abcA[i];
            }
            else{
                a=a;
            }
        }

        return a;
    }
}
