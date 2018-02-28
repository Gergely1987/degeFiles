package stringmethods;

public class FileNameManipulator {

    public char findLastCharacter(String str) {

        if (isEmpty(str)) {
            throw new IllegalArgumentException("Empty string!");
        } else {
            String newStr=str.trim();
            return newStr.charAt(newStr.length() - 1);
        }
    }

    public String findFileExtension(String fileName) {
        String fileN[] = fileName.split("\\.");
            if (fileN.length < 2) {
            throw new IllegalArgumentException("Invalid file name!");
        }
         else if(fileN[0].equals("")){
                throw new IllegalArgumentException("Invalid file name!");
            }
        else {
            return "."+fileN[1];
        }
    }

    public boolean identifyFilesByExtension(String ext, String fileName) {
        String fileN[] = fileName.split("\\.");

        if (fileN.length <2) {
            throw new IllegalArgumentException("Invalid argument!");
        }
        else if(fileN[0].equals("")){
            throw new IllegalArgumentException("Invalid argument!");
        }
        else {
            if (ext.equals(fileN[1])) {
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean compareFilesByName(String searchedFileName, String actualFileName) {
        if(searchedFileName.equalsIgnoreCase(actualFileName)){
            return true;
        }
        else{
            return false;
        }
    }

    public String changeExtensionToLowerCase(String fileName) {
       String fileN[]=fileName.split("\\.");
       String newFileName;
        if (isEmpty(fileName)) {
            throw new IllegalArgumentException("Empty string!");
        } else{
            newFileName=fileN[0]+"."+fileN[1].toLowerCase();
        }
        return newFileName;
    }

    public String replaceStringPart(String fileName, String present, String target) {
        String newFileName="";
        String newFile[]=fileName.split("\\.");
        if(fileName.contains(" ")){
         newFileName= fileName.replace(" ", "_");
        }
        else{
            if(newFile[1].equals(present)){
              newFileName=  newFile[0]+"."+target;
            } else{
                newFileName=fileName;
            }
        }
        return  newFileName;
    }

    public boolean isEmpty(String str) {
        if (str == null || (str.trim().length()==0)) {
            return true;
        }
            return false;
    }
}
