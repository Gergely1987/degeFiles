package MultiThreading;

import javafx.concurrent.Task;

//két módja van a multirhreading-nek, egyszer leszármazni a Thread-től, vagy kiterjeszteni a Runnable interfészt

//class Tasker extends Thread{
//    public void run(){
//        for (int i = 0; i <5 ; i++) {
//            System.out.println("mellékszál: "+i);
//
//            try {
//                Thread.sleep(1000); //időzítek
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}

class Tasker implements Runnable{
    public void run(){
        for (int i = 0; i <5 ; i++) {
            System.out.println("mellékszál: "+i);

            try {
                Thread.sleep(1000); //időzítek
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class MultiThreading {
    public static void main(String[] args) {
//        Tasker task1=new Tasker();
//        Tasker task2=new Tasker();
//        task1.start(); //a két objektum egymás mellett megy
//        task2.start();

        Thread t1=new Thread(new Tasker());
        Thread t2=new Thread(new Tasker());
        t1.start();
        t2.start();
    }
}
