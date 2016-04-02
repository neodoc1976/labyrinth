package org.yura;

/**
 * Created by Yulya on 01.04.2016.
 */
public class Field {
    char[][] cells;
    Walker walker;
    public static final char REGULAR = 'o';//Список констант (символів),що відображають тип поля.
    public static final char WALL = '*';

    public void setCells(char[][] c) {
        cells = c;

    }

    public void setWalker(Walker w) {
        walker = w;
    }

    public void printField() {
        int a = walker.getX();
        int b = walker.getY();

        printGorizontaLine(cells[0].length + 2);
        System.out.println();


        for (int y = 0; y < cells.length; y++) {
            System.out.print("| ");


            for (int x = 0; x < cells[y].length; x++) {
                if (a == x && b == y) {
                    System.out.print("R");
                    System.out.print(" ");
                } else {
                    System.out.print(cells[y][x]);
                    System.out.print(" ");
                }
            }

            System.out.println("|");

        }
        printGorizontaLine(cells[0].length + 2);
    }

    private void printGorizontaLine(int length) {
        for (int c = 0; c < length; c++) {
            System.out.print("- ");
        }

    }


    public void goRight(Walker walker) {
        int x = walker.getX() + 1;// Майбутня координата Х куди має піти робот.
        int y = walker.getY(); //Майбутня координата Х куди має піти робот.(для визначення локації внутрішньої перешкоди)
        if (x > cells[0].length - 1 || cells[y][x] == WALL) {
            printMessage();

        } else {
            walker.oneRight();
        }


    }

    public void goLeft(Walker walker) {
        int x = walker.getX() - 1;
        int y = walker.getY();
        if (x < 0 || cells[y][x] == WALL) {
            printMessage();
        } else {
            walker.oneLeft();
        }


    }

    public void goUp(Walker walker) {
        int y = walker.getY() - 1;
        int x = walker.getX();
        if (y < 0 || cells[y][x] == WALL) {
            printMessage();
        } else {
            walker.oneUp();
        }
    }


    public void goDown(Walker walker) {
        int y = walker.getY() + 1;
        int x = walker.getX();
        if (y > cells.length - 1 || cells[y][x] == WALL) {
            printMessage();
        } else {
            walker.oneDown();
        }

    }

    private void printMessage() {
        System.out.println("Не можу рухатися в заданному напрямку");
    }
}


