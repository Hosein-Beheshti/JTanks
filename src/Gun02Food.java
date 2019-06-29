import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * this class draw a food
 *that if our tank have intersect with it
 * our light bullets will be increase
 */
public class Gun02Food {

        private int locX;
        private int locY;

        private static final int numberOfBullets = 100;

        private BufferedImage gun02FoodImage;

        public Gun02Food(int locX, int locY) {
            this.locX = locX;
            this.locY = locY;

            try {
                gun02FoodImage = ImageIO.read(new File("./images/gun02Food.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void render(Graphics2D g,GameState state) {
            g.drawImage(gun02FoodImage, locX + state.xTransfer, locY + state.yTransfer, null);
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

    public static int getNumberOfBullets() {
        return numberOfBullets;
    }

    public BufferedImage getGun02FoodImage() {
        return gun02FoodImage;
    }
}
