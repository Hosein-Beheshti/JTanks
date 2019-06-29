import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Enemy04 {
    private int locX;
    private int locY;
    private static int demage = 100;
    private boolean active = false;

    private BufferedImage mineImage;
    public Enemy04(int locX, int locY)
    {
        this.locX = locX;
        this.locY = locY;
        try {
            mineImage = ImageIO.read(new File("./images/mine.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * render method draw enemy04
     *
     **/
    public void render(Graphics2D g, GameState state) {
        if(!active)
        if(Math.abs(state.locX - (locX + state.xTransfer)) <200 && Math.abs(state.locY - (locY + state.yTransfer)) < 200) {
            Sound sound1 = new Sound("./Sounds/mine.wav" , 0);
            sound1.doInBackground();
            active = true;
        }
        if(active)
        g.drawImage(mineImage, locX + state.xTransfer , locY + state.yTransfer ,null );
    }

    public int getLocX() {
        return locX;
    }

    public int getLocY() {
        return locY;
    }

    public BufferedImage getMineImage() {
        return mineImage;
    }

    public static int getDemage() {
        return demage;
    }
}
