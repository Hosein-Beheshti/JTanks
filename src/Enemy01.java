import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * state of enemy 01
 */
public class Enemy01 {

    private int locX;
    private int locY;
    private int health;
    private double tankAngle = 0;
    private double gunAngle = 0;
    private  int i = 0;
    private boolean haveGun01food = false,haveGun02Food= false,haveRepairFood= false,haveUpdateStar= false;
    private int j = 0;
    private boolean limitMoving = false;


    private BufferedImage smallEnemyBodyImage;
    private BufferedImage smallEnemyGunImage;
    private EnemyTankRotation enemyTankRotation;

    private boolean up,down,right,left;

    public Enemy01(int locX,int locY)
    {
        if(GameFrame.getStartGame().easy)
            health = 200;
        if(GameFrame.getStartGame().normal)
            health = 300;
        if(GameFrame.getStartGame().hard)
            health = 400;

       this.locX = locX;
       this.locY = locY;
        try {
            smallEnemyBodyImage = ImageIO.read(new File("./images/SmallEnemyBody.png"));
            smallEnemyGunImage = ImageIO.read(new File("./images/SmallEnemyGun.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        enemyTankRotation = new EnemyTankRotation();
    }
    public void move() {


    }

    /**
     * render method draw enemy01 and set that rotate
     * and controll it's moving
     * and check intersects
     * @param g
     * @param state
     */
    public void render(Graphics2D g,GameState state) {
        /**
         * information EnemyTank
         */
        AffineTransform tx = new AffineTransform();
        tx.setToTranslation(locX  + state.xTransfer - smallEnemyBodyImage.getWidth() / 2 , locY + state.yTransfer - smallEnemyBodyImage.getHeight() / 2);
        tx.rotate(Math.toRadians(tankAngle), 50, 50);
        /**
         * information Enemy Gun
         */
        AffineTransform tx2 = new AffineTransform();
        tx2.setToTranslation(locX + state.xTransfer - smallEnemyGunImage.getWidth() / 5, locY + state.yTransfer - smallEnemyGunImage.getHeight() / 4.2);
        tx2.rotate(Math.toRadians(gunAngle), 20, 20);


//        Random random = new Random();
//        int angle = random.nextInt(360);
//        System.out.println(angle);
        /**
         * initialize is false
         */
//        if(j == 0)
//            limitMoving = false;
//
//        if(limitMoving == false)
//        {
//            locX ++ ;
//            j++;
//        }
//        if(j == 100)
//            limitMoving = true;
//        if(limitMoving == true)
//        {
//            locX -- ;
//            j--;
//        }


        up = false;
        down = false;
        right = false;
        left = false;
        if(Math.abs(state.locX - (locX + state.xTransfer)) < 400 && Math.abs(state.locY - (locY + state.yTransfer)) < 400) {
            if (state.locX  >= locX + state.xTransfer ) {
                locX++;
                right = true;
                left = false;
            }
            else {
                locX--;
                left = true;
                right = false;
            }

            if (state.locY  >= locY + state.yTransfer) {
                locY++;
                up = false;
                down = true;
            }
            else {
                locY--;
                down = false;
                up = true;
            }
            ShapesIntersects shapesIntersects = new ShapesIntersects();
            for (Enemy01 e1 : GameFrame.getEnemyController().getE1()) {
                if (e1.locX != locX || e1.locY != locY) {
                    //   System.out.println("hi");
                    if (shapesIntersects.checkIntersect(locX + state.xTransfer - smallEnemyBodyImage.getWidth() / 2, locY + state.yTransfer - smallEnemyBodyImage.getHeight() / 2, smallEnemyBodyImage.getWidth(), smallEnemyBodyImage.getHeight()
                            , e1.locX + state.xTransfer - smallEnemyBodyImage.getWidth() / 2, e1.locY + state.yTransfer - smallEnemyBodyImage.getHeight() / 2, smallEnemyBodyImage.getWidth(), smallEnemyBodyImage.getHeight())) {
                       // System.out.println("intersects between enemy 01 is True");
                        if (right) {
                            locX--;
                            right = false;
                        }
                        if (left) {
                            locX++;
                            left = false;
                        }
                        if (up) {
                            locY++;
                            up = false;
                        }
                        if (down) {
                            locY--;
                            down = false;
                        }
                    }
                }
            }
            if (shapesIntersects.checkIntersect(locX + state.xTransfer - smallEnemyBodyImage.getWidth() / 2, locY + state.yTransfer - smallEnemyBodyImage.getHeight() / 2, smallEnemyBodyImage.getWidth(), smallEnemyBodyImage.getHeight()
                    , state.locX - GameFrame.getMyTankImage().getWidth() / 2, state.locY - GameFrame.getMyTankImage().getHeight() / 2, GameFrame.getMyTankImage().getWidth(), GameFrame.getMyTankImage().getHeight()))
            {
                if (right) {
                    locX--;
                    right = false;
                }
                if (left) {
                    locX++;
                    left = false;
                }
                if (up) {
                    locY++;
                    up = false;
                }
                if (down) {
                    locY--;
                    down = false;
                }
            }
                for (HardWall hW : GameFrame.getWallController().getHardWalls())
                    if(shapesIntersects.checkIntersect(locX + state.xTransfer - GameFrame.getMyTankImage().getWidth() / 2, locY + state.yTransfer - GameFrame.getMyTankImage().getHeight() / 2, GameFrame.getMyTankImage().getWidth(), GameFrame.getMyTankImage().getHeight()
                            , hW.getLocX() + state.xTransfer, hW.getLocY() + state.yTransfer,hW.getHardWallImage().getWidth() ,hW.getHardWallImage().getHeight()))
                    {
                        if(right)
                            locX--;
                        if(left)
                            locX++;
                        if(up)
                            locY++;
                        if (down)
                            locY--;
                    }
                for (SoftWall sW : GameFrame.getWallController().getSoftWalls())
                    if(shapesIntersects.checkIntersect(locX + state.xTransfer - GameFrame.getMyTankImage().getWidth() / 2 + 2, locY + state.yTransfer - GameFrame.getMyTankImage().getHeight() / 2 + 2, GameFrame.getMyTankImage().getWidth() - 5, GameFrame.getMyTankImage().getHeight() - 5
                            , sW.getLocX() + state.xTransfer, sW.getLocY()  + state.yTransfer,sW.getSoftWall01Image().getWidth() ,sW.getSoftWall01Image().getHeight()))
                    {
                        if(right)
                            locX--;
                        if(left)
                            locX++;
                        if(up)
                            locY++;
                        if (down)
                            locY--;
                    }
                for (Teazel teazel : GameFrame.getWallController().getTeazels())
                    if(shapesIntersects.checkIntersect(locX + state.xTransfer - GameFrame.getMyTankImage().getWidth() / 2, locY + state.yTransfer - GameFrame.getMyTankImage().getHeight() / 2, GameFrame.getMyTankImage().getWidth(), GameFrame.getMyTankImage().getHeight()
                            , teazel.getLocX() + state.xTransfer, teazel.getLocY()  + state.yTransfer,teazel.getTeazelImage().getWidth() ,teazel.getTeazelImage().getHeight()))
                    {
                        if(right)
                            locX--;
                        if(left)
                            locX++;
                        if(up)
                            locY++;
                        if (down)
                            locY--;
                    }
            for (Enemy02 e2 : GameFrame.getEnemyController().getE2())
                if(shapesIntersects.checkIntersect(locX + state.xTransfer - GameFrame.getMyTankImage().getWidth() / 2 + 2, locY + state.yTransfer - GameFrame.getMyTankImage().getHeight() / 2 + 2, GameFrame.getMyTankImage().getWidth() - 5, GameFrame.getMyTankImage().getHeight() - 5
                        , e2.getLocX() + state.xTransfer, e2.getLocY()  + state.yTransfer,e2.getMovingEnemyImage().getWidth() ,e2.getMovingEnemyImage().getHeight()))
                {
                    if(right)
                        locX--;
                    if(left)
                        locX++;
                    if(up)
                        locY++;
                    if (down)
                        locY--;
                }
            for (Enemy03 e3 : GameFrame.getEnemyController().getE3())
                if(shapesIntersects.checkIntersect(locX + state.xTransfer - GameFrame.getMyTankImage().getWidth() / 2 + 2, locY + state.yTransfer - GameFrame.getMyTankImage().getHeight() / 2 + 2, GameFrame.getMyTankImage().getWidth() - 5, GameFrame.getMyTankImage().getHeight() - 5
                        , e3.getLocX() + state.xTransfer, e3.getLocY()  + state.yTransfer,e3.getBigEnemyBodyImage().getWidth() ,e3.getBigEnemyBodyImage().getHeight()))
                {
                    if(right)
                        locX--;
                    if(left)
                        locX++;
                    if(up)
                        locY++;
                    if (down)
                        locY--;
                }

                    tankAngle = enemyTankRotation.getAngle(up, down, left, right);
                    enemyTankRotation.setTankAngle(tankAngle);
            gunAngle = Math.toDegrees(Math.atan2(state.locY - (locY + state.yTransfer), state.locX - (locX + state.xTransfer)));
//            Random random = new Random();
//            int n = random.nextInt(10);
//            if (n == 3)
            if(i % 50 == 0)
                GameFrame.getBulletController().addBullet(new Enemy01Bullet(locX,locY ,gunAngle,smallEnemyGunImage));

            i++;
            //  angle = Math.toDegrees(Math.atan2(state.mouseY - state.locY - myTankImage.getHeight() / 2, state.mouseX - state.locX - myTankImage.getWidth() / 2));
        }
//        System.out.println("loc x = " + locX);
//        System.out.println("loc y = " + locY);
        g.drawImage(smallEnemyBodyImage,tx,null);
        g.drawImage(smallEnemyGunImage, tx2, null);
//            System.out.println("enemy 01 loc x = " + locX);
//            System.out.println("enemy 01 loc y = " + locY);
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

    public BufferedImage getSmallEnemyBodyImage() {
        return smallEnemyBodyImage;
    }

    public void setSmallEnemyBodyImage(BufferedImage smallEnemyBodyImage) {
        this.smallEnemyBodyImage = smallEnemyBodyImage;
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
