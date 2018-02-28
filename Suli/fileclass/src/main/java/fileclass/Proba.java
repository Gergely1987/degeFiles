package fileclass;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Proba {

    public void createNewFile(String place, String name) {
        File f = new File(place + "\\" + name);
        f.mkdirs();
    }

    public void createNewDirectory(String place, String name, String extension) {
        File f = new File(place + "\\" + name + "." + extension);
        try {
            f.createNewFile();
        } catch (IOException e) {
            System.out.println("createNewDirectory-nál hiba");
        }
    }


    public String writingOut(String str) {
        StringBuilder a = new StringBuilder(str);
        for (int i = 0; i < 25 - str.length(); i++) {
            a.append(" ");
        }
        if (a.length() > 25) {
            String b = a.substring(0, 25);
            return b;
        }
        return a.toString();
    }

    public String writingOut2(String str) {
        StringBuilder a = new StringBuilder(str);
        for (int i = 0; i < 15 - str.length(); i++) {
            a.append(" ");
        }
        if (a.length() > 15) {
            String b = a.substring(0, 15);
            return b;
        }
        return a.toString();
    }

    public String dateToString(Date d){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String dd=sdf.format(d);
        return dd;
    }

    public void startTheProgram(String str) {
        Scanner sc = new Scanner(System.in);

        File f = new File(str);

        if (f.isFile()) {
            try {

                Runtime.getRuntime().exec(new String[]{"cmd.exe", "/C", f.getAbsolutePath()});
                System.out.println(f.getAbsolutePath());
                startTheProgram(f.getParent());

            } catch (IOException e) {
                System.out.println("Cannot find the file"+f.getAbsolutePath());
            }
        }

        if (f.exists() && f.isDirectory()) {
            int count = 0;
            List<String> counters = new ArrayList<>();
            System.out.println(count + " ....");
            counters.add("");
            count++;
            for (File file : f.listFiles()) {

                if (file.isDirectory()) {
                    if (count < 10) {
                        System.out.println(count + ".  " + writingOut(file.getName()) + "   |");
                    } else {
                        System.out.println(count + ". " + writingOut(file.getName()) + "   |");
                    }
                } else {
                    Date d = new Date(file.lastModified());
                    if (count < 10) {
                        System.out.println(count + ".  " + writingOut(file.getName()) + "   |" + " " + writingOut2(file.length() + "bit ") + dateToString(d));
                    } else {
                        System.out.println(count + ". " + writingOut(file.getName()) + "   |" + " " + writingOut2(file.length() + "bit ") + "bit " + dateToString(d));
                    }
                }
                counters.add(file.getName());
                count++;
            }
            System.out.println("choose number and push Enter:");

            int a = sc.nextInt();
            if (a == 0) {
                if (f.getParent() == null) {
                    if (f.getAbsolutePath().equals("D:\\")) {
                        startTheProgram("C:\\");
                    } else {
                        startTheProgram("D:\\");
                    }
                } else if (f.getParent() != null) {
                    {
                        String[] arr = f.getAbsolutePath().split("\\\\");
                        String s = "";
                        for (int i = 0; i < arr.length - 1; i++) {
                            s += arr[i];
                        }
                        startTheProgram(s);
                    }
                }
            }

            if (f.isDirectory()) {
                if (a > counters.size() || a < 0) {
                    System.out.println("give me valid number");
                    startTheProgram(f.getAbsolutePath());
                } else {
                    for (int i = 0; i < counters.size(); i++) {
                        if (a == i) {
                            String path = f.getAbsolutePath() + "\\" + counters.get(i);
                            System.out.println(path);
                            startTheProgram(path);
                        }
                    }
                }

            }


        }
    }


    public static void main(String[] args) throws IOException {
        Proba p = new Proba();
        p.startTheProgram("D:\\");

    }
}
