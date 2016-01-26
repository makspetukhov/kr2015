
import java.awt.*;
import javax.swing.JFrame;
import java.awt.event.KeyEvent;

/**
 * Created by Ak__74 on 17.12.15.
 */
public class Pong extends JFrame implements Runnable {
    private Player player1, player2;
    private Ball ball;
    private Net net;
    private Image img;
    private Graphics gph;
    private Logic logic;

    private boolean running;
    private Thread thread;

    public Pong() {
        setTitle("Pong");
        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.BLACK);

        thread = new Thread(this, "pong");

        player1 = new Player(0);
        player2 = new Player(780);

        ball = new Ball();

        net = new Net();

        logic = new Logic(ball, player1, player2, 5);

        addKeyListener(new InputCommands(player1, KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_ESCAPE));
        addKeyListener(new InputCommands(player2, KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_ESCAPE));


        running = false;
    }


    public void start() {
        running = true;
        thread.start();
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            logic.setPlayer1(player1);
            logic.setPlayer2(player2);
            ball = logic.getNextBallPosition();

            try {
                Thread.currentThread().sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            repaint();
        }
    }


    @Override
    public void paint(Graphics g) {
        img = createImage(getWidth(), getHeight());
        gph = img.getGraphics();
        paintComponent(gph);
        g.drawImage(img, 0, 0, this);
        repaint();
    }

    private void paintComponent(Graphics g) {
        Coordinates player1Coordinates = player1.getCoordinates();
        Coordinates player2Coordinates = player2.getCoordinates();
        Coordinates netCoordinates = net.getCoordinates();
        Coordinates ballCoordinates = ball.getCoordinates();

        g.setColor(Color.CYAN);
        g.drawString("Score: " + player2.getPlayerScore(), 430, 50);

        g.setColor(Color.CYAN);
        g.drawString("Score: " + player1.getPlayerScore(), 320, 50);

        g.setColor(Color.GREEN);
        g.fillRect((int) player2Coordinates.getX(), (int) player2Coordinates.getY(), 20, 128);

        g.setColor(Color.BLUE);
        g.fillRect((int) player1Coordinates.getX(), (int) player1Coordinates.getY(), 20, 128);

        g.setColor(Color.WHITE);
        g.fillRect((int) netCoordinates.getX(), (int) netCoordinates.getY(), 2, 600);

        g.setColor(Color.ORANGE);
        g.fillOval((int) ballCoordinates.getX(), (int) ballCoordinates.getY(), 20, 20);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Pong game = new Pong();
                game.setVisible(true);
                game.start();
            }
        });
    }
}