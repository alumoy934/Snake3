import java.awt.*;

public class Node {

    private int xCoor;
    private int yCoor;
    private int width, height;

    public Node(int xCoor, int yCoor, int sizeNode){
        this.xCoor = xCoor;
        this.yCoor = yCoor;
        width = sizeNode;
        height = sizeNode;
    }

    public int getxCoor() {
        return xCoor;
    }

    public void setxCoor(int xCoor) {
        this.xCoor = xCoor;
    }

    public int getyCoor() {
        return yCoor;
    }

    public void setyCoor(int yCoor) {
        this.yCoor = yCoor;
    }


}
