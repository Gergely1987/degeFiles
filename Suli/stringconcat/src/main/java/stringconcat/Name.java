package stringconcat;

import javax.print.attribute.standard.MediaSize;

public class Name {
    private String familyNamme;
    private String middleName;
    private String givenName;
    private Title title;

    public Name(String familyNamme, String middleName, String givenName, Title title) {
        if((isEmpty(familyNamme)) || isEmpty(givenName)){
            throw new IllegalArgumentException("Family name and given name must not be empty!");
        };
        this.familyNamme = familyNamme;
        this.middleName = middleName;
        this.givenName = givenName;
        this.title = title;
    }

    public Name(String familyNamme, String middleName, String givenName) {
        if(isEmpty( familyNamme)||isEmpty(givenName)){
            throw new IllegalArgumentException("Family name and given name must not be empty!");
        };
        this.familyNamme = familyNamme;
        this.middleName = middleName;
        this.givenName = givenName;
        this.title = Title.EMPTY;
    }


    public String getFamilyNamme() {
        return familyNamme;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getGivenName() {
        return givenName;
    }

    public Title getTitle() {
        return title;
    }

    public boolean isEmpty(String str){
        boolean isItEmpty=false;
        if(str==null||str.equals("")){
            isItEmpty=true;
        }
        return  isItEmpty;
    }

    public String concatNameWesternStyle(){
        String westerName="";
        String titleStr=title.stringify();

        if(isEmpty(titleStr)){
            westerName+=givenName+" "+middleName+" "+familyNamme;
        } else if(isEmpty(middleName)){
            westerName+=titleStr+" "+givenName+" "+familyNamme;
        } else if(isEmpty(titleStr)&&isEmpty(middleName)){
            westerName+=givenName+" "+familyNamme;
        } else{
            westerName+=titleStr+" "+givenName+" "+middleName+" "+familyNamme;
        }

        return westerName;
    }

    public String concatNameHungarianStyle(){
        String hungarianName="";
        String titleStr=title.stringify();

        if(isEmpty(titleStr)){
            hungarianName=familyNamme+" "+middleName+" "+givenName;
        } else if(isEmpty(middleName)){
            hungarianName=titleStr+" "+ familyNamme+" "+givenName;
        } else if(isEmpty(middleName)&&isEmpty(titleStr)){
            hungarianName=familyNamme+" "+givenName;
        } else{
            hungarianName=titleStr+" "+familyNamme+" "+middleName+" "+givenName;
        }
        return hungarianName;
    }
}
