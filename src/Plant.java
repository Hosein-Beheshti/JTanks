import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * draw plants
 */
public class Plant {
    private int locX;
    private int locY;

    private BufferedImage plantImage;

    public Plant(int locX , int locY)
    {
        this.locX = locX;
        this.locY = locY;

        try {
            plantImage = ImageIO.read(new File("./images/plant.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void render(Graphics2D g, GameState state) {
        g.drawImage(plantImage,locX + state.xTransfer,locY + state.yTransfer, null );
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

    public BufferedImage getPlantImage() {
        return plantImage;
    }

    public void setPlantImage(BufferedImage plantImage) {
        this.plantImage = plantImage;
    }
}
