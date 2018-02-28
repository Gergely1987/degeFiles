package stringbuilder;

public class NameBuilder {
    public String concatNameWesternStyle(String familyName, String middleName, String givenName, Title title) {
        if(isEmpty(familyName)|| isEmpty(givenName)){
            throw new IllegalArgumentException("Family name and given name must not be empty!");
        }
        StringBuilder concatedName=new StringBuilder();

        if(title!=null && !title.getValue().isEmpty()){
            concatedName.append(title.getValue()+" ");
        }
        concatedName.append(givenName+" ");
        if(middleName!=null && !middleName.isEmpty()){
            concatedName.append(middleName+" ");
        }
        concatedName.append(familyName);
        return concatedName.toString();
    }

    public String concatNameHungarianStyle(String familyName, String middleName, String givenName, Title title) {
        if(isEmpty(familyName) || isEmpty(givenName)){
            throw new IllegalArgumentException("Family name and given name must not be empty!");
        }
        StringBuilder concatedName=new StringBuilder();
        if(title!=null && !title.getValue().isEmpty()){
            concatedName.append(title.getValue()+" ");
        }
        concatedName.append(familyName+" ");
        if(middleName!=null && !middleName.isEmpty()){
            concatedName.append(middleName+" ");
        }
        concatedName.append(givenName);

        return concatedName.toString();
    }

    public String insertTitle(String name, Title title, String where) {
            StringBuilder insertedName=new StringBuilder(name);
            insertedName.insert(name.indexOf(where)+1, title.getValue()+" ");
            return insertedName.toString();
    }

    public String deleteNamePart(String name, String delete) {
            StringBuilder deletedName=new StringBuilder(name);
            if(name.contains(delete)) {
                deletedName.delete(name.indexOf(delete), name.indexOf(delete) + delete.length());
            }
            return deletedName.toString();
    }



    public boolean isEmpty(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        return false;

    }

}
