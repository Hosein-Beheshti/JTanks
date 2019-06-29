import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * this class draw a food
 *that if our tank have intersect with it
 * our heavy bullets will be increase
 */
public class Gun01Food {

        private int locX;
        private int locY;

        private static final int numberOfBullets = 40;

        private BufferedImage gun01FoodImage;

    /**
     * constructor
     * @param locX
     * @param locY
     */
    public Gun01Food(int locX, int locY) {
            this.locX = locX;
            this.locY = locY;

            try {
                gun01FoodImage = ImageIO.read(new File("./images/gun01Food.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void render(Graphics2D g,GameState state) {
            g.drawImage(gun01FoodImage, locX + state.xTransfer, locY + state.yTransfer, null);
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

    public BufferedImage getGun01FoodImage() {
        return gun01FoodImage;
    }

    public static int getNumberOfBullets() {
        return numberOfBullets;
    }
}

