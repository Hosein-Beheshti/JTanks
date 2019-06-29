import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * draw update star that it update our tank gun
 */
public class UpdateStar {

        private int locX;
        private int locY;

        private BufferedImage updateStarImage;

        public UpdateStar(int locX, int locY) {
            this.locX = locX;
            this.locY = locY;

            try {
                updateStarImage = ImageIO.read(new File("./images/updateStar1.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void render(Graphics2D g,GameState state) {
            g.drawImage(updateStarImage, locX + state.xTransfer, locY + state.yTransfer, null);
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

    public BufferedImage getUpdateStarImage() {
        return updateStarImage;
    }
}
