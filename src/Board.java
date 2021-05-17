import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {

    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;


    public Board(){
        setFocusable(true);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

    }

}
