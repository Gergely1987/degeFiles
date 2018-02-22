package Streamek;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Reader {

    public void readSingleChar(){

        try {
            FileInputStream fis = new FileInputStream("C:\\GIT\\gyak\\javaAdvanced\\inAndOut\\test.txt");
            int i=fis.read();
          //  System.out.println((char)i);
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readString(){
        try {
            FileInputStream fis=new FileInputStream("C:\\GIT\\gyak\\javaAdvanced\\inAndOut\\test1.txt");
            int i=0;

            StringBuilder sb=new StringBuilder();
            while((i=fis.read())!=-1){

                System.out.print((char)i);
                sb.append((char)i);
            }
            System.out.println();
            System.out.print(sb);
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void bufferedRead(){

        try {
            FileInputStream fis=new FileInputStream("C:\\GIT\\gyak\\javaAdvanced\\inAndOut\\test2.txt");
            BufferedInputStream bis=new BufferedInputStream(fis);
            int i=0;
            StringBuilder sb=new StringBuilder();
            while((i=fis.read())!=-1){
                sb.append((char)i);
            }
            System.out.println(sb);
            bis.close();
            fis.close();

       } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
