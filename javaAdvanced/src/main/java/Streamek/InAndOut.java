package Streamek;

import java.io.IOException;

public class InAndOut {

    public static void main(String[] args) {
        Writer w=new Writer();
       // w.writeSingleChar();
        Reader r=new Reader();
        r.readSingleChar();
        w.bufferedWriter();
      //  w.writeString();
        r.readString();
        r.bufferedRead();
        try {
            int something = System.in.read();
            System.out.println(something);
            System.out.println((char)something);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Gyula");
        System.err.println("baj van Gerikém");

    }
}
