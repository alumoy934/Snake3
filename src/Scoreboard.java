import javax.swing.*;
import java.awt.*;

public class Scoreboard extends JPanel {

    private int score;
    private JLabel label;

    public Scoreboard() {

        score = 0;
        initGUI();
    }

    public void initGUI() {
        setLayout(new FlowLayout());
        setBackground(Color.BLACK);
        label = new JLabel();


        add(label);
        increment(0);
    }

    public void increment(int inc) {
        score += inc;
        label.setText("Score: " + score);
    }


}
