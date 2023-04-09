package solid.java.metal;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Player1 extends SpaceShip implements KeyboardHandler {

    public Player1(SpaceShipType spaceShipType, int x, int y) {
        super(spaceShipType, x, y);
    }
    private Game game;


    public void init(Game g){
        this.keyboardInit();
        game = g;

    }

    /**
     * Player 1 movement, Arrow Up, Arrow Down, Arrow Left, Arrow Right, M to Shoot.
     */
    private void keyboardInit(){
        Keyboard keyboard = new Keyboard(this);

        //RIGHT KEY
        KeyboardEvent rightKeyPressed = new KeyboardEvent();
        rightKeyPressed.setKey(KeyboardEvent.KEY_RIGHT);
        rightKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(rightKeyPressed);


        //LEFT KEY
        KeyboardEvent leftKeyPressed = new KeyboardEvent();
        leftKeyPressed.setKey(KeyboardEvent.KEY_LEFT);
        leftKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(leftKeyPressed);

        KeyboardEvent downKeyPressed = new KeyboardEvent();
        downKeyPressed.setKey(KeyboardEvent.KEY_DOWN);
        downKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(downKeyPressed);

        KeyboardEvent upKeyPressed = new KeyboardEvent();
        upKeyPressed.setKey(KeyboardEvent.KEY_UP);
        upKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(upKeyPressed);

        KeyboardEvent shootKeyPressed = new KeyboardEvent();
        shootKeyPressed.setKey(KeyboardEvent.KEY_M);
        shootKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(shootKeyPressed);

    }

    /**
     * TODO Doc, adicionar setX e setY para atualizar posição da nave, atualmente atualiza só a imagem, relativamente às colisões
     * Mudar as teclas para key Released !
     * @param keyboardEvent
     */
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT) {
            if(this.getPicture().getX() <= 40) {
                this.pictureTranslate(0, 0);
            }else {
                this.pictureTranslate(-20, 0);
                this.setX(this.getPicture().getX());
                System.out.println("Objeto x: " + this.getX());
                System.out.println("Imagem x: " + this.getPicture().getX());
            }
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT) {
            if(this.getPicture().getX()>=785){
                this.pictureTranslate(0, 0);
            }else {
                this.pictureTranslate(20, 0);
                this.setX(this.getPicture().getX());

            }
        }
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_UP) {
            if (this.getPicture().getY() <= 410) {
                this.pictureTranslate(0, 0);
            } else {
                this.pictureTranslate(0, -20);
                this.setY(this.getPicture().getY());
                System.out.println(getY());
            }

        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN) {
            if (this.getPicture().getY() >= 590) {
                this.pictureTranslate(0, 0);
            } else {
                this.pictureTranslate(0, 20);
                this.setY(this.getPicture().getY());
            }
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_M){
            Runnable task = () -> {
                Bullets bullets = new Bullets(super.getDamage(), this.getX(), this.getY());
                while (bullets.getY() > 10) {
                    try {
                        Thread.sleep(40);
                        bullets.bulletMovement(-40);
                        game.collisionDetector(bullets);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                // remover bullet
                bullets.removeBullet();
                bullets = null;
            };
            Thread thread = new Thread(task);
            thread.start();
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
