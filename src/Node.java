import javax.swing.*;
import java.awt.*;
import java.awt.Graphics.*;

public class Node {



    private int row;
    private int col;


    public Node(int row, int col){
        this.row = row;
        this.col = col;

    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }



    public void draw(Graphics g, Color color){

        g.setColor(color);
        g.fillRect(col * Board.SQUARE_WIDTH, row * Board.SQUARE_HEIGHT, Board.SQUARE_WIDTH, Board.SQUARE_HEIGHT);


    }


}
