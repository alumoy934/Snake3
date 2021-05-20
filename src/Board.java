import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Board extends JPanel implements ActionListener {

    public static final int WIDTH = 600;
    public static final int HEIGHT = 600;

    public static final int ROWS = 60;
    public static final int COLS = 60;

    public static final int SQUARE_WIDTH = WIDTH / COLS;
    public static final int SQUARE_HEIGHT = HEIGHT / ROWS;

    private static final int DELAY = 400;

    private Random rnd;
    private TAdapter keyAdapter;


    private Snake snake;
    private Food comida;

    Timer timer;


    public Board(){
        super();
        setFocusable(true);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        timer = new Timer(DELAY,this);
        timer.start();

        keyAdapter = new TAdapter();
        addKeyListener(keyAdapter);

        snake = new Snake();
        comida = new Food();


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        snake.moveSnake(comida);
        checkForGameOver();
        repaint();
    }



    public void paintComponent (Graphics g){
        super.paintComponent(g);

        comida.draw(g, Color.red);
        snake.draw(g);
    }

    private void ProcessGameOver() {
        JOptionPane.showMessageDialog(null, "Fin del juego.",
                "GAME OVER", JOptionPane.WARNING_MESSAGE);
        timer.stop();

    }


    private void checkForGameOver() {

        if (snake.isGameOver()){
            ProcessGameOver();
        }
    }


    class TAdapter extends KeyAdapter {
        public void keyPressed(KeyEvent e) {

            int keycode = e.getKeyCode();

            switch (keycode) {
                case KeyEvent.VK_LEFT :
                    if (snake.getDirection() != Direction.LEFT){
                        snake.setDirection(Direction.LEFT);

                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (snake.getDirection() != Direction.RIGHT){
                        snake.setDirection(Direction.RIGHT);

                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (snake.getDirection() != Direction.DOWN){
                        snake.setDirection(Direction.DOWN);

                    }
                    break;
                case KeyEvent.VK_UP:
                    if (snake.getDirection() != Direction.UP){
                        snake.setDirection(Direction.UP);

                    }
            }
            //repaint();
        }
    }

}
