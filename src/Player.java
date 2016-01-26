

/**
 * Created by Ak__74 on 18.01.16.
 */
public class Player {

    private Coordinates coordinates;
    private int height = 128;
    private int width = 20;
    private int playerScore;

    public Player(int playerX) {
        coordinates = new Coordinates(playerX, 300 - 64);
        playerScore = 0;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void increasePlayerScore() {
        this.playerScore++;
    }

}

