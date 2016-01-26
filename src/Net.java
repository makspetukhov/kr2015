
/**
 * Created by Ak__74 on 20.01.16.
 */
public class Net {

    private Coordinates coordinates;

    public Net(){
        coordinates = new Coordinates(400, 0);
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
