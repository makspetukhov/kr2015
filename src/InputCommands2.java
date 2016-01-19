import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Ak__74 on 18.01.16.
 */
class InputCommands2 extends KeyAdapter {

    public InputCommands2(Pong pong) {
        super();
    }

    public void keyPressed(KeyEvent e) {

        int keyCode = e.getKeyCode();

        if (keyCode == e.VK_UP) {

        //    player2Y -= player2Pos;

        }
        if (keyCode == e.VK_DOWN) {

        //   player2Y += player2Pos;

        }

    }

    public void keyReleased(KeyEvent e) {

    }

}

