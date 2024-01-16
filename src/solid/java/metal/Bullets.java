package solid.java.metal;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Bullets {

    private int x;
    private int y;
    private final Picture bullet;

    Sound sound = new Sound("resources/LaserWeapon.wav");

    public Bullets(int x, int y) {
        this.x = x;
        this.y = y;
        this.bullet = new Picture(x, y, "resources/bullet.png");
        //bullet.grow(-15, -15);
        bullet.draw();
        sound.play(true);
    }

    public void removeBullet() {
        this.bullet.delete();
    }

    public void bulletMovement(int direction) {
        bullet.translate(0, direction);
        this.setX(getX());
        this.setY(getY() + direction);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Picture getBullet() {
        return bullet;
    }

}
