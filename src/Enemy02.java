import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Enemy02 {

    private int locX;
    private int locY;
    private int health;
    private static int demage = 100;
    private double angle = 0;
    private int i = 0;
    private boolean active = false;
    private boolean haveGun01food = false,haveGun02Food= false,haveRepairFood= false,haveUpdateStar= false;

    private BufferedImage movingEnemyImage;
    private BufferedImage movingEnemy2Image;

    private boolean right,left,up,down;

    public Enemy02(int locX,int locY)
    {
        if(GameFrame.getStartGame().easy)
            health = 100;
        if(GameFrame.getStartGame().normal)
            health = 200;
        if(GameFrame.getStartGame().hard)
            health = 300;


        this.locX = locX;
        this.locY = locY;
        try {
            movingEnemyImage = ImageIO.read(new File("./images/movingEnemy.png"));
            movingEnemy2Image = ImageIO.read(new File("./images/movingEnemy2.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void move() {


    }
    /**
     * render method draw enemy02 and set that rotate
     * and controll it's moving
     * and check intersects
     * @param g
     * @param state
     */
    public void render(Graphics2D g,GameState state) {

//        Random random = new Random();
//        int angle = random.nextInt(360);
//        System.out.println(angle);
        up = false;
        down = false;
        right = false;
        left = false;

        if(Math.abs(state.locX - (locX + state.xTransfer)) <400 && Math.abs(state.locY - (locY + state.yTransfer)) < 400) {
            active = true;
        }
        if(active)
        {
            if (state.locX > locX + state.xTransfer) {
                locX = locX + 3;
                right = true;
            }
            else if(state.locX < locX + state.xTransfer) {
                locX = locX - 3;
                left = true;
            }

            if (state.locY > locY + state.yTransfer) {
                locY = locY + 3;
                up = true;
            }
            else if(state.locY < locY + state.yTransfer) {
                locY = locY - 3;
                down = true;
            }

            ShapesIntersects shapesIntersects = new ShapesIntersects();
            for (Enemy02 e2 : GameFrame.getEnemyController().getE2()) {
            if(e2.locX != locX || e2.locY != locY) {
                if (shapesIntersects.checkIntersect(locX - movingEnemyImage.getWidth() / 2, locY - movingEnemyImage.getHeight() / 2, movingEnemyImage.getWidth() / 2, movingEnemyImage.getHeight() / 2
                        , e2.locX - movingEnemyImage.getWidth() / 2,e2.locY - movingEnemyImage.getHeight() / 2 ,movingEnemyImage.getWidth() / 2 ,movingEnemyImage.getHeight() / 2 ))
                {
                    if(right)
                        locX = locX - 3;
                    if(left)
                        locX = locX + 3;
                    if(up)
                        locY = locY - 3;
                    if (down)
                        locY = locY + 3;
                }
            }
        }
            for (Enemy01 e1 : GameFrame.getEnemyController().getE1()) {
            if (shapesIntersects.checkIntersect(locX - movingEnemyImage.getWidth() / 2, locY - movingEnemyImage.getHeight() / 2, movingEnemyImage.getWidth() / 2, movingEnemyImage.getHeight() / 2
                    , e1.getLocX() - e1.getSmallEnemyBodyImage().getWidth() / 2,e1.getLocY() - e1.getSmallEnemyBodyImage().getHeight() / 2 ,e1.getSmallEnemyBodyImage().getWidth() / 2 ,e1.getSmallEnemyBodyImage().getHeight() / 2 ))
            {
                if(right)
                    locX = locX - 3;
                if(left)
                    locX = locX + 3;
                if(up)
                    locY = locY - 3;
                if (down)
                    locY = locY + 3;
            }
        }
            for (Enemy03 e3 : GameFrame.getEnemyController().getE3()) {
                if (shapesIntersects.checkIntersect(locX - movingEnemyImage.getWidth() / 2, locY - movingEnemyImage.getHeight() / 2, movingEnemyImage.getWidth() / 2, movingEnemyImage.getHeight() / 2
                        , e3.getLocX() - e3.getBigEnemyBodyImage().getWidth() / 2,e3.getLocY() - e3.getBigEnemyBodyImage().getHeight() / 2 ,e3.getBigEnemyBodyImage().getWidth() / 2 ,e3.getBigEnemyBodyImage().getHeight() / 2 ))
                {
                    if(right)
                        locX = locX - 3;
                    if(left)
                        locX = locX + 3;
                    if(up)
                        locY = locY - 3;
                    if (down)
                        locY = locY + 3;
                }
            }
            for (HardWall hw : GameFrame.getWallController().getHardWalls()) {
                if (shapesIntersects.checkIntersect(locX - movingEnemyImage.getWidth() / 2 + 30, locY - movingEnemyImage.getHeight() / 2 +30, movingEnemyImage.getWidth() / 3, movingEnemyImage.getHeight() / 3
                        , hw.getLocX(),hw.getLocY() ,hw.getHardWallImage().getWidth()  ,hw.getHardWallImage().getHeight() ))
                {
                    if(right)
                        locX = locX - 3;
                    if(left)
                        locX = locX + 3;
                    if(up)
                        locY = locY - 3;
                    if (down)
                        locY = locY + 3;
                }
            }
            for (SoftWall sW : GameFrame.getWallController().getSoftWalls()) {
                if (shapesIntersects.checkIntersect(locX - movingEnemyImage.getWidth() / 2 + 30, locY - movingEnemyImage.getHeight() / 2 +30, movingEnemyImage.getWidth() / 3, movingEnemyImage.getHeight() / 3
                        , sW.getLocX(),sW.getLocY() ,sW.getSoftWall01Image().getWidth()  ,sW.getSoftWall01Image().getHeight() ))
                {
                    if(right)
                        locX = locX - 3;
                    if(left)
                        locX = locX + 3;
                    if(up)
                        locY = locY - 3;
                    if (down)
                        locY = locY + 3;
                }
            }
            for (Teazel teazel : GameFrame.getWallController().getTeazels()) {
                if (shapesIntersects.checkIntersect(locX - movingEnemyImage.getWidth() / 2 + 30, locY - movingEnemyImage.getHeight() / 2 +30, movingEnemyImage.getWidth() / 3, movingEnemyImage.getHeight() / 3
                        , teazel.getLocX(),teazel.getLocY() ,teazel.getTeazelImage().getWidth()  ,teazel.getTeazelImage().getHeight() ))
                {
                    if(right)
                        locX = locX - 3;
                    if(left)
                        locX = locX + 3;
                    if(up)
                        locY = locY - 3;
                    if (down)
                        locY = locY + 3;
                }
            }



//            if(i % 4 == 0)
//                g.drawImage(movingEnemy2Image,tx,null);
//
//            else
//                g.drawImage(movingEnemy2Image,tx,null);
//            i++;
            angle = Math.toDegrees(Math.atan2(state.locY - (locY + state.yTransfer) - movingEnemyImage.getHeight() / 2, state.locX - (locX + state.xTransfer) - movingEnemyImage.getWidth() / 2));
            AffineTransform tx = new AffineTransform();
            tx.setToTranslation(locX + state.xTransfer - movingEnemyImage.getWidth() / 2, locY + state.yTransfer - movingEnemyImage.getHeight() / 2);
            tx.rotate(Math.toRadians(angle), 50, 50);
            g.drawImage(movingEnemyImage,tx,null);
        }




        //  g.drawImage(GameFrame.getTest(), locX,locY ,null);

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

    public BufferedImage getMovingEnemyImage() {
        return movingEnemyImage;
    }

    public static int getDemage() {
        return demage;
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
