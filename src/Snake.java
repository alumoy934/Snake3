import java.util.ArrayList;

public class Snake {

    private ArrayList<Node> snake;
    private Direction direction;

    public Snake(){
        snake = new ArrayList<Node>();
        direction = Direction.LEFT;
    }

    public ArrayList<Node> getSnake() {
        return snake;
    }

    public void setSnake(ArrayList<Node> snake) {
        this.snake = snake;
    }
}
