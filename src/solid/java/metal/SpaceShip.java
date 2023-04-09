package solid.java.metal;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;

public abstract class SpaceShip {

    private int x;
    private int y;

    private SpaceShipType spaceShipType;
    private int health;

    private int damage;
    private boolean destroyed = false;

    public int getDamage() {
        return damage;
    }

    private LinkedList<Bullets> bulletsList;

    private Picture picture;


    public SpaceShip(SpaceShipType spaceShipType, int x, int y)
    {
        this.x = x;
        this.y = y;
        this.spaceShipType = spaceShipType;
        this.bulletsList = new LinkedList<>();
        this.health = spaceShipType.getShipHealth();
        this.damage = spaceShipType.getShipDamage();
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

    /**
     * TODO
     * @param health
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * TODO
     * @return
     */
    public int getHealth() {
        return this.health;
    }

    public void shoot(){
        bulletsList.add(new Bullets(this.spaceShipType.getShipDamage() , picture.getX() + 10, picture.getY() -15));
        System.out.println("bulletMovementX: " + this.picture.getX() + " bulletMovementY: " + this.picture.getY());

    }

    public void hit() {
        if (this.health > 0) {
            this.health = this.health - spaceShipType.getShipDamage();
        }
        if (this.health <=0) {
            this.destroyed = true;
            System.out.println(isDestroyed());
        }
    }

    public LinkedList<Bullets> getBulletsList() {
        return this.bulletsList;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void destroyed(){
        this.destroyed =true;
    }
}