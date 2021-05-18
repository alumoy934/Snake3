import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.security.Key;
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
        generate_Food();

        snake.move_Snake();





    }

    @Override
    public void actionPerformed(ActionEvent e) {


        repaint();
    }

    private void generate_Food() {
        rnd = new Random();
        comida = new Food(rnd.nextInt(ROWS), rnd.nextInt(COLS));
    }

    public void paintComponent (Graphics g){
        super.paintComponent(g);
        snake.draw(g);
        comida.draw(g, Color.red);

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
                    System.out.println("Tecla derecha");
                    break;
                case KeyEvent.VK_DOWN:
                    System.out.println("Tecla abajo");
                    break;
                case KeyEvent.VK_UP:
                    System.out.println("Tecla arriba");
            }
            //repaint();
        }
    }

}
