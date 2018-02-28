package iostream;

import java.io.*;

public class FileCopy {


    public void copyFile(String source, String target) {
        if (source.trim().isEmpty() || target.trim().isEmpty()) {
            throw new IllegalArgumentException("Source or target file name must not be empty");
        }

        File f = new File(source);
        if (!f.exists()) {
            throw new IllegalArgumentException("Source file cannot be found!");
        }

        byte[] buffer = new byte[1024];
        try (
                InputStream in = new BufferedInputStream(new FileInputStream(source));
                OutputStream out = new BufferedOutputStream(new FileOutputStream(target))) {

            int lengthRead;
            while ((lengthRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, lengthRead);
                out.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void copyFile(File source, File target) {
        if (source == null || target == null) {
            throw new IllegalArgumentException("Source or target file name must not be empty");
        }
        if (!source.exists()) {
            throw new IllegalArgumentException("Source file cannot be found!");
        }
        byte[] buffer = new byte[1024];
        try (
                InputStream in = new BufferedInputStream(new FileInputStream(source));
                OutputStream out = new BufferedOutputStream(new FileOutputStream(target))) {

            int lengthRead;
            while ((lengthRead = in.read(buffer)) > 0) {
                System.out.println(in.toString());
                out.write(buffer, 0, lengthRead);
                out.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
