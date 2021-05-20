import javax.swing.*;
import java.awt.*;
import java.net.PortUnreachableException;
import java.util.ArrayList;
import java.util.Random;

public class Snake {

    private ArrayList<Node> list;
    private Direction direction;
    private Color color = Color.green;
    private boolean gameOver;
    private int nodesToGrow = 0;



    public boolean isGameOver() {
        return gameOver;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Snake(){
        list = new ArrayList<Node>();
        direction = Direction.RIGHT;
        gameOver = false;
        list.add(new Node(Board.COLS / 2, Board.ROWS / 2));
        //list.add(new Node(Board.COLS / 2, (Board.ROWS / 2) - 1));

    }

    public void draw (Graphics g){

        for (Node node: list) {
            node.draw(g, color);
        }

    }


    public Node getHead(){
        return list.get(list.size()-1);
    }


    public void moveSnake(Food f){

        Node head = getHead();
        int nextRow, nextCol;

            if (direction == Direction.LEFT ){
                nextRow = head.getRow();
                nextCol = head.getCol() - 1;

            }else if (direction == Direction.RIGHT ){
                nextRow = head.getRow();
                nextCol = head.getCol() + 1;

            }else if (direction == Direction.UP){
                nextRow = head.getRow() - 1;
                nextCol = head.getCol();

            }else {
                nextRow = head.getRow() + 1;
                nextCol = head.getCol() ;

            }
            moveAndGrow(f, head, nextRow, nextCol);

    }

    private void moveAndGrow(Food f, Node head, int nextRow, int nextCol) {
        if (canMove(nextRow, nextCol)) {
            if (eat_Food(f, head)) {
                nodesToGrow ++;
                f.setRndPosition();

            }

            list.add(new Node(nextRow, nextCol));
            if (nodesToGrow == 0){
                list.remove(0);
            }else{
                nodesToGrow --;
            }


        } else {
            gameOver = true;
        }
    }

    public boolean eat_Food(Food f, Node n) {
        return f.getRow() == n.getRow() && f.getCol() == n.getCol();
    }


    public boolean canMove( int row, int col) {

        if ((row >= Board.ROWS) || (col >= Board.COLS) || (row < 0 )|| (col < 0)) {
            return false;
        }
        return true;
    }

}
