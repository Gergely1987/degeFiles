package fileclass;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Proba2 {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/pankaj/source.txt");

        //first check if Desktop is supported by Platform or not
        if(!Desktop.isDesktopSupported()){
            System.out.println("Desktop is not supported");
            return;
        }

        Desktop desktop = Desktop.getDesktop();
        if(file.exists()) desktop.open(file);
        //let's try to open PDF file
        file = new File("D:\\Zene\\VAN filmzenekar- Viszlek magammal.mp3");
        if(file.exists()) desktop.open(file);
    }
    }

