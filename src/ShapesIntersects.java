import javax.swing.*;
import java.awt.*;

import static java.awt.Color.*;

/**
 * this class check intersects
 */
public class ShapesIntersects extends JComponent{

    private Rectangle r1,r2;
    private Graphics2D g;

    private int x1 = 0,y1 = 0,width1 = 0,height1 = 0;
    private int x2 = 0,y2 = 0,width2 = 0,height2 = 0;

    public ShapesIntersects()
    {

    }

    /**
     * this method take me two state and
     * draw rect and give me a boolean for intersect
     * @param x1
     * @param y1
     * @param width1
     * @param height1
     * @param x2
     * @param y2
     * @param width2
     * @param height2
     * @return
     */
    public boolean checkIntersect(int x1,int y1,int width1,int height1,int x2,int y2,int width2,int height2)
    {
        this.x1 = x1;
        this.y1 = y1;
        this.width1 = width1;
        this.height1 = height1;
        this.x2 = x2;
        this.y2 = y2;
        this.width2 = width2;
        this.height2 = height2;


        Rectangle r1 = new Rectangle(x1,y1,width1,height1);
        Rectangle r2 = new Rectangle(x2,y2,width2,height2);

       // g.setColor(new Color(212, 212, 212));
//        g.drawRect(x, y, width, height);
//        g.drawRect(x2, y2, width2, height2);


        return r1.intersects(r2);
    }
    public void setGraphic(Graphics2D g,GameState state)
    {
       this.g = g;
        g.setColor(red);
       // g.drawRect(100, 100, 100,100 );
       // g.drawRect(state.locX, state.locY,GameFrame.getMyTankImage().getWidth() ,GameFrame.getMyTankGun01Image().getHeight());
    }
}
