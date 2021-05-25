import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {

    private Scoreboard scoreboard;
    private Board board;



    private Node n;

    public Game (String title){

        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        init();
    }

    private void init() {

        create_Toolbar();

        scoreboard = new Scoreboard();
        add(scoreboard, BorderLayout.SOUTH);


        board = new Board();
        add(board, BorderLayout.CENTER);


        pack();
        setLocationRelativeTo(null);


    }

    private void create_Toolbar() {
        JToolBar toolBar = new JToolBar();
        JButton buttonConfig = new JButton("Configuration");
        buttonConfig.setFocusable(false);
        toolBar.add(buttonConfig);
        JButton buttonAbout = new JButton("About");
        buttonAbout.setFocusable(false);
        toolBar.add(buttonAbout);

        add(toolBar, BorderLayout.NORTH);
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
