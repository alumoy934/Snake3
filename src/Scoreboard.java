import javax.swing.*;
import java.awt.*;
import java.util.Date;

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
        label.setText(DatesConfig.username + ": " +  score);
    }


}
