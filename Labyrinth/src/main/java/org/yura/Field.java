package org.yura;

import static org.yura.Walker.*;

/**
 * Created by Yulya on 01.04.2016.
 */
public class Field {
    Cell[][] cells;
    Walker walker;
    public static final char REGULAR = 'o';//Список констант (символів),що відображають тип поля.
    public static final char WALL = '*';

    public void setCells(Cell[][] c) {
        cells = c;

    }

    public void setWalker(Walker w) {
        walker = w;
    }

    public void printField() {
        int a = walker.getX();
        int b = walker.getY();
        String d = walker.getDirection();

        printGorizontaLine(cells[0].length + 2);
        System.out.println();


        for (int y = 0; y < cells.length; y++) {
            System.out.print("| ");


            for (int x = 0; x < cells[y].length; x++) {
                if (a == x && b == y) {
                    switch (d) {
                        case RIGHT:
                            System.out.print("> ");
                            break;

                        case LEFT:
                            System.out.print("< ");
                            break;

                        case UP:
                            System.out.print("^ ");
                            break;

                        case DOWN:
                            System.out.print("v ");
                            break;

                    }
                    // System.out.print("R");
                    // System.out.print(" ");
                } else {
                    System.out.print(cells[y][x].getType());
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
        if (x > cells[0].length - 1 || cells[y][x].getType() == WALL) {
            printMessage();
            walker.decreaseHp();
            System.out.println("НР робота "+walker.getHp()+"%");

            if (walker.getHp()== 10) {
                System.out.println("Обережно,у робота залишилося HP на один невірний крок!");
            }
            if (walker.getHp() == 0) {
                System.out.println("Робот загинув :(");
                System.out.println("GAME OVER");
                System.exit(0);


            }


        } else

        {
            walker.oneRight();
            System.out.println("НР робота "+walker.getHp()+"%");

        }


    }

    public void goLeft(Walker walker) {
        int x = walker.getX() - 1;
        int y = walker.getY();
        if (x < 0 || cells[y][x].getType() == WALL) {
            printMessage();
            walker.decreaseHp();
            System.out.println("НР робота "+walker.getHp()+"%");

            if (walker.getHp()== 10) {
                System.out.println("Обережно,у робота залишилося HP на один невірний крок!");
            }
            if (walker.getHp() == 0) {
                System.out.println("Робот загинув :(");
                System.out.println("GAME OVER");
                System.exit(0);


            }
        } else {
            walker.oneLeft();
            System.out.println("НР робота "+walker.getHp()+"%");

        }


    }

    public void goUp(Walker walker) {
        int y = walker.getY() - 1;
        int x = walker.getX();
        if (y < 0 || cells[y][x].getType() == WALL) {
            printMessage();
            walker.decreaseHp();
            System.out.println("НР робота "+walker.getHp()+"%");
            if (walker.getHp()== 10) {
                System.out.println("Обережно,у робота залишилося HP на один невірний крок!");
            }
            if (walker.getHp() == 0) {
                System.out.println("Робот загинув :(");
                System.out.println("GAME OVER");
                System.exit(0);


            }
        } else {
            walker.oneUp();
            System.out.println("НР робота "+walker.getHp()+"%");

        }
    }


    public void goDown(Walker walker) {
        int y = walker.getY() + 1;
        int x = walker.getX();
        if (y > cells.length - 1 || cells[y][x].getType() == WALL) {
            printMessage();
            walker.decreaseHp();
            System.out.println("НР робота "+walker.getHp()+"%");

            if (walker.getHp()== 10) {
                System.out.println("Обережно,у робота залишилося HP на один невірний крок!");
            }
            if (walker.getHp() == 0) {
                System.out.println("Робот загинув :(");
                System.out.println("GAME OVER");
                System.exit(0);

 {

}

            }

        } else {
            walker.oneDown();
            System.out.println("НР робота "+walker.getHp()+"%");

        }

    }

    private void printMessage() {
        System.out.println("Не можу рухатися в заданному напрямку!");
    }
}



