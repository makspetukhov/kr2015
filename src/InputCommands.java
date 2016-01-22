import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Ak__74 on 16.01.16.
 */
class InputCommands extends KeyAdapter {
    private Player player;
    private int up, down;
    private int speed;

    public InputCommands(Player player, int up, int down) {
        super();
        this.player = player;
        this.up = up;
        this.down = down;
        this.speed = 20;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == up)
            player.setPlayerY(player.getPlayerY()-speed);
        if (keyCode == down)
            player.setPlayerY(player.getPlayerY()+speed);
    }
}