import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Ak__74 on 16.01.16.
 */
public class InputCommands extends KeyAdapter {

    int playerX, playerY;
    int playerSpeed;

    public void keyPressed(KeyEvent e) {

        int keyCode = e.getKeyCode();

        if (keyCode == e.VK_UP) {

            playerY -= playerSpeed;

        }
        if (keyCode == e.VK_DOWN) {

            playerY += playerSpeed;

        }

    }

    public void keyReleased(KeyEvent e) {

    }

}
