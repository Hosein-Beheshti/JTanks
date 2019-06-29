import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * this class draw our tank health
 * in the height of frame
 */
public class DrawHealth {

    private BufferedImage healthImage;
    private BufferedImage wHealthImage;

    /**
     * constructor
     */
    public DrawHealth()
    {
        try {
            healthImage = ImageIO.read(new File("./images/health.png"));
            wHealthImage = ImageIO.read(new File("./images/wHealth.png"));
        } catch (IOException e) {
            System.out.println("bitch choose true adress");
            e.printStackTrace();
        }
    }

    /**
     * render draw health
     * @param g
     * @param state
     */
    public void render(Graphics2D g, GameState state)
    {
       // System.out.println("hi");
        if(state.health > 400) {
            g.drawImage(healthImage, GameFrame.GAME_WIDTH / 2 - 100, 40, null);
            g.drawImage(healthImage, GameFrame.GAME_WIDTH / 2 - 50, 40, null);
            g.drawImage(healthImage, GameFrame.GAME_WIDTH / 2, 40, null);
            g.drawImage(healthImage, GameFrame.GAME_WIDTH / 2 + 50, 40, null);
            g.drawImage(healthImage, GameFrame.GAME_WIDTH / 2 + 100, 40, null);
        }
        if(state.health > 300 && state.health <= 400) {
            g.drawImage(healthImage, GameFrame.GAME_WIDTH / 2 - 100, 40, null);
            g.drawImage(healthImage, GameFrame.GAME_WIDTH / 2 - 50, 40, null);
            g.drawImage(healthImage, GameFrame.GAME_WIDTH / 2, 40, null);
            g.drawImage(healthImage, GameFrame.GAME_WIDTH / 2 + 50, 40, null);
            g.drawImage(wHealthImage, GameFrame.GAME_WIDTH / 2 + 100, 40, null);
        }
        if(state.health > 200 && state.health <= 300) {
            g.drawImage(healthImage, GameFrame.GAME_WIDTH / 2 - 100, 40, null);
            g.drawImage(healthImage, GameFrame.GAME_WIDTH / 2 - 50, 40, null);
            g.drawImage(healthImage, GameFrame.GAME_WIDTH / 2, 40, null);
            g.drawImage(wHealthImage, GameFrame.GAME_WIDTH / 2 + 50, 40, null);
            g.drawImage(wHealthImage, GameFrame.GAME_WIDTH / 2 + 100, 40, null);
        }
        if(state.health > 100 && state.health <= 200) {
            g.drawImage(healthImage, GameFrame.GAME_WIDTH / 2 - 100, 40, null);
            g.drawImage(healthImage, GameFrame.GAME_WIDTH / 2 - 50, 40, null);
            g.drawImage(wHealthImage, GameFrame.GAME_WIDTH / 2, 40, null);
            g.drawImage(wHealthImage, GameFrame.GAME_WIDTH / 2 + 50, 40, null);
            g.drawImage(wHealthImage, GameFrame.GAME_WIDTH / 2 + 100, 40, null);
        }
        if(state.health > 0 && state.health <= 100) {
            g.drawImage(healthImage, GameFrame.GAME_WIDTH / 2 - 100, 40, null);
            g.drawImage(wHealthImage, GameFrame.GAME_WIDTH / 2 - 50, 40, null);
            g.drawImage(wHealthImage, GameFrame.GAME_WIDTH / 2, 40, null);
            g.drawImage(wHealthImage, GameFrame.GAME_WIDTH / 2 + 50, 40, null);
            g.drawImage(wHealthImage, GameFrame.GAME_WIDTH / 2 + 100, 40, null);
        }
        if(state.health <= 0) {
            g.drawImage(wHealthImage, GameFrame.GAME_WIDTH / 2 - 100, 40, null);
            g.drawImage(wHealthImage, GameFrame.GAME_WIDTH / 2 - 50, 40, null);
            g.drawImage(wHealthImage, GameFrame.GAME_WIDTH / 2, 40, null);
            g.drawImage(wHealthImage, GameFrame.GAME_WIDTH / 2 + 50, 40, null);
            g.drawImage(wHealthImage, GameFrame.GAME_WIDTH / 2 + 100, 40, null);
        }


    }
}
