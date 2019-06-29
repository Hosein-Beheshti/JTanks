import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * draw finish line
 * that if we go on thats
 * that stage will be finish
 */
public class FinishLine {
    private int locX;
    private int locY;

    private BufferedImage finishLineImage;

    /**
     * constructor
     * @param locX
     * @param locY
     */
    public FinishLine(int locX, int locY)
    {
        this.locX = locX;
        this.locY = locY;
        try {
            finishLineImage = ImageIO.read(new File("./images/finishLine.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void render(Graphics2D g, GameState state) {
            g.drawImage(finishLineImage, locX + state.xTransfer , locY + state.yTransfer ,null );
    }

    public int getLocX() {
        return locX;
    }

    public int getLocY() {
        return locY;
    }

    public BufferedImage getFinishLineImage() {
        return finishLineImage;
    }
}