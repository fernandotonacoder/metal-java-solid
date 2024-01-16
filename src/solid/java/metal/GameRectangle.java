package solid.java.metal;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameRectangle  {

    public int x;
    public int y;
    public int width;
    public int height;

    public GameRectangle(int x, int y, int width, int height){
        this.x=x;
        this.y=y;
        this.width = width;
        this.height = height;
        Rectangle rectangle = new Rectangle(x,y,width,height);
        rectangle.setColor(Color.LIGHT_GRAY);
        rectangle.draw();
        Picture picture = new Picture(10,10,"resources/background.jpeg");
        picture.draw();
    }
}
