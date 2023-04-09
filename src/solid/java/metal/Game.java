package solid.java.metal;

import java.util.Random;

public class Game {
    private Player1 player_1;
    private Player2 player_2;
    public boolean gameEnd = false;
    private int delay;

    // Som instanciado
    Sound sound = new Sound("resources/background2.wav");
    Sound sound1 = new Sound("resources/hit.wav");

    public Game(){
        this.delay = delay;
    }

    public void init() {
        Random rand = new Random();
        delay = 4;
        GameRectangle gameRectangle = new GameRectangle(10,10,900,700);


        //Jogador 1
        this.player_1 = new Player1(SpaceShipType.values()[rand.nextInt((2 - 0) + 1) + 0], 420, 600);
        this.player_1.init(this);

        rand = new Random();
        //Jogador 2
        this.player_2 = new Player2(SpaceShipType.values()[rand.nextInt((5 - 3) + 1) + 3], 420, 50);
        this.player_2.init(this);

        //musica background
        sound.play(true);
    }

    public void moveBullets(int direction) {
        for (int i = 0; i < player_1.getBulletsList().size(); i++) {
            Bullets bullet = player_1.getBulletsList().get(i);
            Boolean checkColision = collisionDetector(bullet);

            if(checkColision == true){
                this.player_1.getBulletsList().remove(bullet);
                bullet.removeBullet();
                this.player_2.hit();
                System.out.println(player_2.getHealth());
            }else {
                bullet.bulletMovement(direction);
            }

            Boolean checkBorder = borderDetector(bullet);
            if(checkBorder == true){
                this.player_1.getBulletsList().remove(bullet);
                bullet.removeBullet();
            }
        }
    }

    public boolean borderDetector(Bullets bullet){
        if((bullet.getY()<0) || bullet.getY()>650){
            return true;
        }
        return false;
    }


    public boolean collisionDetector(Bullets bullet){
        if((player_2.getY() == bullet.getY()+1 && (player_2.getX() <= (bullet.getBullet().getMaxX() - 30) && player_2.getPicture().getMaxX() >= (bullet.getBullet().getX()+30)))){
            System.out.println("collision");
            sound1.play(true);
            return true;
        }
        return false;
    }

    public void moveBullets2(int direction) {
        for (int i = 0; i < player_2.getBulletsList().size(); i++) {
            Bullets bullet2 = player_2.getBulletsList().get(i);
            Boolean checkColision = collisionDetector2(bullet2);

            if(checkColision == true){
                this.player_2.getBulletsList().remove(bullet2);
                bullet2.removeBullet();
                this.player_1.hit();
                System.out.println(player_1.getHealth());
            }else {
                bullet2.bulletMovement(direction);
            }
            Boolean checkBorder2 = borderDetector(bullet2);
            if (checkBorder2 == true){
                this.player_2.getBulletsList().remove(bullet2);
                bullet2.removeBullet();
            }

        }
    }

    public boolean collisionDetector2(Bullets bullet2){
        if((player_1.getY() == bullet2.getY()-1) && (player_1.getX() <=(bullet2.getBullet().getMaxX()-30) )&& player_1.getPicture().getMaxX() >= (bullet2.getBullet().getX()+30) ){
            System.out.println("collision");
            return true;
        }
        return false;
    }
}




