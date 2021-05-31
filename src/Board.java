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


    private Random rnd;
    private TAdapter keyAdapter;


    private Snake snake;
    private Snake snake2;
    private Food comida;
    private SpecialFood specialFood;

    Timer timer;

    private Scoreboard scoreboard;


    public Board(Scoreboard scoreboard){
        super();
        setFocusable(true);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.scoreboard = scoreboard;


        keyAdapter = new TAdapter();
        addKeyListener(keyAdapter);

        snake = new Snake(scoreboard);
        snake2 = new Snake(scoreboard);
        comida = new Food();
        specialFood = new SpecialFood();

        random_Special_Food();

    }

    public void initGame() {
        if (timer != null){
            timer.stop();
        }
        timer = new Timer(DatesConfig.DELTA,this);
        timer.start();
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
        snake2.moveSnake(comida, specialFood);
        checkForGameOver();
        repaint();
    }



    public void paintComponent (Graphics g){
        super.paintComponent(g);

        specialFood.draw(g, Color.BLUE);
        comida.draw(g, Color.red);
        snake.draw(g);
        snake2.setColor(Color.black);
        snake2.draw(g);
    }

    private void ProcessGameOver() {
        JOptionPane.showMessageDialog(null, "Fin del juego.",
                "GAME OVER", JOptionPane.WARNING_MESSAGE);
        timer.stop();

    }


    private void checkForGameOver() {

        if (snake.isGameOver() || snake2.isGameOver()){
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
                // Controles para la segunda Snake

                case KeyEvent.VK_A:
                    if (snake2.getDirection() != Direction.RIGHT){
                        snake2.setDirection(Direction.LEFT);

                    }
                    break;

                case KeyEvent.VK_D:
                    if (snake2.getDirection() != Direction.LEFT){
                        snake2.setDirection(Direction.RIGHT);

                    }
                    break;
                case KeyEvent.VK_S:
                    if (snake2.getDirection() != Direction.UP){
                        snake2.setDirection(Direction.DOWN);

                    }
                    break;
                case KeyEvent.VK_W:
                    if (snake2.getDirection() != Direction.DOWN){
                        snake2.setDirection(Direction.UP);

                    }
            }
            //repaint();
        }
    }

}
