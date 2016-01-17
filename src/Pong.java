import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;


/**
 * Created by Ak__74 on 17.12.15.
 */
public class Pong  extends Canvas implements Runnable{

    static Racket racket;
    InputCommands in;
    JFrame frame;
    int WIDTH = 400;
    int HEIGHT = 300;
    String TITLE = "PONG";
    Dimension gameSize = new Dimension(WIDTH, HEIGHT);

    BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

    static boolean gameStart = false;

    public void run() {

        while (gameStart){
            tick();
            render();
        }
    }

    public synchronized void start(){
        gameStart = true;
        new Thread(this).start();
    }
    public static synchronized void stop(){
        gameStart = false;
        System.exit(0);
    }

    public Pong(){
       frame = new JFrame();
       setMinimumSize(gameSize);
       setPreferredSize(gameSize);
       setMaximumSize(gameSize);
       frame.add(this, BorderLayout.CENTER);
       frame.pack();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setTitle(TITLE);
        frame.setLocationRelativeTo(null);

        in = new InputCommands(this);

        racket = new Racket(10, 60);

    }

    public void tick(){
         racket.tick(this);
    }

    public void render(){
        BufferStrategy bs = getBufferStrategy();
        if (bs==null){
           createBufferStrategy(3);
            return;
        }
      Graphics g = bs.getDrawGraphics();

        g.setColor(Color.BLACK);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        racket.render(g);
        g.dispose();
        bs.show();
    }

    public static void main (String [] args){
       Pong pong = new Pong();
        pong.start();
    }
}
