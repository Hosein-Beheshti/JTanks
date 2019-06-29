import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * state and render teazel
 */
public class Teazel {


        private int locX;
        private int locY;

        private BufferedImage teazelImage;

        public Teazel(int locX , int locY)
        {
            this.locX = locX;
            this.locY = locY;

            try {
                teazelImage = ImageIO.read(new File("./images/teazel.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public void render(Graphics2D g, GameState state) {
            g.drawImage(teazelImage,locX + state.xTransfer,locY + state.yTransfer, null );
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

    public BufferedImage getTeazelImage() {
        return teazelImage;
    }

    public void setTeazelImage(BufferedImage teazelImage) {
        this.teazelImage = teazelImage;
    }
}
