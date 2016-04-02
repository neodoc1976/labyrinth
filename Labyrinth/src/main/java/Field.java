/**
 * Created by Yulya on 01.04.2016.
 */
public class Field {
    char[][] cells;
    Walker walker;

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
        if (x > cells[0].length - 1) {
            System.out.println("Не можу рухатися в заданному напрямку");
        } else {
            walker.oneRight();
        }


    }

    public void goLeft(Walker walker) {
        int x = walker.getX() - 1;
        if (x < 0) {
            System.out.println("Не можу рухатися в заданному напрямку");
        } else {
            walker.oneLeft();
        }


    }

    public void goUp(Walker walker) {
        int y = walker.getY() - 1;
        if (y < 0) {
            System.out.println("Не можу рухатися в заданному напрямку");
        } else {
            walker.oneUp();
        }
    }


    public void goDown(Walker walker) {
        int y = walker.getY() + 1;
        if (y > cells.length - 1) {
            System.out.println("Не можу рухатися в заданному напрямку");
        } else {
            walker.oneDown();
        }

    }
}


