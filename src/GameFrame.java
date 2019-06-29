/*** In The Name of Allah ***/

import javafx.scene.transform.Transform;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.lang.model.type.IntersectionType;
import javax.swing.*;

/**
 * The window on which the rendering is performed.
 * This example uses the modern BufferStrategy approach for double-buffering,
 * actually it performs triple-buffering!
 * For more information on BufferStrategy check out:
 * http://docs.oracle.com/javase/tutorial/extra/fullscreen/bufferstrategy.html
 * http://docs.oracle.com/javase/8/docs/api/java/awt/image/BufferStrategy.html
 *
 * @author Seyed Mohammad Ghaffarian
 */
public class GameFrame extends JFrame {

    public static final int GAME_HEIGHT = 1100;                  // 720p game resolution
    public static final int GAME_WIDTH = 16 * GAME_HEIGHT / 9;  // wide aspect ratio

    private int VIEWPORT_SIZE_X = GAME_WIDTH / 2;
    private int VIEWPORT_SIZE_Y = GAME_HEIGHT / 2;
    private int offsetMaxX, offsetMaxY, offsetMinX, offsetMinY;
    private int camX, camY;
    private static boolean start = false;

    //uncomment all /*...*/ in the class for using Tank icon instead of a simple circle
    /*private BufferedImage image;*/

    private long lastRender;
    private ArrayList<Float> fpsHistory;

    private BufferStrategy bufferStrategy;


    private static BufferedImage myTankImage;
    private static BufferedImage myTank2Image;
    private static BufferedImage myTankGun01Image;
    private static BufferedImage myTankGun02Image;
    private static BufferedImage test;
    private static BufferedImage hardWall;
    private static BufferedImage soil;
    private static BufferedImage boostedTankGun01Image;
    private static BufferedImage startUp;


    private static StartGame startGame;
    private static BulletController bulletController;
    private static EnemyController enemyController;
    private static WallController wallController;
    private static FoodsController foodsController;
    private MultiPlayer multiPlayer;
    private MyTankRotation myTankRotation;
    private DrawHealth drawHealth;
    private DrawNumberOfBullets drawNumberOfBullets;
    private CheatCode cheatCode;
    private static double angle;
    private double tankAngle = 0;
    private boolean addMap = false;
    private int playSound = 0;
    private Sound gameSound;
    private Map map;
    private MultiPlayerInformation multiPlayerInformation;

    public GameFrame(String title) {
        super(title);
        setResizable(false);
        setSize(GAME_WIDTH, GAME_HEIGHT);
        lastRender = -1;
        fpsHistory = new ArrayList<>(100);


        try {
            myTankImage = ImageIO.read(new File("./images/myTank.png"));
            myTank2Image = ImageIO.read(new File("./images/myTank2.png"));
            myTankGun01Image = ImageIO.read(new File("./images/tankGun01.png"));
            myTankGun02Image = ImageIO.read(new File("./images/tankGun02.png"));
            hardWall = ImageIO.read(new File("./images/hardWall.png"));
            soil = ImageIO.read(new File("./images/soil2.jpg"));
            test = ImageIO.read(new File("./images/test.png"));
            boostedTankGun01Image = ImageIO.read(new File("./images/boostedTankGun01.png"));
            startUp = ImageIO.read(new File("./images/Startup.png"));


//            myHeavyBullet = ImageIO.read(new File("./images/HeavyBullet.png"));


        } catch (IOException e) {
           // System.out.println("bitch");
            System.out.println("there is not image with this adress");
            System.out.println(e);
        }
        startGame = new StartGame();
        bulletController = new BulletController();
        enemyController = new EnemyController();
        wallController = new WallController();
        foodsController = new FoodsController();
        myTankRotation = new MyTankRotation();
        drawHealth = new DrawHealth();
        drawNumberOfBullets = new  DrawNumberOfBullets();
        cheatCode = new CheatCode();
        map = new Map();
        multiPlayer = new MultiPlayer();
        multiPlayer.startConnection();
        if(multiPlayer.isServer())
        {
            FramesInformation.setServer(true);
        }
        else {
            FramesInformation.setServer(false);
        }
       // multiPlayerInformation = new MultiPlayerInformation();



        gameSound =  new Sound("./Sounds/gameSound1.wav", 500);
    }

    /**
     * This must be called once after the JFrame is shown:
     * frame.setVisible(true);
     * and before any rendering is started.
     */
    public void initBufferStrategy() {
        // Triple-buffering
        createBufferStrategy(3);
        bufferStrategy = getBufferStrategy();
    }


    /**
     * Game rendering with triple-buffering using BufferStrategy.
     */
    public void render(GameState state) {
        // Render single frame
        do {
            // The following loop ensures that the contents of the drawing buffer
            // are consistent in case the underlying surface was recreated
            do {
                // Get a new graphics context every time through the loop
                // to make sure the strategy is validated
                Graphics2D graphics = (Graphics2D) bufferStrategy.getDrawGraphics();
                try {
                    doRendering(graphics, state);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    // Dispose the graphics
                    graphics.dispose();
                }
                // Repeat the rendering if the drawing buffer contents were restored
            } while (bufferStrategy.contentsRestored());

            // Display the buffer
            bufferStrategy.show();
            // Tell the system to do the drawing NOW;
            // otherwise it can take a few extra ms and will feel jerky!
            Toolkit.getDefaultToolkit().sync();

            // Repeat the rendering if the drawing buffer was lost
        } while (bufferStrategy.contentsLost());
    }

    /**
     * Rendering all game elements based on the game state.
     */
    private void doRendering(Graphics2D g2d, GameState state) throws IOException {


        if(!start)
        {
            startGame.StepsToStart(g2d,state);
        }

        if (start) {
            if(playSound == 0)
            {
                gameSound.doInBackground();
                playSound++;
            }
            if(state.keyC) {
               // System.out.println("hi");
                cheatCode.showPanel(state);
            }
            // Draw background
//        offsetMaxX = GAME_WIDTH - VIEWPORT_SIZE_X;
//        offsetMaxY = GAME_HEIGHT - VIEWPORT_SIZE_Y;
//        offsetMinX = 0;
//        offsetMinY = 0;
//
//        camX = state.locX - VIEWPORT_SIZE_X / 2;
//        camY = state.locY - VIEWPORT_SIZE_Y / 2;
//
//
//        if (camX > offsetMaxX)
//            camX = offsetMaxX;
//        else if (camX < offsetMinX)
//            camX = offsetMinX;
//        if (camY > offsetMaxY)
//            camY = offsetMaxY;
//        else if (camY < offsetMinY)
//            camY = offsetMinY;
            //  g2d.translate(-camX, -camY);
            // g2d.setColor(new Color(178,114,59));


            g2d.setColor(Color.black);
            g2d.fillRect(0, 0, 10000, 10000);
            // g2d.drawImage(soil, 0, 0, null);
//        System.out.println("x = " + state.mouseX);
//        System.out.println("y = " + state.mouseY);
            if (!addMap) {
//               System.out.println("easy = " + startGame.easy);
//                System.out.println("normal = " + startGame.normal);
//                System.out.println("hard = " + startGame.hard);
                map.readAndAddMap(startGame.easy,startGame.normal,startGame.hard);
                addMap = true;
                System.out.println("MapAdded");
                Toolkit toolkit = Toolkit.getDefaultToolkit();
               // toolkit.getBestCursorSize(30, 30);
                setCursor(toolkit.createCustomCursor(
                        new ImageIcon("./images/shootingTarget4.png").getImage(),
                        new Point(0,0),"custom cursor"));
            }
            /**
             * multiplaye
             */
           // System.out.println(FramesInformation.isServer());

//            multiPlayerInformation.update(state);
//            multiPlayer.sendInformation(state.locX);

            /**
             * draw Walls
             */
            wallController.render(g2d, state);

            /**
             * draw Foods
             */
            foodsController.render(g2d, state);

            /**
             * draw my tank
             */
            AffineTransform myTankTx = new AffineTransform();
            myTankTx.setToTranslation(state.locX - myTankImage.getWidth() / 2, state.locY - myTankImage.getHeight() / 2);


            tankAngle = myTankRotation.getAngle(state);
            myTankTx.rotate(Math.toRadians(myTankRotation.getAngle(state)), 50, 50);

            if(!state.type2)
                g2d.drawImage(myTankImage, myTankTx, null);
            if(state.type2)
                g2d.drawImage(myTank2Image, myTankTx, null);



            /**
             * draw my Guns
             */
            AffineTransform tx = new AffineTransform();
            tx.setToTranslation(state.locX - myTankGun01Image.getWidth() / 5, state.locY - myTankGun01Image.getHeight() / 4.2);
            angle = Math.toDegrees(Math.atan2(state.mouseY - state.locY, state.mouseX - state.locX));
            tx.rotate(Math.toRadians(angle), 30, 30);
//        System.out.println("mouse x = " + state.mouseX);
//        System.out.println("mouse y = " + state.mouseY);

            /**
             * change gun when press right click
             */
            if (state.myGun02) {
                g2d.drawImage(myTankGun02Image, tx, null);
                if (state.boosted) {

                }
            } else if (state.myGun01) {
                if (state.boosted) {
                    g2d.drawImage(boostedTankGun01Image, tx, null);
                }
                g2d.drawImage(myTankGun01Image, tx, null);
            }
            if (state.mouseLeftClick) {
                //bulletController.addBullet(new Bullet(state.locX,state.locY,Math.toDegrees(Math.atan2(state.mouseY - state.locY + 15 , state.mouseX - state.locX+19))));
            }

            /**
             * draw Bullets
             */
            bulletController.setState(state);
            bulletController.move();
            bulletController.render(g2d, state);
            bulletController.checkStrik();

            /**
             * take graffic and game state to ShapesIntersects for check Intersect shapes
             */
            ShapesIntersects shapesIntersects = new ShapesIntersects();
            shapesIntersects.setGraphic(g2d, state);

            enemyController.render(g2d, state);

            /**
             * draw plants
             */
                wallController.renderPlants(g2d,state );

      /*  String numberOfbullets = "heavy = " + state.numberOfHeavyBullets + "\n" + "Light = " + state.numberOfLightBullets;
        g2d.setColor(Color.CYAN);
        g2d.setFont(g2d.getFont().deriveFont(18.0f));
        int strWidth1 = g2d.getFontMetrics().stringWidth(numberOfbullets);
        int strHeight1 = g2d.getFontMetrics().getHeight();
        g2d.drawString(numberOfbullets, (GAME_WIDTH - strWidth1) / 2, strHeight1 + 50);

        String health = "health = " + state.health;
        g2d.setColor(Color.red);
        g2d.setFont(g2d.getFont().deriveFont(18.0f));
        int strWidth2 = g2d.getFontMetrics().stringWidth(numberOfbullets);
        int strHeight2 = g2d.getFontMetrics().getHeight();
        g2d.drawString(health, (GAME_WIDTH - strWidth2), strHeight2 + 50);*/

            /**
             * draw number of bullets
             */
            drawNumberOfBullets.render(g2d, state);
            /**
             * Draw Health
             */
            drawHealth.render(g2d, state);

            // Print FPS info
    /*    long currentRender = System.currentTimeMillis();
        if (lastRender > 0) {
            fpsHistory.add(1000.0f / (currentRender - lastRender));
            if (fpsHistory.size() > 100) {
                fpsHistory.remove(0); // remove oldest
            }
            float avg = 0.0f;
            for (float fps : fpsHistory) {
                avg += fps;
            }
            avg /= fpsHistory.size();
            String str = String.format("Average FPS = %.1f , Last Interval = %d ms",
                    avg, (currentRender - lastRender));
            g2d.setColor(Color.CYAN);
            g2d.setFont(g2d.getFont().deriveFont(18.0f));
            int strWidth = g2d.getFontMetrics().stringWidth(str);
            int strHeight = g2d.getFontMetrics().getHeight();
            g2d.drawString(str, (GAME_WIDTH - strWidth) / 2, strHeight + 50);
        }
        lastRender = currentRender;
        // Print user guide
        String userGuide
                = "Use the MOUSE or ARROW KEYS to move the BALL. "
                + "Press ESCAPE to end the game.";
        g2d.setFont(g2d.getFont().deriveFont(18.0f));
        g2d.drawString(userGuide, 10, GAME_HEIGHT - 10);*/
            // Draw GAME OVER

            g2d.setColor(Color.black);
            g2d.fillRect(0, -5000, 300, 10000);
            g2d.fillRect(GameFrame.GAME_WIDTH - 300, -5000, 300, 10000);


            if (state.gameOver) {
                String str = "GAME OVER";
                g2d.setColor(Color.WHITE);
                g2d.setFont(g2d.getFont().deriveFont(Font.BOLD).deriveFont(64.0f));
                int strWidth = g2d.getFontMetrics().stringWidth(str);
                g2d.drawString(str, (GAME_WIDTH - strWidth) / 2, GAME_HEIGHT / 2);
                gameSound.cancel();
                Sound sound1 = new Sound("./Sounds/gameOver.wav" , 0);
                sound1.doInBackground();
            }
            if (state.win) {
              for(int i = 0 ; i < 10 ; i++)
              {
                  RemoveAllObjetcs removeAllObjetcs = new RemoveAllObjetcs();
              }

              if(!Map.isStage3())
              {

                    state.locX = 400;
                    state.locY = 1000;
                    state.xTransfer = -700;
                    state.yTransfer = -4700;
                    state.health = 500;
                    state.numberOfLightBullets = 300;
                    state.numberOfHeavyBullets = 50;
                    state.boosted = false;
                    state.setSpeed(8);
                    if(Map.isStage2()) {
                        Map.setStage2(false);
                        Map.setStage3(true);
                    }
                    if(Map.isStage1()) {
                      //  System.out.println("hiiiiiiiiiiiiiiiiiiiiii");
                        Map.setStage1(false);
                        Map.setStage2(true);
                    }

                    addMap = false;
                    state.win = false;
                }
                else {
                  String str = "Well Done ;)";
                g2d.setColor(Color.WHITE);
                g2d.setFont(g2d.getFont().deriveFont(Font.BOLD).deriveFont(64.0f));
                int strWidth = g2d.getFontMetrics().stringWidth(str);
                g2d.drawString(str, (GAME_WIDTH - strWidth) / 2, GAME_HEIGHT / 2);
                state.finalWin = true;

              }
            }
        }
    }

    public static BulletController getBulletController() {
        return bulletController;
    }

    public static EnemyController getEnemyController() {
        return enemyController;
    }

    public static WallController getWallController() {
        return wallController;
    }

    public static FoodsController getFoodsController() {
        return foodsController;
    }

    public static BufferedImage getMyTankGun01Image() {
        return myTankGun01Image;
    }

    public static BufferedImage getMyTankImage() {
        return myTankImage;
    }

    public static double getAngle() {
        return angle;
    }

    public static BufferedImage getTest() {
        return test;
    }

    public static void setStart(boolean start) {
        GameFrame.start = start;
    }

    public static boolean isStart() {

        return start;
    }

    public static StartGame getStartGame() {
        return startGame;
    }
}
