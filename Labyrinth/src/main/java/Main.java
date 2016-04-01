/**
 * Created by Yulya on 01.04.2016.
 */
public class Main {
    public static void main(String[] args) {
        Field field = new Field();
        Walker walker = new Walker();
        char[][] cells = {
                {'o', 'o', 'o', 'o', 'o', 'o'},
                {'o', 'x', 'x', 'o', 'o', 'o'},
                {'o', 'o', 'o', 'x', 'x', 'o'},
                {'o', 'o', 'o', 'o', 'o', 'o'},
                {'o', 'o', 'o', 'o', 'o', 'o'}};
        field.setCells(cells);
        field.setWalker(walker);
        //field.printField();
        walker.oneRight();
        walker.oneDown();
        field.printField();

    }
}
