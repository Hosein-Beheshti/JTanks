import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SpeedFood {

    private int locX;
    private int locY;

    private BufferedImage speedFood;

    public SpeedFood(int locX, int locY) {
        this.locX = locX;
        this.locY = locY;

        try {
            speedFood = ImageIO.read(new File("./images/SpeedFood.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void render(Graphics2D g, GameState state) {
        g.drawImage(speedFood, locX + state.xTransfer, locY + state.yTransfer, null);
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

    public BufferedImage getSpeedFood() {
        return speedFood;
    }
}
