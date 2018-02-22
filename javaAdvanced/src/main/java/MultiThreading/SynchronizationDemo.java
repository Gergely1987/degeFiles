package MultiThreading;

public class SynchronizationDemo {

    private static int count;

    public static synchronized void addToCouunt(){
        count++;
    }

    public static void main(String[] args) throws InterruptedException {

        //belső osztálybqn hozzuk létre a threadet

        Thread t1=new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i <120000 ; i++) {
                  //  count++;
                    addToCouunt();
                }
            }
        });

        Thread t2=new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i <120000 ; i++) {
                 //   count++;
                    addToCouunt();
                }
            }
        });

        t1.start();
        t2.start();
        //itt már 3 ág van t1, t2 és a main, ha most sout-olunk akkor a count értéke 0 marad
        t1.join(); //ilyenkor a start szulak kerülnek előtérbe és azok futnak le először
        t2.join();
        //Atomic : ha valami megzavarja a folyamatot akkor nem fut le (nem növeli a count értékét), és ezért a count értéke itt nem éri el a 24000-et ahogy várjuk, ebben az esetben az okozza a hibát, hogy a két szál egyszerre akar módosítani a count-on és ott leáll
        //24000-count értéke = ennyiszzer akartak egyszerre hozzányúlni a count-hoz

       // DE ha synchronized metóudussal végezzük el ugyanezt a növelést (addToCount()) akkor elkerülhető, hogy egyszerre akarjon a két szál hozzányúlni a COUNT változóhoz
        // a synchronized esetben volatile-vé is válik egyúttal maga a COUNT változó, így nem történik cachelés
        System.out.println("count értéke: "+count);


    }
}
