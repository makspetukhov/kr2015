
import javax.sql.PooledConnection;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Ak__74 on 16.01.16.
 */
public class InputCommands implements KeyListener{

    public InputCommands(Pong pong) {
        pong.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

        int keyCode = e.getKeyCode();

        if (keyCode == e.VK_UP){
            Pong.racket.down = false;
            Pong.racket.up = true;
        }
        if (keyCode == e.VK_DOWN){
            Pong.racket.up = false;
            Pong.racket.down=true;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
