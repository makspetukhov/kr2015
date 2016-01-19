import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


import javax.swing.JFrame;

/**
 * Created by Ak__74 on 17.12.15.
 */
public class Pong extends JFrame {

   int ballX, ballY;
   int playerX, playerY;
   int playerScore;
   int player2X, player2Y;
   int player2Score;
   int lineX, lineY;
   int playerPos;
   int player2Pos;

    private Image img;
    private Graphics gph;



    public Pong (){

        addKeyListener(new InputCommands(this));

        addKeyListener(new InputCommands2(this));

        setTitle("Pong");
        setSize(800, 600);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.BLACK);

        playerX = 0;
        playerY = 300-64;
        playerPos = 50;

        player2X = 780;
        player2Y = 300-64;
        player2Pos = 50;

        ballX = 392;
        ballY = 290;

        lineX = 400;
        lineY = 0;

        playerScore = 0;
        player2Score = 0;
    }



    public void paint(Graphics g) {

        img = createImage(getWidth(), getHeight());
        gph = img.getGraphics();
        paintComponent(gph);
        g.drawImage(img, 0, 0, this);

    }

    public void paintComponent(Graphics g) {

        g.setColor(Color.CYAN);
        g.drawString("Score: " + player2Score, 430, 50);

        g.setColor(Color.CYAN);
        g.drawString("Score: " + playerScore, 320, 50);

        g.setColor(Color.GREEN);
        g.fillRect(player2X, player2Y, 20, 128);

        g.setColor(Color.BLUE);
        g.fillRect(playerX, playerY, 20, 128);


        g.setColor(Color.WHITE);
        g.fillRect(lineX, lineY, 2, 600);

        g.setColor(Color.ORANGE);
        g.fillOval(ballX, ballY, 20, 20);

        repaint();

    }


    public static void main(String[] args) {

        new Pong();

    }
}
