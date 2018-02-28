public class FileNameManipulator {

    public char findLastCharacter(String str) {
        if (isEmpty(str)) {
            throw new IllegalArgumentException("Empty string!");
        } else {
            return str.charAt(str.length() - 1);
        }
    }

    public String findFileExtension(String fileName) {
        String fileN[] = fileName.split("\\.");
        if (isEmpty(fileName)) {
            throw new IllegalArgumentException("Invalid file name!");
        } else if (fileN.length != 2) {
            throw new IllegalArgumentException("Invalid file name!");
        } else {
            return fileN[1];
        }
    }

    public boolean identifyFilesByExtension(String ext, String fileName) {
        String fileN[] = fileName.split("\\.");

        if (fileN.length != 2) {
            throw new IllegalArgumentException("Invalid argument!");
        } else {
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
            newFileName=newFile[0]+"."+target;
        }
        return  newFileName;
    }

    public boolean isEmpty(String str) {
        if (str.trim() == null || str.trim().equals("")) {
            return true;
        } else {
            return false;
        }
    }
}
