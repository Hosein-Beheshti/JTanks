import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * draw hard walls
 */
public class HardWall {

    private int locX;
    private int locY;

    private BufferedImage hardWallImage;

    /**
     * constructor
     * @param locX
     * @param locY
     */
    public HardWall(int locX , int locY)
    {
        this.locX = locX;
        this.locY = locY;

        try {
            hardWallImage = ImageIO.read(new File("./images/hardWall.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * render
     * @param g
     * @param state
     */
    public void render(Graphics2D g,GameState state) {
       // if(Math.abs((locX + state.xTransfer) - GameFrame.GAME_WIDTH / 2 ) < 800 )
        g.drawImage(hardWallImage,locX + state.xTransfer,locY + state.yTransfer, null );
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

    public BufferedImage getHardWallImage() {
        return hardWallImage;
    }

    public void setHardWallImage(BufferedImage hardWallImage) {
        this.hardWallImage = hardWallImage;
    }
}
