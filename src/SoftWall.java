import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SoftWall {

    private int locX;
    private int locY;

    private int health = 400 ;

    private BufferedImage softWall01Image;
    private BufferedImage softWall02Image;
    private BufferedImage softWall03Image;
    private BufferedImage softWall04Image;
    private boolean haveGun01food = false,haveGun02Food= false,haveRepairFood= false,haveUpdateStar= false;


    public SoftWall(int locX , int locY)
    {
        this.locX = locX;
        this.locY = locY;

        try {
            softWall01Image = ImageIO.read(new File("./images/softWall.png"));
            softWall02Image = ImageIO.read(new File("./images/softWall1.png"));
            softWall03Image = ImageIO.read(new File("./images/softWall2.png"));
            softWall04Image = ImageIO.read(new File("./images/softWall3.png"));

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("can not find soft wall images");
        }
    }
    public void render(Graphics2D g ,GameState state) {
       if (health > 300)
            g.drawImage(softWall01Image,locX + state.xTransfer ,locY + state.yTransfer, null );
       else if (health > 200)
            g.drawImage(softWall02Image,locX + state.xTransfer ,locY + state.yTransfer, null );
      else if (health > 100)
            g.drawImage(softWall03Image,locX + state.xTransfer ,locY + state.yTransfer, null );
       else if (health > 0)
            g.drawImage(softWall04Image,locX + state.xTransfer,locY + state.yTransfer, null );

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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public BufferedImage getSoftWall01Image() {
        return softWall01Image;
    }

    public BufferedImage getSoftWall02Image() {
        return softWall02Image;
    }

    public BufferedImage getSoftWall03Image() {
        return softWall03Image;
    }

    public BufferedImage getSoftWall04Image() {
        return softWall04Image;
    }

    public boolean isHaveGun01food() {
        return haveGun01food;
    }

    public void setHaveGun01food(boolean haveGun01food) {
        this.haveGun01food = haveGun01food;
    }

    public boolean isHaveGun02Food() {
        return haveGun02Food;
    }

    public void setHaveGun02Food(boolean haveGun02Food) {
        this.haveGun02Food = haveGun02Food;
    }

    public boolean isHaveRepairFood() {
        return haveRepairFood;
    }

    public void setHaveRepairFood(boolean haveRepairFood) {
        this.haveRepairFood = haveRepairFood;
    }

    public boolean isHaveUpdateStar() {
        return haveUpdateStar;
    }

    public void setHaveUpdateStar(boolean haveUpdateStar) {
        this.haveUpdateStar = haveUpdateStar;
    }
}
