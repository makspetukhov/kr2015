import java.awt.*;

/**
 * Created by Ak__74 on 16.01.16.
 */
public class Racket {
   int x;
    int y;
    int width = 15;
    int height = 40;

    boolean up = false;
    boolean down = false;

    public Racket(int x, int y){
         this.x=x;
          this.y=y;
    }

    public void tick(Pong pong){
          if (up){
              y--;
          }
          if (down){
              y++;
          }
    }

    public void render (Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(x,y,width,height);
    }

}
