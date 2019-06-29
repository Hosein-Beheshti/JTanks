import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Enemy03 {

    private int locX;
    private int locY;
    private int health;
    private double gunAngle = 0;
    private int speed = 3;
    private int j = 0 , i = 0;
    private  boolean limitMoving;
    private boolean active = false;
    private boolean haveGun01food = false,haveGun02Food= false,haveRepairFood= false,haveUpdateStar= false;


    private BufferedImage bigEnemyBodyImage;
    private BufferedImage bigEnemyGunImage;

    private boolean up,down,right,left;

    public Enemy03(int locX,int locY) {
        {
            if (GameFrame.getStartGame().easy)
                health = 100;
            if (GameFrame.getStartGame().normal)
                health = 200;
            if (GameFrame.getStartGame().hard)
                health = 300;

            this.locX = locX;
            this.locY = locY;
            try {
                bigEnemyBodyImage = ImageIO.read(new File("./images/BigEnemy.png"));
                bigEnemyGunImage = ImageIO.read(new File("./images/BigEnemyGun.png"));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void move() {


    }
    /**
     * render method draw enemy03 and set that rotate
     * and controll it's moving
     * and check intersects
     * @param g
     * @param state
     */
    public void render(Graphics2D g, GameState state) {
        /**
         * information EnemyTank
         */
        AffineTransform tx = new AffineTransform();
        tx.setToTranslation(locX  + state.xTransfer - bigEnemyBodyImage.getWidth() / 2 , locY + state.yTransfer - bigEnemyBodyImage.getHeight() / 2);
      //  tx.rotate(Math.toRadians(angle), 50, 50);
        /**
         * information Enemy Gun
         */
        AffineTransform tx2 = new AffineTransform();
        tx2.setToTranslation(locX + state.xTransfer - bigEnemyGunImage.getWidth() / 5, locY + state.yTransfer - bigEnemyGunImage.getHeight() / 4.2);
        tx2.rotate(Math.toRadians(gunAngle), 20, 20);



        right = false;
        left = false;

                if(j == 0)
            limitMoving = false;

        if(limitMoving == false)
        {
            locX += speed ;
            right = true;
            j++;
        }
        if(j == 100)
            limitMoving = true;
        if(limitMoving == true)
        {
            locX -= speed ;
            left = true;
            j--;
        }

/**
 * check intersects
 */
            ShapesIntersects shapesIntersects = new ShapesIntersects();
            for (Enemy03 e3 : GameFrame.getEnemyController().getE3()) {
                if(e3.locX != locX || e3.locY != locY) {
                    //   System.out.println("hi");
                    if (shapesIntersects.checkIntersect(locX + state.xTransfer - bigEnemyBodyImage.getWidth() / 2, locY + state.yTransfer - bigEnemyBodyImage.getHeight() / 2, bigEnemyBodyImage.getWidth(), bigEnemyBodyImage.getHeight()
                            , e3.locX + state.xTransfer - bigEnemyBodyImage.getWidth() / 2,e3.locY + state.yTransfer - bigEnemyBodyImage.getHeight() / 2 ,bigEnemyBodyImage.getWidth() ,bigEnemyBodyImage.getHeight() )
                            || shapesIntersects.checkIntersect(locX + state.xTransfer - bigEnemyBodyImage.getWidth() / 2, locY + state.yTransfer - bigEnemyBodyImage.getHeight() / 2, bigEnemyBodyImage.getWidth(), bigEnemyBodyImage.getHeight()
                            , state.locX - GameFrame.getMyTankImage().getWidth() / 2,state.locY - GameFrame.getMyTankImage().getHeight() / 2 ,GameFrame.getMyTankImage().getWidth() ,GameFrame.getMyTankImage().getHeight() ))
                    {
                     //   System.out.println("intersects between enemy 01 is True");
                        if(right)
                            locX -= speed;
                        if(left)
                            locX += speed;
                    }
               }
            }
        for (HardWall hW : GameFrame.getWallController().getHardWalls())
            if(shapesIntersects.checkIntersect(locX + state.xTransfer - GameFrame.getMyTankImage().getWidth() / 2, locY + state.yTransfer - GameFrame.getMyTankImage().getHeight() / 2, GameFrame.getMyTankImage().getWidth(), GameFrame.getMyTankImage().getHeight()
                    , hW.getLocX() + state.xTransfer, hW.getLocY() + state.yTransfer,hW.getHardWallImage().getWidth() ,hW.getHardWallImage().getHeight()))
            {
                if(right)
                    locX -= speed;
                if(left)
                    locX += speed;
            }
        for (SoftWall sW : GameFrame.getWallController().getSoftWalls())
            if(shapesIntersects.checkIntersect(locX + state.xTransfer - GameFrame.getMyTankImage().getWidth() / 2 + 2, locY + state.yTransfer - GameFrame.getMyTankImage().getHeight() / 2 + 2, GameFrame.getMyTankImage().getWidth() - 5, GameFrame.getMyTankImage().getHeight() - 5
                    , sW.getLocX() + state.xTransfer, sW.getLocY()  + state.yTransfer,sW.getSoftWall01Image().getWidth() ,sW.getSoftWall01Image().getHeight()))
            {
                if(right)
                    locX -= speed;
                if(left)
                    locX += speed;
            }
        for (Teazel teazel : GameFrame.getWallController().getTeazels())
            if(shapesIntersects.checkIntersect(locX + state.xTransfer - GameFrame.getMyTankImage().getWidth() / 2, locY + state.yTransfer - GameFrame.getMyTankImage().getHeight() / 2, GameFrame.getMyTankImage().getWidth(), GameFrame.getMyTankImage().getHeight()
                    , teazel.getLocX() + state.xTransfer, teazel.getLocY()  + state.yTransfer,teazel.getTeazelImage().getWidth() ,teazel.getTeazelImage().getHeight()))
            {
                if(right)
                    locX -= speed;
                if(left)
                    locX += speed;
            }
        for (Enemy02 e2 : GameFrame.getEnemyController().getE2())
            if(shapesIntersects.checkIntersect(locX + state.xTransfer - GameFrame.getMyTankImage().getWidth() / 2 + 2, locY + state.yTransfer - GameFrame.getMyTankImage().getHeight() / 2 + 2, GameFrame.getMyTankImage().getWidth() - 5, GameFrame.getMyTankImage().getHeight() - 5
                    , e2.getLocX() + state.xTransfer, e2.getLocY()  + state.yTransfer,e2.getMovingEnemyImage().getWidth() ,e2.getMovingEnemyImage().getHeight()))
            {
                if(right)
                    locX -= speed;
                if(left)
                    locX += speed;
            }
        for (Enemy01 e1 : GameFrame.getEnemyController().getE1())
            if(shapesIntersects.checkIntersect(locX + state.xTransfer - GameFrame.getMyTankImage().getWidth() / 2 + 2, locY + state.yTransfer - GameFrame.getMyTankImage().getHeight() / 2 + 2, GameFrame.getMyTankImage().getWidth() - 5, GameFrame.getMyTankImage().getHeight() - 5
                    , e1.getLocX() + state.xTransfer, e1.getLocY()  + state.yTransfer,e1.getSmallEnemyBodyImage().getWidth() ,e1.getSmallEnemyBodyImage().getHeight()))
            {
                if(right)
                    locX -= speed;
                if(left)
                    locX += speed;
            }
        /**
         * shoot bullet
         */
        if(Math.abs(state.locX - (locX + state.xTransfer)) <400 && Math.abs(state.locY - (locY + state.yTransfer)) < 400) {
            active = true;
            gunAngle = Math.toDegrees(Math.atan2(state.locY - (locY + state.yTransfer), state.locX - (locX + state.xTransfer)));
            if (i % 50 == 0)
                GameFrame.getBulletController().addBullet(new Enemy01Bullet(locX, locY, gunAngle, bigEnemyBodyImage));

            i++;
        }
        g.drawImage(bigEnemyBodyImage,tx,null);
        g.drawImage(bigEnemyGunImage, tx2, null);
    }

    public int getLocX() {
        return locX;
    }

    public void setLocX(int locX) {
        this.locX = locX;
    }

    public int getLocY() {
        return locY;
    }

    public void setLocY(int locY) {
        this.locY = locY;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public BufferedImage getBigEnemyBodyImage() {
        return bigEnemyBodyImage;
    }

    public boolean isHaveGun01food() {
        return haveGun01food;
    }

    public void setHaveGun01food(boolean haveGun01food) {
        this.haveGun01food = haveGun01food;
    }

    public boolean isHaveGun02Food() {
        return haveGun02Food;
    }

    public void setHaveGun02Food(boolean haveGun02Food) {
        this.haveGun02Food = haveGun02Food;
    }

    public boolean isHaveRepairFood() {
        return haveRepairFood;
    }

    public void setHaveRepairFood(boolean haveRepairFood) {
        this.haveRepairFood = haveRepairFood;
    }

    public boolean isHaveUpdateStar() {
        return haveUpdateStar;
    }

    public void setHaveUpdateStar(boolean haveUpdateStar) {
        this.haveUpdateStar = haveUpdateStar;
    }
}
