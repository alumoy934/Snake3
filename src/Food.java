import java.util.Random;

public class Food extends Node{


    private final Random rnd;

    public Food() {

        super(0, 0);
        rnd = new Random();
        setRndPosition();

    }

    public void setRndPosition(){
        int row = rnd.nextInt(Board.ROWS);
        int col =  rnd.nextInt(Board.COLS);
        setRow(row);
        setCol(col);
    }

}
