import javax.swing.*;
import java.awt.*;
import java.net.PortUnreachableException;
import java.util.ArrayList;
import java.util.Random;

public class Snake {

    private ArrayList<Node> list;
    private Direction direction;
    private Color color = Color.green;



    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Snake(){
        list = new ArrayList<Node>();
        direction = Direction.RIGHT;
        list.add(new Node(Board.COLS / 2, Board.ROWS / 2));
        list.add(new Node(Board.COLS / 2, (Board.ROWS / 2) - 1));

    }

    public void draw (Graphics g){

        for (Node node: list) {
            node.draw(g, color);
        }

    }

    public void grow_Snake(){
        Node n = list.get(list.size()-1);
        //System.out.println(n.getRow() + " | " + n.getCol());
        list.add(new Node(n.getRow(), n.getCol()+1));

    }



    public void move_Snake(Food f){


        Node n = list.get(list.size()-1);
        if (canMove()){
            if (direction == Direction.LEFT ){

                list.add(new Node(n.getRow(), n.getCol() - 1));
                list.remove(0);
                if (eat_Food(f, n)) {
                    list.add(new Node(n.getRow(), n.getCol() - 1));

                }

            }else if (direction == Direction.RIGHT ){

                list.add(new Node(n.getRow(), n.getCol() + 1));
                list.remove(0);
                if ((eat_Food(f, n))) {
                    list.add(new Node(n.getRow(), n.getCol() + 1));
                }

            }else if (direction == Direction.UP){

                list.add(new Node(n.getRow() - 1, n.getCol()));
                list.remove(0);
                if ((eat_Food(f, n))) {
                    list.add(new Node(n.getRow() - 1, n.getCol()));
                }

            }else if (direction == Direction.DOWN){

                list.add(new Node(n.getRow() + 1, n.getCol()));
                list.remove(0);
                if ((eat_Food(f, n))) {
                    list.add(new Node(n.getRow() + 1, n.getCol()));
                }

            }
        }

    }

    public boolean eat_Food(Food f, Node n) {
        return f.getRow() == n.getRow() && f.getCol() == n.getCol();
    }


    public boolean canMove() {
        boolean next_movement = true;
        int current_row = list.get(list.size()-1).getRow();
        int current_col = list.get(list.size()-1).getCol();

        if((current_row + 1) > Board.ROWS || (current_row - 1) < 0){
            next_movement = false;

        }

        if((current_col +1 > Board.COLS) || (current_col - 1) < 0){
            next_movement = false;

        }
        return next_movement;
    }

}
