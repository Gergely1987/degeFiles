package abstractclass.gamecharacter;

import java.util.Random;

public class Point {

    private long x;
    private long y;

    public long distance(Point point){
        long a=(point.getX()-x)*(point.getX()-x)+(point.getY()-y)*(point.getY()-y);
        long b= (long) Math.sqrt(a);
        return b;
    }

    public Point(long x, long y) {
        this.x = x;
        this.y = y;
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }


}
