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

    private boolean running;
    private Thread thread;
    private boolean direction;

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

        addKeyListener(new InputCommands(player1, KeyEvent.VK_W , KeyEvent.VK_S));
        addKeyListener(new InputCommands(player2, KeyEvent.VK_UP , KeyEvent.VK_DOWN));


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
            if (ball.getBallX() > player2.getPlayerX() && ball.getBallX() < player2.getPlayerX() + 20)
             if (ball.getBallY() > player2.getPlayerY() && ball.getBallY() < player2.getPlayerY() + 128){
                direction = true;
            }
            if (ball.getBallX() > player1.getPlayerX() && ball.getBallX() < player1.getPlayerX() + 20)
                if (ball.getBallY() > player1.getPlayerY() && ball.getBallY() < player1.getPlayerY() + 128){
                direction = false;
            }

            if (direction) {
                ball.setBallX(ball.getBallX()-10);
                ball.setBallY(ball.getBallY()+rand());
            } else {
                ball.setBallX(ball.getBallX()+10);
                ball.setBallY(ball.getBallY()-rand());
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (ball.getBallX()<0){
                player1.increasePlayerScore();
                direction = false;
            }
            if (ball.getBallX()>800){
                player2.increasePlayerScore();
                direction = true;
            }

            if (player1.getPlayerY()<=10){
                player1.setPlayerY(10);
            }
            if (player1.getPlayerY()>=470){
                player1.setPlayerY(470);
            }
            if (player2.getPlayerY()<=10){
                player2.setPlayerY(10);
            }
            if (player2.getPlayerY()>=470){
                player2.setPlayerY(470);
            }
            repaint();
        }
    }


    public int rand(){
        int number = -2 - (int) (Math.random() * 3);
        return number;
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
        g.setColor(Color.CYAN);
        g.drawString("Score: " + player2.getPlayerScore(), 430, 50);

        g.setColor(Color.CYAN);
        g.drawString("Score: " + player1.getPlayerScore(), 320, 50);

        g.setColor(Color.GREEN);
        g.fillRect(player2.getPlayerX(), player2.getPlayerY(), 20, 128);

        g.setColor(Color.BLUE);
        g.fillRect(player1.getPlayerX(), player1.getPlayerY(), 20, 128);

        g.setColor(Color.WHITE);
        g.fillRect(net.getLineX(), net.getLineY(), 2, 600);

        g.setColor(Color.ORANGE);
        g.fillOval(ball.getBallX(), ball.getBallY(), 20, 20);
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