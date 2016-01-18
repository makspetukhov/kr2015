import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;


import javax.swing.JFrame;

/**
 * Created by Ak__74 on 17.12.15.
 */
public class Pong extends JFrame {

   int ballX, ballY;
   int playerX, playerY;
   int playerScore;
   int botX, botY;
   int botScore;
   int lineX, lineY;

    private Image img;
    private Graphics gph;

    public Pong (){

        addKeyListener(new InputCommands());

        setTitle("Pong");
        setSize(800, 600);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.BLACK);

        playerX = 0;
        playerY = 300-64;

        botX = 780;
        botY = 300-64;

        ballX = 400;
        ballY = 300;

        lineX = 400;
        lineY = 0;

        playerScore = 0;
        botScore = 0;
    }

    public void paint(Graphics g) {

        img = createImage(getWidth(), getHeight());
        gph = img.getGraphics();
        paintComponent(gph);
        g.drawImage(img, 0, 0, this);

    }

    public void paintComponent(Graphics g) {

        g.setColor(Color.MAGENTA);
        g.drawString("Score: " + botScore, 430, 50);

        g.setColor(Color.MAGENTA);
        g.drawString("Score: " + playerScore, 320, 50);

        g.setColor(Color.GREEN);
        g.fillRect(botX, botY, 20, 128);

        g.setColor(Color.BLUE);
        g.fillRect(playerX, playerY, 20, 128);

        g.setColor(Color.ORANGE);
        g.fillRect(ballX, ballY, 20, 20);

        g.setColor(Color.WHITE);
        g.fillRect(lineX, lineY, 2, 600);
    }

    public static void main(String[] args) {

        new Pong();

    }
}
