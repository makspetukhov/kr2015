import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Ak__74 on 16.01.16.
 */
class InputCommands extends KeyAdapter {


    public InputCommands(Pong pong) {
        super();
    }
    public void keyPressed(KeyEvent e) {

        int keyCode = e.getKeyCode();

        if (keyCode == e.VK_W) {

       //   playerY -= playerPos;

        }
        if (keyCode == e.VK_S) {

        //   playerY += playerPos;

        }

    }

    public void keyReleased(KeyEvent e) {

    }

}
