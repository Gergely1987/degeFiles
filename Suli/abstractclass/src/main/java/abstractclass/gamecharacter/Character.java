package abstractclass.gamecharacter;

import java.util.Random;

public abstract class Character {

    private Point position;
    private int hitPoint=100;
    private Random random;

    public Character(Point position, Random random) {
    }

    public Point getPosition() {
        return position;
    }

    public int getHitPoint() {
        return hitPoint;
    }

    public Random getRandom() {
        return random;
    }

    public boolean isAlive(){
        if(hitPoint>0){
            return true;
        }
        return false;
    }

    protected int getActualPrimaryDamage(){
        int a=random.nextInt(6);
        return a;
    }

    private int getActualDefence(){
        int a=random.nextInt(6);
        return a;
    }

    protected void hit(Character enemy, int damage){
        if(getActualDefence()<damage){
            enemy.decreaseHitPoint(damage - getActualDefence());
        }
    }

    public void primaryAttack(Character enemy){
        hit(enemy, getActualPrimaryDamage());
    }

    private void decreaseHitPoint(int diff){
        hitPoint=hitPoint-diff;

    }

    public abstract void secondaryAttack(Character enemy);

}

