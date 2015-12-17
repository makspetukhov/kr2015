import javax.swing.*;
import java.util.Random;
import java.util.Timer;

/**
 * Created by Ak__74 on 17.12.15.
 */
public class Pong {

    public Renderer renderer;

    public Random random;

    public JFrame jframe;

    public int width = 700, height = 700;

    public Pong()
    {
        Timer timer = new Timer(20, this);
        random = new Random();

        jframe = new JFrame("Pong");

        renderer = new Renderer();


        jframe.setSize(width + 15, height + 35);
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.add(renderer);
        jframe.addKeyListener(this);

        timer.start();
    }

}
