package MultiThreading;

import java.util.Scanner;

class Tasker1 extends Thread {

    private volatile boolean runner =true; //így nem lesz cachelt a változó, néhány rendszeren futó JVM esetén menti a változó értékét, és később metódushívássla hiába módosítanánk, a cachelésből futtatja tovább
@Override
    public void run(){

        while(runner){
            System.out.println("Futok");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void kill(){
    this.runner=false;
    }
}

public class VolatileDemo {
    public static void mainer(String[] args) {
        //elindul a main szál

        //elindítjuk a másik szálat
        Tasker1 task = new Tasker1();
        task.start();

        System.out.println("nyomj entert a szüneteltetéshez");

        //a Main szál itt megáll entert nyomunk
        Scanner sc=new Scanner(System.in);
        sc.nextLine();
        //Entert nyomunk
        task.kill();

    }

}
