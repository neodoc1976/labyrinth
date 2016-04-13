package org.yura;

import static org.yura.Walker.*;

/**
 * Created by Yulya on 01.04.2016.
 */
public class Field {
    Cell[][] cells;
    Walker walker;
    public static final char REGULAR = ' ';//Список констант (символів),що відображають тип поля.
    public static final char WALL = '*';
    public static final char TRAP = '#';
    public static final char MEDKIT = '+';
    public static final char TELEPORT = 'O';

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

    public void goRight() {

        int x = walker.getX() + 1;// Майбутня координата Х куди має піти робот.
        int y = walker.getY(); //Майбутня координата Х куди має піти робот.(для визначення локації внутрішньої перешкоди)

        if (x > cells[0].length - 1 || cells[y][x].getType() == WALL) {
            walker.turnRight();
            showHealthDecrease();
        } else if (cells[y][x].getType() == TRAP) {
            walker.oneRight();
            showTrapDamage();
            cells[walker.getY()][walker.getX()] = new Cell(REGULAR);
        } else if (cells[y][x].getType() == MEDKIT) {
            walker.oneRight();
            showMedCitHelp();
            cells[walker.getY()][walker.getX()] = new Cell(REGULAR);
        } else if (cells[y][x].getType() == TELEPORT) {
            walker.oneRight();
            walker.teleport();
            System.out.println("Робота телепортовано на початкову позицію!");
            printMessageHpLevel();

        } else {
            walker.oneRight();
            printMessageHpLevel();

        }

    }

    public void goLeft(Walker walker) {
        int x = walker.getX() - 1;
        int y = walker.getY();

        if (x < 0 || cells[y][x].getType() == WALL) {
            walker.turnLeft();
            showHealthDecrease();
        } else if (cells[y][x].getType() == TRAP) {
            walker.oneLeft();
            showTrapDamage();
            cells[walker.getY()][walker.getX()] = new Cell(REGULAR);
        } else if (cells[y][x].getType() == MEDKIT) {
            walker.oneLeft();
            showMedCitHelp();
            cells[walker.getY()][walker.getX()] = new Cell(REGULAR);
        } else if (cells[y][x].getType() == TELEPORT) {
            walker.oneLeft();
            walker.teleport();
            System.out.println("Робота телепортовано на початкову позицію!");
            printMessageHpLevel();
        } else {
            walker.oneLeft();
            printMessageHpLevel();
        }

    }

    public void goUp(Walker walker) {
        int y = walker.getY() - 1;
        int x = walker.getX();

        if (y < 0 || cells[y][x].getType() == WALL) {
            walker.turnUp();
            showHealthDecrease();
        } else if (cells[y][x].getType() == TRAP) {
            walker.oneUp();
            showTrapDamage();
            cells[walker.getY()][walker.getX()] = new Cell(REGULAR);
        } else if (cells[y][x].getType() == MEDKIT) {
            walker.oneUp();
            showMedCitHelp();
            cells[walker.getY()][walker.getX()] = new Cell(REGULAR);
        } else if (cells[y][x].getType() == TELEPORT) {
            walker.oneUp();
            walker.teleport();
            System.out.println("Робота телепортовано на початкову позицію!");
            printMessageHpLevel();
        } else {
            walker.oneUp();
            printMessageHpLevel();
        }
    }

    public void goDown(Walker walker) {
        int y = walker.getY() + 1;
        int x = walker.getX();

        if (y > cells.length - 1 || cells[y][x].getType() == WALL) {
            walker.turnDown();
            showHealthDecrease();
        } else if (cells[y][x].getType() == TRAP) {
            walker.oneDown();
            showTrapDamage();
            cells[walker.getY()][walker.getX()] = new Cell(REGULAR);
        } else if (cells[y][x].getType() == MEDKIT) {
            walker.oneDown();
            showMedCitHelp();
            cells[walker.getY()][walker.getX()] = new Cell(REGULAR);
        } else if (cells[y][x].getType() == TELEPORT) {
            walker.oneDown();
            walker.teleport();
            System.out.println("Робота телепортовано на початкову позицію!");
            printMessageHpLevel();
        } else {
            walker.oneDown();
            printMessageHpLevel();
        }

    }

    private void showMedCitHelp() {

        walker.applyMedkit();
        System.out.println("Робот знайшов аптечку,рівень здоров'я підвищився !");
        checkHealth();
    }

    private void showTrapDamage() {

        walker.lossLargePartHP();
        System.out.println("Уппс!!! Робот потрапив на міну!!! Втрачено значну частину НР!");
        checkHealth();
    }

    private void showHealthDecrease() {
        printMessageNotMove();
        walker.decreaseHp();
        checkHealth();
    }

    private void printMessageNotMove() {
        System.out.println("Не можу рухатися в заданному напрямку!");
        System.out.println("Втратив частину НР від удару об стіну!");
    }

    public void printMessageHpLevel() {
        System.out.println("НР робота" + walker.getHp() + "%");
    }

    private void checkHealth() {
        if (walker.getHp() <= 25 && walker.getHp() > 0) {
            System.out.println("Обережно,у робота залишилася незначна частка HP,наступний крок може призвести до загибелі!");
        } else if (walker.getHp() <= 0) {
            System.out.println("Робот загинув :(");
            System.out.println("Фінальна позиція робота,вісь X: " + (walker.getX() + 1) + " ,вісь Y: " + (walker.getY() + 1));
            System.out.println("GAME OVER");
            printField();
            System.exit(0);
        }

        printMessageHpLevel();
    }
}





