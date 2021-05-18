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
        direction = Direction.LEFT;
        list.add(new Node(Board.COLS / 2, Board.ROWS / 2));

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

    public void move_Snake(){
        boolean next_movement = true;
        int current_row = list.get(list.size()-1).getRow();
        int current_col = list.get(list.size()-1).getCol();

        if((current_row + 1) > Board.ROWS ){
            next_movement = false;
        }

        if((current_col +1 > Board.COLS)){
            next_movement = false;
        }

    }

}
