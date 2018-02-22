package TestCollections;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Queuek  {
    //FIFO módszer

    public static void main(String[] args) {
        //priorityQueue csak az elsővel törődik mint FIFO, utána minden egyes poll után újra rendeződik a queue, mivel csak 1 objektumra figyel így mindig nagyon gyors
        Queue queu=new PriorityQueue();
        queu.offer("első Gizike");
        System.out.println(queu);
        queu.offer("második Gyulus");
        System.out.println(queu);
        queu.offer("harmadik Császár");
        System.out.println(queu);

        System.out.println(queu.peek());
        queu.poll();
        System.out.println(queu);
        queu.poll();
        System.out.println(queu);

        //ha számít a folyamatos sorrend fenntartása:
        Queue qu=new LinkedList();
        byte var1 = -51, var2 = -28;
        System.out.println(var1 & var2);
    }
}
