import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * this class contain my Bullets
 * this class render my bullets
 */
public class Bullet {
    private double x;
    private double y;
    private double angle;
    private double radianse;

    private boolean myGun01 , myGun02;

    private static int heavyBulletSpeed = 15;
    private static int lightBulletSpeed = 15;



    private BufferedImage myHeavyBullet;
    private BufferedImage myLightBullet;

    private static int myHeavyBulletDamage = 100;
    private static int myLightBulletDamage = 20;

    /**
     * this is my class constractor
     * @param x
     * @param y
     * @param angle
     * @param myGun01
     * @param myGun02
     */
    public Bullet(double x , double y , double angle , boolean myGun01 , boolean myGun02) {
        this.angle = angle;
        radianse = Math.toRadians(angle);
        this.x = x + GameFrame.getMyTankGun01Image().getWidth() * Math.cos(radianse) / 1.7;
        this.y = y + GameFrame.getMyTankGun01Image().getWidth() * Math.sin(radianse) / 1.7;

        this.myGun01 = myGun01;
        this.myGun02 = myGun02;

        try {
            myHeavyBullet = ImageIO.read(new File("./images/HeavyBullet.png"));
            myLightBullet = ImageIO.read(new File("./images/LightBullet.png"));
        } catch (IOException e) {
            System.out.println("I can't new this image");
            e.printStackTrace();
        }

    }

    /**
     * moving my bullets
     */
    public void move() {

//        System.out.println(Math.cos(radianse));
//        System.out.format("The value of pi is %.4f%n", Math.cos(radianse));
        if(myGun01) {
            x += heavyBulletSpeed * Math.cos(radianse);
            y += heavyBulletSpeed * Math.sin(radianse);
        }
        if(myGun02) {
            x += lightBulletSpeed * Math.cos(radianse);
            y += lightBulletSpeed * Math.sin(radianse);
        }

    }

    /**
     * render my bullets
     * @param g
     * @param state
     */
    public void render(Graphics2D g,GameState state) {
        AffineTransform tx = new AffineTransform();
        tx.setToTranslation(x  ,y);
        //    tx.setToTranslation(x + 23 + image.getWidth()*M,y + 20 );

        tx.rotate(Math.toRadians(angle), myHeavyBullet.getWidth() / 2.3, myHeavyBullet.getHeight() / 2);
        if(myGun01) {
            g.drawImage(myHeavyBullet, tx, null);
         //   g.drawImage(GameFrame.getTest(), (int)x, (int)y,null );
        }
        else if(myGun02)
        {
            g.drawImage(myLightBullet, tx, null);
        }
    }

    /**
     * getters and setters
     *
     */
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public BufferedImage getMyHeavyBullet() {
        return myHeavyBullet;
    }

    public void setMyHeavyBullet(BufferedImage myHeavyBullet) {
        this.myHeavyBullet = myHeavyBullet;
    }

    public BufferedImage getMyLightBullet() {
        return myLightBullet;
    }

    public void setMyLightBullet(BufferedImage myLightBullet) {
        this.myLightBullet = myLightBullet;
    }

    public static int getHeavyBulletSpeed() {
        return heavyBulletSpeed;
    }

    public static void setHeavyBulletSpeed(int heavyBulletSpeed) {
        Bullet.heavyBulletSpeed = heavyBulletSpeed;
    }

    public static int getLightBulletSpeed() {
        return lightBulletSpeed;
    }

    public static void setLightBulletSpeed(int lightBulletSpeed) {
        Bullet.lightBulletSpeed = lightBulletSpeed;
    }

    public static int getMyHeavyBulletDamage() {
        return myHeavyBulletDamage;
    }

    public static void setMyHeavyBulletDamage(int myHeavyBulletDamage) {
        Bullet.myHeavyBulletDamage = myHeavyBulletDamage;
    }

    public static int getMyLightBulletDamage() {
        return myLightBulletDamage;
    }

    public static void setMyLightBulletDamage(int myLightBulletDamage) {
        Bullet.myLightBulletDamage = myLightBulletDamage;
    }

    public boolean isMyGun01() {
        return myGun01;
    }

    public boolean isMyGun02() {
        return myGun02;
    }
}
