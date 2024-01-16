package solid.java.metal;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class SpaceShip {

    private int x;
    private int y;

    private final Picture picture;

    public SpaceShip(SpaceShipType spaceShipType, int x, int y)
    {
        this.x = x;
        this.y = y;
        this.picture = new Picture(x, y, spaceShipType.getPictureFile());
        picture.draw();
    }

     public void pictureTranslate(int x, int y) {
         this.picture.translate(x, y);
     }

     public Picture getPicture() {
         return this.picture;
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
}