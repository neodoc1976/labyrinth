package org.yura;

import java.util.Scanner;

import static org.yura.Field.*;
import static org.yura.Walker.*;

/**
 * Created by Yulya on 01.04.2016.
 */
public class Main {

    public static void main(String[] args) {
        Field field = new Field();
        Walker walker = new Walker();
        Scanner sc = new Scanner(System.in);
        Cell[][] cells = {
                {new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR),new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR)},
                {new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR),new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR)},
                {new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR),new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR)},
                {new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR),new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR)},
                {new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR),new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR)},
                {new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR),new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR)},
                {new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR),new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR)},
                {new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR),new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR)},
                {new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR),new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR)},
                {new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR),new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR), new Cell(REGULAR)},
        };
        field.setCells(cells);
        field.setWalker(walker);

        while (true) {
            field.printField();
            System.out.println();
            System.out.println("Поточні координати робота: вісь X(" + (walker.getX())+")" + ",вісь Y(" + (walker.getY())+")");
            System.out.println();
            System.out.println("Зробіть вибір дії: крок (символ 's') ,або поворот на місці (символ 't'):");
            String variant = sc.nextLine();
            switch (variant) {

                case STEP:

                    System.out.println("Введіть варіант бажаного напрямку КРОКУ термінами 'up','down','right','left':");
                    String state = sc.nextLine();
                    switch (state) {
                        case UP:

                            field.goUp(walker);
                            break;

                        case DOWN:

                            field.goDown(walker);
                            break;

                        case RIGHT:

                            field.goRight();
                            break;

                        case LEFT:

                            field.goLeft(walker);
                            break;

                        case "exit":
                            System.exit(0);

                        default:
                            System.out.println("Невірний тип команди,повторіть:.");
                            break;

                    }
                    break;

                case TURN:
                    System.out.println("Введіть варіант бажаного напрямку ПОВОРОТУ термінами 'up','down','right','left':");
                    String around = sc.nextLine();
                    switch (around) {
                        case UP:

                            walker.turnUp();
                            break;

                        case DOWN:

                            walker.turnDown();
                            break;

                        case RIGHT:

                            walker.turnRight();
                            break;

                        case LEFT:

                            walker.turnLeft();
                            break;

                        case "exit":
                            System.exit(0);

                        default:
                            System.out.println("Невірний тип команди,повторіть:.");
                            break;

                    }

                    break;

                default:
                    System.out.println("Невірний тип команди,повторіть:.");
                    break;
            }

        }
    }

}





