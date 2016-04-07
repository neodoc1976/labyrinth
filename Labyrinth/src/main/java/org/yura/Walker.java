package org.yura;

/**
 * Created by Yulya on 01.04.2016.
 */
public class Walker {
    public static final String UP="u";// Список констант для case,що вказуюють на тип кроку.
    public static final String DOWN="d";
    public static final String LEFT="l";
    public static final String RIGHT="r";

    private int hp=100;
    private int x;
    private int y;
    private String direction=RIGHT;



    public int getHp(){return hp;}
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getDirection(){ return direction;}

    public void oneRight() {
        x++;
        direction=RIGHT;
    }
    public void oneLeft() {
        x--;
        direction=LEFT;


    }

    public void oneUp() {
        y--;
        direction=UP;
    }

    public void oneDown() {
        y++;
        direction=DOWN;
    }
    public void lossLargePartHP(){hp=hp-25;}
    public void decreaseHp(){
        hp=hp-10;
    }
    public void turnRight(){
        direction=RIGHT;
    }
    public void turnLeft(){
        direction=LEFT;
    }
    public void turnUp(){
        direction=UP;
    }
    public void turnDown(){
        direction=DOWN;
    }
}
