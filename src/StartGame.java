import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 *
 */
public class StartGame {

    private BufferedImage startUp;
    private BufferedImage startup2;
    private BufferedImage startupStar;
    private BufferedImage stage1;

    //  private KeyHandler keyHandler;
    public boolean easy, normal, hard;
    public boolean mapEditor;
    private boolean startUpBool = true;
    private boolean startUp2Bool = false;
    private boolean stage1Bool = false;

    private Sound sound;
    private int count = 0;



    public StartGame() {

        easy = true;
        normal = false;
        hard = false;
        mapEditor = false;

        sound   = new Sound("./Sounds/startup.wav", 100);
        sound.doInBackground();


        try {
            startUp = ImageIO.read(new File("./images/Startup.png"));
            startup2 = ImageIO.read(new File("./images/Startup2.png"));
            startupStar = ImageIO.read(new File("./images/StartupStar.png"));
            stage1 = ImageIO.read(new File("./images/Stage1.png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("I can't find startup class images ");
        }
    }

    public void StepsToStart(Graphics2D g, GameState state) {
        g.fillRect(0, 0, 2000, 2000);
        g.drawImage(startUp, 300, 100, null);
        if(startUpBool) {
            if(state.keyEnter) {
                Sound sound1 = new Sound("./Sounds/select.wav" , 0);
                sound1.doInBackground();
                startUpBool = false;
                sound.cancel();
                startUp2Bool = true;

            }
            if (state.keyDOWN) {
                if (easy) {
                    easy = false;
                    normal = true;
                } else if (normal) {
                    normal = false;
                    hard = true;
                } else if (hard) {
                    hard = false;
                    mapEditor = true;
                }else if(mapEditor)
                    {
                        mapEditor = false;
                        easy = true;
                    }
                }

            if (state.keyUP) {
                if (easy) {
                    easy = false;
                    mapEditor = true;
                } else if (normal) {
                    normal = false;
                    easy = true;
                } else if (hard) {
                    hard = false;
                    normal = true;
                }
                else if(mapEditor)
                {
                    mapEditor = false;
                    hard = true;
                }
            }
            if (easy) {
                g.drawImage(startupStar, 490, 490, null);
            } else if (normal) {
                g.drawImage(startupStar, 490, 550, null);
            } else if (hard) {
                g.drawImage(startupStar, 490, 605, null);
            }
            else if (mapEditor) {
                g.drawImage(startupStar, 490, 665, null);
            }
        }
        if(!startUpBool && mapEditor)
        {
           // System.out.println("hahaha");
        MapEditor mapEditor = new MapEditor();
        easy = true;
        }

        if(startUp2Bool)
        {
            g.fillRect(0, 0, 2000, 2000);
            g.drawImage(startup2, 300, 100, null);
            if(state.keyEnter)
            {
                startUp2Bool = false;
                stage1Bool = true;
            }
        }
        if (stage1Bool)
        {
            g.fillRect(0, 0, 2000, 2000);
            g.drawImage(stage1, 300, 100, null);
            if(MapEditor.isDone())
            GameFrame.setStart(true);
        }

    }
}
