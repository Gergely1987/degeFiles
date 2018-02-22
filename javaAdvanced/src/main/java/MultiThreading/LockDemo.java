package MultiThreading;

import java.util.ArrayList;

class Locker{
    public ArrayList<Integer> numbers1 =new ArrayList<Integer>();
    public ArrayList<Integer> numbers2 =new ArrayList<Integer>();

    //ha a doorOne és a doorTwo metódust tesszük Syncronizeddé akkor a mind a numbers1 mind a numbers2 objektumot egyszerre csak egyik metódus tudja használni, mintha 1 kulcs lenne csak és így dupla annyi idő a futtatás

    //ezért létrehozunk két kulcsot hozzájuk és azokat tesszük syncronizeddé

    private Object key1=new Object();
    private Object key2=new Object();


//    public synchronized void doorOne() throws InterruptedException {
public void doorOne() throws InterruptedException {
    synchronized (key1){
        numbers1.add(10);
        Thread.sleep(1);
    };
    }

    public synchronized void doorTwo() throws InterruptedException {
    synchronized (key2){
        numbers2.add(10);
        Thread.sleep(1);
    }

    }

    public void doWork() throws InterruptedException {
        for (int i = 0; i <500 ; i++) {
            doorOne();
            doorTwo();
        }
    }
}
public class LockDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("kezdjük el");
//        long start=System.currentTimeMillis();
        final Locker locker=new Locker();
//
//        try {
//            locker.doWork();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        long end=System.currentTimeMillis();
//        System.out.println(end-start);

        long start1=System.currentTimeMillis();
        Thread t1=new Thread(new Runnable() {
            public void run() {
                try {
                    locker.doWork();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2=new Thread(new Runnable() {
            public void run() {
                try {
                    locker.doWork();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
//        t1.join();
//        t2.join();
        long end1=System.currentTimeMillis();
        System.out.println(end1-start1);
        System.out.println("Number1 size: "+locker.numbers1.size());
        System.out.println("Number2 size: "+locker.numbers2.size());
    }

}
