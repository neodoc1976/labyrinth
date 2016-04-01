/**
 * Created by Yulya on 01.04.2016.
 */
public class Field {
    char[][] cells;
    Walker walker;

    public void setCells(char[][] c) {
        cells = c;

    }
    public void setWalker (Walker w){
        walker = w;
    }

    public void printField() {
        int a = walker.getX();
        int b = walker.getY();
        for (int y = 0; y < cells.length; y++) {
            for (int x = 0; x < cells[y].length; x++) {
                if (a == x && b == y) {
                    System.out.print("R");
                    System.out.print(" ");

                } else {

                    System.out.print(cells[y][x]);
                    System.out.print(" ");
                }
            }

            System.out.println();
        }
    }
}


