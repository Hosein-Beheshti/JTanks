import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * this class do moving and drawing
 * enemy01 bullet
 */
public class Enemy01Bullet {
    private double x;
    private double y;
    private double angle;
    private double radianse;

    private boolean myGun01 , myGun02;

    private final int speed = 5;
    private final static int enemy01Bulletdamage = 100;


    private BufferedImage enemy01BulletImage;
    private BufferedImage image;

    public Enemy01Bullet(double x, double y, double angle, BufferedImage image) {

        Sound sound1 = new Sound("./Sounds/enemyshot.wav" , 0);
        sound1.doInBackground();

        this.angle = angle;
        this.image = image;
        radianse = Math.toRadians(angle);
        this.x = x - 4 + image.getWidth() * Math.cos(radianse) / 2;
        this.y = y - 12 + image.getWidth() * Math.sin(radianse) / 2;


        try {
            enemy01BulletImage = ImageIO.read(new File("./images/Enemy01Bullet.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * this method move enemy01 bullet
     */
    public void move() {

//        System.out.println(Math.cos(radianse));
//        System.out.format("The value of pi is %.4f%n", Math.cos(radianse));
        x += speed * Math.cos(radianse);
        y += speed * Math.sin(radianse);

//        ShapesIntersects shapesIntersects = new ShapesIntersects();
//        shapesIntersects.checkIntersect((int)x,(int)y,myHeavyBullet.getWidth(),myHeavyBullet.getHeight() ,500 ,500 ,100 ,100 );
    }

    /**
     * drawing with rotation bullet
     * @param g
     */
    public void render(Graphics2D g,GameState state) {
        AffineTransform tx = new AffineTransform();
        tx.setToTranslation(x + state.xTransfer, y + state.yTransfer );
        //    tx.setToTranslation(x + 23 + image.getWidth()*M,y + 20 );

       tx.rotate(Math.toRadians(angle), enemy01BulletImage.getWidth()/2.3 , enemy01BulletImage.getHeight()/2);
        g.drawImage(enemy01BulletImage, tx, null);
      //  g.drawImage(GameFrame.getTest() ,(int)x ,(int) y , null);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public static int getEnemy01Bulletdamage() {
        return enemy01Bulletdamage;
    }

    public BufferedImage getEnemy01BulletImage() {
        return enemy01BulletImage;
    }
}
