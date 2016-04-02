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
        char[][] cells = {
                {REGULAR, REGULAR, REGULAR,REGULAR, REGULAR, REGULAR},
                {REGULAR, WALL, WALL,REGULAR, REGULAR, REGULAR},
                {REGULAR, REGULAR, REGULAR, WALL, WALL, REGULAR},
                {REGULAR, REGULAR, REGULAR,REGULAR, REGULAR, REGULAR},
                {REGULAR, REGULAR, REGULAR,REGULAR, REGULAR, REGULAR},


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
