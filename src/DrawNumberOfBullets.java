import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * draw number of my heavy and light bullet
 * in the left and up my frame
 */
public class DrawNumberOfBullets {

    private BufferedImage numberOfHeavyBullet;
    private BufferedImage numberOfLightBullet;

    /**
     * constructor
     */
    public DrawNumberOfBullets()
    {
        try {
            numberOfHeavyBullet = ImageIO.read(new File("./images/NumberOfHeavyBullet.png"));
            numberOfLightBullet = ImageIO.read(new File("./images/NumberOfLightBullet.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * render
     * @param g
     * @param state
     */
    public void render(Graphics2D g , GameState state)
    {
        g.drawImage(numberOfHeavyBullet,310 , 35, null);
        String numberOfHeavybullets = state.numberOfHeavyBullets + "";
        g.setColor(Color.green);
        g.setFont(g.getFont().deriveFont(18.0f));
        g.drawString(numberOfHeavybullets,330, 87);

        g.drawImage(numberOfLightBullet,310 , 100, null);
        String numberOfLightBullets = state.numberOfLightBullets + "";
        g.setColor(Color.green);
        g.setFont(g.getFont().deriveFont(18.0f));
        g.drawString(numberOfLightBullets,330, 150);
    }
}
