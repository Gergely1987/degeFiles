package MultiThreading;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class TaskUnit implements Runnable{
    private int id;

    public TaskUnit(int id){
        this.id=id;
    }

    @Override
    public void run(){
        System.out.println("Feladat indult. id: "+id);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Feladat elkészült. id: "+id);
    }
}

public class Executor {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2); //megadjuk, hogy hány szálat kell kezelni
        for (int i = 1; i <=5 ; i++) {
            executor.submit(new TaskUnit(i));
        }
        executor.shutdown();

        System.out.println("minden munka ki lett osztva");

        executor.awaitTermination(60, TimeUnit.SECONDS); // 10 sec-ig vár max a feladat végrehajtásával
        System.out.println("készen van az összes munka");
    }
}
//fixált méretű medence kerül létrehozásra