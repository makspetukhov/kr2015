
/**
 * Created by Ak__74 on 26.01.16.
 */
public class Logic {

    private Ball currentBall;

    private Player player1;
    private Player player2;

    private int ballSpeed;
    private double angle;


    public Logic(Ball currentBall, Player player1, Player player2, int ballSpeed) {
        this.currentBall = currentBall;
        this.player1 = player1;
        this.player2 = player2;
        this.ballSpeed = ballSpeed;
        angle = 60;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Ball getCurrentBall() {
        return currentBall;
    }

    public Ball getNextBallPosition() {
        Coordinates ballCoordinates = currentBall.getCoordinates();
        double currentBallX = ballCoordinates.getX();
        double currentBallY = ballCoordinates.getY();

        currentBallX += (ballSpeed * Math.cos(angle * Math.PI / 180));
        currentBallY += (ballSpeed * Math.sin(angle * Math.PI / 180));

        Coordinates coordinates = new Coordinates(currentBallX, currentBallY);
        currentBall.setCenterCoordinates(coordinates);
        getNextAngle();

        return currentBall;
    }

    private void getNextAngle() {
        Coordinates ballCoordinates = currentBall.getCoordinates();
        double currentBallX = ballCoordinates.getX();
        double currentBallY = ballCoordinates.getY();

        Coordinates player1Coordinates = player1.getCoordinates();
        double player1X = player1Coordinates.getX();
        double player1Y = player1Coordinates.getY();

        if (player1Coordinates.getY()<=10){
            player1Coordinates.setY(10);
        }
        if (player1Coordinates.getY()>=470){
            player1Coordinates.setY(470);
        }

        Coordinates player2Coordinates = player2.getCoordinates();
        double player2X = player2Coordinates.getX();
        double player2Y = player2Coordinates.getY();

        if (player2Coordinates.getY()<=10){
            player2Coordinates.setY(10);
        }
        if (player2Coordinates.getY()>=470){
            player2Coordinates.setY(470);
        }

        if (((currentBallY - 10) <= 0) || ((currentBallY + 10) >= 600)) {
            angle = 360 - angle;
        }

        if ((player1X + 20) >= (currentBallX - 10)) {
            if (((player1Y - 64) <= currentBallY) && ((player1Y + 64) >= currentBallY)) {
                if (90 < angle && 0 > angle) {
                    angle = 180 - angle;
                } else {
                    angle = (270 - angle) + 270;
                }

            } else {
                currentBall = new Ball();
                player2.increasePlayerScore();
                angle = Math.random() * 60;

                if (Math.random() * 2 > 1){
                    angle += 180;
                }
            }
        }

        if ((player2X - 20) <= (currentBallX + 10)) {
            if ((player2Y - 64) <= currentBallY && (player2Y + 64) >= currentBallY) {
                if (90 > angle && 180 <= angle) {
                    angle = 180 - angle;
                } else {
                    angle = (270 - angle) + 270;
                }

            } else {
                currentBall = new Ball();
                player1.increasePlayerScore();
                angle = Math.random() * 60;

                if (Math.random() * 2 > 1){
                    angle += 180;
                }
            }
        }

        angle %= 360;
    }
}
