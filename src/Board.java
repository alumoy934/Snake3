import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Board extends JPanel implements ActionListener {

    public static final int WIDTH = 400;
    public static final int HEIGHT = 400;

    public static final int ROWS = 40;
    public static final int COLS = 40;

    public static final int SQUARE_WIDTH = WIDTH / COLS;
    public static final int SQUARE_HEIGHT = HEIGHT / ROWS;

    private static int DELAY =300;

    private Random rnd;
    private TAdapter keyAdapter;


    private Snake snake;
    private Food comida;
    private SpecialFood specialFood;

    Timer timer;


    public Board(){
        super();
        setFocusable(true);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        timer = new Timer(DatesConfig.DELTA,this);
        timer.start();


        keyAdapter = new TAdapter();
        addKeyListener(keyAdapter);

        snake = new Snake();
        comida = new Food();
        specialFood = new SpecialFood();

        random_Special_Food();

    }

    private void random_Special_Food() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {

                while (true){
                    try {
                        Thread.sleep(5000);
                        specialFood = new SpecialFood();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        snake.moveSnake(comida, specialFood);
        checkForGameOver();
        repaint();
    }



    public void paintComponent (Graphics g){
        super.paintComponent(g);

        specialFood.draw(g, Color.BLUE);
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
                    if (snake.getDirection() != Direction.RIGHT){
                        snake.setDirection(Direction.LEFT);

                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (snake.getDirection() != Direction.LEFT){
                        snake.setDirection(Direction.RIGHT);

                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (snake.getDirection() != Direction.UP){
                        snake.setDirection(Direction.DOWN);

                    }
                    break;
                case KeyEvent.VK_UP:
                    if (snake.getDirection() != Direction.DOWN){
                        snake.setDirection(Direction.UP);

                    }
            }
            //repaint();
        }
    }

}
