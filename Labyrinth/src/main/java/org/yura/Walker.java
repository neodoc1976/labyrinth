package org.yura;

/**
 * Created by Yulya on 01.04.2016.
 */
public class Walker {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void oneRight() {
        x++;
    }

    public void oneLeft() {
        x--;

    }

    public void oneUp() {
        y--;
    }

    public void oneDown() {
        y++;
    }
}
