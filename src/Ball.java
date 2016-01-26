

/**
 * Created by Ak__74 on 16.01.16.
 */
public class Ball {

    private Coordinates centerCoordinates;
    private int radius;

    public Ball() {
        centerCoordinates = new Coordinates(392, 290);
        radius = 10;
    }

    public Ball(Coordinates centerCoordinates, int radius) {
        this.centerCoordinates = centerCoordinates;
        this.radius = radius;
    }

    public Coordinates getCoordinates() {
        return centerCoordinates;
    }

    public void setCenterCoordinates(Coordinates centerCoordinates) {
        this.centerCoordinates = centerCoordinates;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

}
