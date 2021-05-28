import javax.swing.*;
import java.awt.*;
import java.net.PortUnreachableException;
import java.util.ArrayList;
import java.util.Random;

public class Snake implements Incrementer{

    private ArrayList<Node> list;
    private Direction direction;
    private Color color = Color.green;
    private boolean gameOver;
    private int nodesToGrow = 0;

    private Incrementer scoreBoardIncrementer;


    public boolean isGameOver() {
        return gameOver;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Snake(Incrementer scoreBoardIncrementer){

        this.scoreBoardIncrementer = scoreBoardIncrementer;
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


    public void moveSnake(Food f, SpecialFood specialFood){

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
            moveAndGrow(f, specialFood, head, nextRow, nextCol);

    }

    private void moveAndGrow(Food f, SpecialFood specialFood, Node head, int nextRow, int nextCol) {
        if (canMove(nextRow, nextCol) && !colision()) {
            if (eat_Food(f,  head)) {
                scoreBoardIncrementer.increment(10);
                nodesToGrow ++;
                f.setRndPosition();
            }

            if (eat_Special_Food(specialFood, head)){
                scoreBoardIncrementer.increment(30);
                nodesToGrow +=3;
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



    private boolean eat_Special_Food(SpecialFood specialFood, Node head) {
        return (specialFood.getRow() == head.getRow() && specialFood.getCol() == head.getCol());
    }

    public boolean eat_Food(Food f, Node head) {
        return (f.getRow() == head.getRow() && f.getCol() == head.getCol());
    }


    public boolean canMove( int row, int col) {

        if ((row >= Board.ROWS) || (col >= Board.COLS) || (row < 0 )|| (col < 0)) {
            return false;
        }
        return true;
    }

    public boolean colision(){
        boolean colision = false;
        Node head = getHead();

        for (int i = 0; i < list.size()-2; i++) {
            if (list.get(i).getRow() == head.getRow() && list.get(i).getCol() == head.getCol()){
                colision = true;
                //System.out.println("la serpiente se ha tocado.");
                break;
            }
        }

        return colision;
    }

    @Override
    public void increment(int inc) {

    }
}
