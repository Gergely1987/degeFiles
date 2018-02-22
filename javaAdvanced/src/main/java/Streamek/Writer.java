package Streamek;

import java.io.*;

public class Writer {

    public void writeSingleChar(){
        try {
            FileOutputStream fos = new FileOutputStream("C:\\GIT\\gyak\\javaAdvanced\\inAndOut\\test.txt");
            fos.write(65);
            fos.flush();
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeString(){
        try {
            FileOutputStream fos=new FileOutputStream("C:\\GIT\\gyak\\javaAdvanced\\inAndOut\\test1.txt");
     String text="San Joséból jöttem, mesterségem címere";
       byte a[]=text.getBytes();
            fos.write(a);
            fos.flush();
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void bufferedWriter(){
        try {
            FileOutputStream fos=new FileOutputStream("C:\\GIT\\gyak\\javaAdvanced\\inAndOut\\test2.txt");
BufferedOutputStream bos=new BufferedOutputStream(fos);
String txt="ejjj hajmási néni, innen kezdődik a bufferelés";
byte [] a=txt.getBytes();
bos.write(a);
bos.flush();
bos.close();
fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
