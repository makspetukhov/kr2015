/**
 * Created by Ak__74 on 18.01.16.
 */
class Player {
    private int playerX;
    private int playerY;
    private int playerScore;

    public Player(int playerX) {
        this.playerX = playerX;
        playerY = 300 - 64;
        playerScore = 0;
    }

    public int getPlayerX() {
        return playerX;
    }

    public void setPlayerX(int playerX) {
        this.playerX = playerX;
    }

    public int getPlayerY() {
        return playerY;
    }

    public void setPlayerY(int playerY) {
        this.playerY = playerY;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void increasePlayerScore() {
        this.playerScore++;
    }
}

