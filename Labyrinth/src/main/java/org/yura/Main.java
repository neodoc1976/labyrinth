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
                {new Cell(REGULAR),  new Cell(REGULAR),new Cell(REGULAR), new Cell(REGULAR), new Cell (REGULAR),new Cell(REGULAR),new Cell(REGULAR),new Cell(REGULAR),new Cell(REGULAR),new Cell(REGULAR),new Cell(REGULAR)},
                {new Cell(REGULAR),  new Cell(REGULAR),new Cell(TRAP), new Cell(REGULAR), new Cell (WALL),new Cell(REGULAR),new Cell(REGULAR),new Cell(REGULAR),new Cell(REGULAR),new Cell(REGULAR),new Cell(REGULAR)},
                {new Cell(REGULAR),  new Cell(WALL),new Cell(REGULAR), new Cell(WALL), new Cell (REGULAR),new Cell(REGULAR),new Cell(TRAP),new Cell(REGULAR),new Cell(REGULAR),new Cell(REGULAR),new Cell(REGULAR)},
                {new Cell(REGULAR),  new Cell(REGULAR),new Cell(REGULAR), new Cell(REGULAR), new Cell (REGULAR),new Cell(REGULAR),new Cell(REGULAR),new Cell(TRAP),new Cell(WALL),new Cell(REGULAR),new Cell(REGULAR)},
                {new Cell(REGULAR),  new Cell(REGULAR),new Cell(REGULAR), new Cell(REGULAR), new Cell (REGULAR),new Cell(WALL),new Cell(REGULAR),new Cell(REGULAR),new Cell(REGULAR),new Cell(REGULAR),new Cell(REGULAR)},


        };
        field.setCells(cells);
        field.setWalker(walker);

        while (true) {
            field.printField();
            System.out.println();

            System.out.println("Введіть варіант бажаного напрямку кроку термінами 'up','down','right','left':");
            String state = sc.nextLine();

            switch (state) {
                case UP:

                    field.goUp(walker);

                    break;
                case DOWN:

                    field.goDown(walker);

                    break;
                case RIGHT:


                    field.goRight(walker);

                    break;
                case LEFT:


                    field.goLeft(walker);

                    break;
                case "exit":
                    System.exit(0);
                default:
                    System.out.println("Невірний тип команди,повторіть:.");


            }
        }
    }
}
