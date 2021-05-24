import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {

    private Scoreboard scoreboard;
    private Board board;
    private JToolBar toolBar;

    private Node n;

    public Game (String title){

        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        init();
    }

    private void init() {

        toolBar = new JToolBar();
        toolBar.setVisible(true);
        add(toolBar, BorderLayout.NORTH);


        scoreboard = new Scoreboard();
        add(scoreboard, BorderLayout.SOUTH);

        board = new Board();
        add(board, BorderLayout.CENTER);


        pack();
        setLocationRelativeTo(null);


    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new Game("Snake Game");
                frame.setVisible(true);
            }
        });
    }
}
