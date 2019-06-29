import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * draw soils
 */
public class Soil {

        private int locX;
        private int locY;

        private static BufferedImage soilImage;

    /**
     * constructor
     * @param locX
     * @param locY
     */
    public Soil(int locX , int locY)
        {
            this.locX = locX;
            this.locY = locY;

            try {
                soilImage = ImageIO.read(new File("./images/soil.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public void render(Graphics2D g, GameState state) {
            g.drawImage(soilImage,locX + state.xTransfer,locY + state.yTransfer, null );
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

    public static BufferedImage getSoilImage() {
        return soilImage;
    }

    public static void setSoilImage(BufferedImage soilImage) {
        Soil.soilImage = soilImage;
    }
}
