import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame {

    private Scoreboard scoreboard;
    private Board board;
    private Node n;
    private Configuration config;
    private static JFrame frame;


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

        config = new Configuration(board, this);
        config.setVisible(true);


    }

    private void create_Toolbar() {
        JToolBar toolBar = new JToolBar();
        JButton buttonConfig = new JButton("Configuration");
        buttonConfig.setFocusable(false);
        toolBar.add(buttonConfig);
        JButton buttonAbout = new JButton("About");
        buttonAbout.setFocusable(false);
        toolBar.add(buttonAbout);

        buttonConfig.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               config = new Configuration(board, frame);
               config.setVisible(true);
            }
        });

        buttonAbout.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Version 1.0 \n Autor: Carlos Moyano",
                        "Snake Detail Information", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        add(toolBar, BorderLayout.NORTH);
    }


    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame = new Game("Snake Game");
                frame.setVisible(true);


            }
        });
    }
}
