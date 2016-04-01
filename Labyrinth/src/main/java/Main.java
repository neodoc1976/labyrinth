import java.util.Scanner;

/**
 * Created by Yulya on 01.04.2016.
 */
public class Main {
    public static void main(String[] args) {
        Field field = new Field();
        Walker walker = new Walker();
        Scanner sc = new Scanner(System.in);
        char[][] cells = {
                {'o', 'o', 'o', 'o', 'o', 'o'},
                {'o', 'x', 'x', 'o', 'o', 'o'},
                {'o', 'o', 'o', 'x', 'x', 'o'},
                {'o', 'o', 'o', 'o', 'o', 'o'},
                {'o', 'o', 'o', 'o', 'o', 'o'}};
        field.setCells(cells);
        field.setWalker(walker);
        //field.printField();
        // walker.oneRight();
        // walker.oneRight();
        //walker.oneDown();
        // field.printField();
        while (true) {
            System.out.println("Введіть варіант бажаного напрямку кроку термінами 'up','down','right','left':");
            String state = sc.nextLine();
            switch (state) {
                case "up":
                case "u":
                    walker.oneUp();
                    field.printField();
                    break;
                case "down":
                case "d" :
                    walker.oneDown();
                    field.printField();
                    break;
                case "right":
                case "r":
                    walker.oneRight();
                    field.printField();
                    break;
                case "left":
                case"l":
                    walker.oneLeft();
                    field.printField();
                    break;
                case "exit":
                    System.exit(0);
                default:
                    System.out.println("Невірний тип команди,повторіть:.");

            }
        }
    }
}
