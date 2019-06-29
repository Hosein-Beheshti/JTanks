import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * repair our tank
 */
public class RepairFood {


    private int locX;
    private int locY;

    private static final int repairHealth = 100;

    private BufferedImage repairFoodImage;

    public RepairFood(int locX, int locY) {
        this.locX = locX;
        this.locY = locY;

        try {
            repairFoodImage = ImageIO.read(new File("./images/RepairFood.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void render(Graphics2D g,GameState state) {
        g.drawImage(repairFoodImage, locX + state.xTransfer , locY + state.yTransfer, null);
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

    public BufferedImage getRepairFoodImage() {
        return repairFoodImage;
    }

    public static int getRepairHealth() {
        return repairHealth;
    }
}



