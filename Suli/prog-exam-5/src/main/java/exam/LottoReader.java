package exam;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LottoReader {


    List<Integer> totalNums = new ArrayList<>();


    public LottoReader() {
        try (BufferedReader br = new BufferedReader(new FileReader("data\\otos.csv"));) {

            String s = "";
            while ((s = br.readLine()) != null) {
                // System.out.println(s);
                String[] array = s.split(";");
                int a = Integer.parseInt(array[11]);
                int b = Integer.parseInt(array[12]);
                int c = Integer.parseInt(array[13]);
                int d = Integer.parseInt(array[14]);
                int e = Integer.parseInt(array[15]);

                totalNums.add(a);
                totalNums.add(b);
                totalNums.add(c);
                totalNums.add(d);
                totalNums.add(e);

            }
            //System.out.println(totalNums);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getNumber(int i) {
        int counter = 0;
        for (int j = 0; j < totalNums.size(); j++) {
            if (totalNums.get(j) == i) {
                counter++;
            }
        }
        return counter;
    }

}
