package fileclass;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileManager {

    public File createFile(String fileName) throws IOException {
        File f = new File(fileName);
        if (f.exists()) {
            throw new IllegalArgumentException("File with this name already exists");
        }

        f.createNewFile();
        return f;
    }

    public File createSubDirectory(String pathName, String directoryName) {
        File directory = new File(pathName + File.separator + directoryName);
        if (directory.exists()) {
            throw new IllegalArgumentException("Directory with this name already exists");
        }
        directory.mkdirs();
        return directory;
    }

    public boolean deleteFile(String fileName) {
        File toDelete = new File(fileName);
        if (!toDelete.exists()) {
            throw new IllegalArgumentException("File with this name does not exists");
        }

        return toDelete.delete();
    }

    public List<String> findDirectories(String path, List<String> directories) {
        File f = new File(path);

        if (f.exists() && f.isDirectory()) {
            for (File fil : f.listFiles()) {
                if (fil.isDirectory()) {
                    directories.add(fil.getName());

                }
            }
        }
        return directories;
    }

    public List<String> listFilesByExtension(String directory, String extension) {
        List<String> filesListByExtension = new ArrayList<>();
//        File f = new File(directory);
//        final String EXTENSION_SEPARATOR = ".";
//        final List<String> EXTENSIONS = Arrays.asList(extension);
//
//        if (f.exists() && f.isDirectory()) {
//
//            public boolean accept (File f, String name)
//            {
//                String extension = "";
//                int index = name.lastIndexOf(EXTENSION_SEPARATOR);
//                if (index >= 0 && index < name.length() - 1) {
//                    extension = name.substring(index + 1);
//                }
//                return EXTENSIONS.contains(extension);
//            }
//
//        }
        return filesListByExtension;
    }
}
