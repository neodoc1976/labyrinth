/**
 * Created by Yulya on 01.04.2016.
 */
public class Field {
    char [][] cells;

    public void setCells (char [][] c){
        cells=c;

    }
    public void printField (){
        for (int x=0;x<cells.length;x++){
            for (int y=0;y<cells[x].length;y++){
                System.out.print( cells [x][y] );
            }
            System.out.println();
        }
    }
}
