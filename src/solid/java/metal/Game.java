package solid.java.metal;

import java.util.Random;

public class Game {
    private Player1 player1;
    private Player2 player2;

    // Instantiated sound
    Sound sound = new Sound("resources/background2.wav");
    Sound sound1 = new Sound("resources/hit.wav");

    public Game() {
    }

    public void init() {
        var rand1 = new Random();
        new GameRectangle(0, 0, 1920, 1080);

        // Player 1
        this.player1 = new Player1(SpaceShipType.values()[rand1.nextInt((2) + 1)], 420, 600);
        this.player1.init(this);

        var rand2 = new Random();
        // Player 2
        this.player2 = new Player2(SpaceShipType.values()[rand2.nextInt((5 - 3) + 1) + 3], 420, 50);
        this.player2.init(this);

        // Background music
        sound.play(true);
    }

    public void collisionDetector1(Bullets bullet) {
        if ((player2.getY() == bullet.getY() + 1 && (player2.getX() <= (bullet.getBullet().getMaxX() - 30) && player2.getPicture().getMaxX() >= (bullet.getBullet().getX() + 30)))) {
            System.out.println("collision");
            sound1.play(true);
        }
    }

    public void collisionDetector2(Bullets bullet2) {
        if ((player1.getY() == bullet2.getY() - 1) && (player1.getX() <= (bullet2.getBullet().getMaxX() - 30)) && player1.getPicture().getMaxX() >= (bullet2.getBullet().getX() + 30)) {
            System.out.println("collision");
        }
    }
}