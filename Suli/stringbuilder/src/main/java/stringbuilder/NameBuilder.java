package stringbuilder;

public class NameBuilder {

    public String concatNameWesternStyle(String familyName, String middleName, String givenName, Title title) {
       String fullName="";
       if(isEmpty(familyName )|| isEmpty(givenName)){
           throw new IllegalArgumentException("Family name and given name must not be empty!");
       }

        if(isEmpty(middleName)==true){
            fullName=title.stringify()+" "+givenName+" "+familyName;
        } else if( title==(null)){
            fullName=givenName+" "+middleName+" "+familyName;
        } else if( isEmpty(title.stringify())){
            fullName=givenName+" "+middleName+" "+familyName;
        } else{
            fullName=title.stringify()+" "+givenName+" "+middleName+" "+familyName;
        }
        return fullName;
    }

    public String concatNameHungarianStyle(String familyName, String middleName, String givenName, Title title) {
        String fullName="";
        if(isEmpty(familyName )|| isEmpty(givenName)){
            throw new IllegalArgumentException("Family name and given name must not be empty!");
        }
            if(isEmpty(middleName)==true) {
                fullName = title.stringify() + " " + familyName + " " + givenName;
            }else if(title==null){
                fullName=familyName+" "+middleName+" "+givenName;
            } else if(isEmpty(title.stringify())==true){
                fullName=familyName+" "+middleName+" "+givenName;
            } else{
                fullName=title.stringify()+" "+familyName+" "+middleName+" "+givenName;
            }

        return fullName;
    }

    public String insertTitle(String name, Title title, String where) {

      StringBuilder newName=new StringBuilder(name);
      newName.insert(name.indexOf(where), " "+title.stringify());
      return newName.toString();
    }

    public String deleteNamePart(String name, String delete) {
       StringBuilder newName=new StringBuilder(name);
       int a=newName.indexOf(delete);
       newName.delete(a,a+delete.length());
       return newName.toString();
    }

//    public boolean isPalindrome(String word) {
//
//    }

    public boolean isEmpty(String str) {
        if (str == null || str.equals("")) {
            return true;
        }
        return false;
    }
}
