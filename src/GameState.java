/*** In The Name of Allah ***/

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * This class holds the state of game and all of its elements.
 * This class also handles user inputs, which affect the game state.
 * _
 *
 * @author Seyed Mohammad Ghaffarian
 */
public class GameState {

    public int locX, locY, diam;
    public boolean gameOver;
    public boolean win,finalWin;

    public boolean keyUP, keyDOWN, keyRIGHT, keyLEFT;
    public boolean keyEnter = false, keyC = false , keySpace = false;
    private static int speed;
    public int xTransfer = -700, yTransfer = -4700;
    public boolean mouseLeftClick = false;
    public boolean mouseLeftPress = false;
    public boolean myGun01 = true, myGun02 = false;
    public int mouseX, mouseY;
    private KeyHandler keyHandler;
    private MouseHandler mouseHandler;

    public int health = 500;
    public int numberOfHeavyBullets = 50;
    public int numberOfLightBullets = 300;
    public boolean boosted = false;
    public boolean type2 = false;

    public GameState() {
        locX = 400;
        locY = 1000;
        diam = 50;
        gameOver = false;
        win = false;
        finalWin = false;
        //
        keyUP = false;
        keyDOWN = false;
        keyRIGHT = false;
        keyLEFT = false;
        //
        speed = 8;
        //
        mouseX = 0;
        mouseY = 0;
        //
        keyHandler = new KeyHandler();
        mouseHandler = new MouseHandler();
    }

    /**
     * The method which updates the game state.
     */
    public void update() {
//        if (mousePress) {
//            locY = mouseY - diam / 2;
//            locX = mouseX - diam / 2;
//        }
        if (health < 0) {
            // gameOver = true;
        }
        if (keyUP) {
            locY -= speed;
            // yTransfer += 8;
            if (locY <= GameFrame.GAME_HEIGHT / 3 && yTransfer < 0) {
                yTransfer += speed;
                locY += speed;
            }
        }
        if (keyDOWN) {
            locY += speed;
            //  yTransfer -= 8;
            if (locY > GameFrame.GAME_HEIGHT / 1.5 && yTransfer > -4900) {
                yTransfer -= speed;
                locY -= speed;
            }
        }
        if (keyLEFT) {
            locX -= speed;
            //xTransfer += 8;
            if (locX <= GameFrame.GAME_WIDTH / 3 && xTransfer < 300) {
                xTransfer += speed;
                locX += speed;
            }
        }
        if (keyRIGHT) {
            locX += speed;
            //  xTransfer -= 8;
            if (locX > GameFrame.GAME_WIDTH / 1.5 && xTransfer > -600) {
                xTransfer -= speed;
                locX -= speed;
            }
        }
        if (keyUP || keyDOWN || keyLEFT || keyRIGHT) {
//            Sound sound1 = new Sound("./Sounds/motor1.wav" , 0);
//            sound1.doInBackground();
        }
        ShapesIntersects shapesIntersects = new ShapesIntersects();
        for (Enemy01 e1 : GameFrame.getEnemyController().getE1())
            if (shapesIntersects.checkIntersect(locX - GameFrame.getMyTankImage().getWidth() / 2 + 5, locY - GameFrame.getMyTankImage().getHeight() / 2 + 5, GameFrame.getMyTankImage().getWidth() - 10, GameFrame.getMyTankImage().getHeight() - 10
                    , e1.getLocX() + xTransfer - e1.getSmallEnemyBodyImage().getWidth() / 2, e1.getLocY() + yTransfer - e1.getSmallEnemyBodyImage().getHeight() / 2, e1.getSmallEnemyBodyImage().getWidth(), e1.getSmallEnemyBodyImage().getHeight())) {
                if (keyUP)
                    locY += speed;
                if (keyDOWN)
                    locY -= speed;
                if (keyLEFT)
                    locX += speed;
                if (keyRIGHT)
                    locX -= speed;
            }
        for (Enemy03 e3 : GameFrame.getEnemyController().getE3())
            if (shapesIntersects.checkIntersect(locX - GameFrame.getMyTankImage().getWidth() / 2 + 5, locY - GameFrame.getMyTankImage().getHeight() / 2 + 5, GameFrame.getMyTankImage().getWidth() - 10, GameFrame.getMyTankImage().getHeight() - 10
                    , e3.getLocX() + xTransfer - e3.getBigEnemyBodyImage().getWidth() / 2, e3.getLocY() + yTransfer - e3.getBigEnemyBodyImage().getHeight() / 2, e3.getBigEnemyBodyImage().getWidth(), e3.getBigEnemyBodyImage().getHeight())) {
                if (keyUP)
                    locY += speed;
                if (keyDOWN)
                    locY -= speed;
                if (keyLEFT)
                    locX += speed;
                if (keyRIGHT)
                    locX -= speed;
            }
        for (HardWall hW : GameFrame.getWallController().getHardWalls())
            if (shapesIntersects.checkIntersect(locX - GameFrame.getMyTankImage().getWidth() / 2 + 7, locY - GameFrame.getMyTankImage().getHeight() / 2 + 7, GameFrame.getMyTankImage().getWidth() - 15, GameFrame.getMyTankImage().getHeight() - 15
                    , hW.getLocX() + xTransfer, hW.getLocY() + yTransfer, hW.getHardWallImage().getWidth(), hW.getHardWallImage().getHeight())) {

                if (keyUP)
                    locY += speed;
                if (keyDOWN)
                    locY -= speed;
                if (keyLEFT)
                    locX += speed;
                if (keyRIGHT)
                    locX -= speed;
            }
        for (SoftWall sW : GameFrame.getWallController().getSoftWalls())
            if (shapesIntersects.checkIntersect(locX - GameFrame.getMyTankImage().getWidth() / 2 +7, locY - GameFrame.getMyTankImage().getHeight() / 2 + 7, GameFrame.getMyTankImage().getWidth() - 15, GameFrame.getMyTankImage().getHeight() - 15
                    , sW.getLocX() + xTransfer, sW.getLocY() + yTransfer, sW.getSoftWall01Image().getWidth(), sW.getSoftWall01Image().getHeight())) {

                if (keyUP)
                    locY += speed;
                if (keyDOWN)
                    locY -= speed;
                if (keyLEFT)
                    locX += speed;
                if (keyRIGHT)
                    locX -= speed;
            }
        for (Teazel teazel : GameFrame.getWallController().getTeazels())
            if (shapesIntersects.checkIntersect(locX - GameFrame.getMyTankImage().getWidth() / 2 + 5, locY - GameFrame.getMyTankImage().getHeight() / 2 + 5, GameFrame.getMyTankImage().getWidth() - 10, GameFrame.getMyTankImage().getHeight() - 10
                    , teazel.getLocX() + xTransfer, teazel.getLocY() + yTransfer, teazel.getTeazelImage().getWidth(), teazel.getTeazelImage().getHeight())) {
                if (keyUP)
                    locY += speed;
                if (keyDOWN)
                    locY -= speed;
                if (keyLEFT)
                    locX += speed;
                if (keyRIGHT)
                    locX -= speed;
            }
        int count = 0;
        for (FinishLine finishLine : GameFrame.getWallController().getFinishLines())
            if (shapesIntersects.checkIntersect(locX - GameFrame.getMyTankImage().getWidth() / 2 + 5, locY - GameFrame.getMyTankImage().getHeight() / 2 + 5, GameFrame.getMyTankImage().getWidth() - 10, GameFrame.getMyTankImage().getHeight() - 10
                    , finishLine.getLocX() + xTransfer, finishLine.getLocY() + yTransfer, finishLine.getFinishLineImage().getWidth(), finishLine.getFinishLineImage().getHeight())) {
                count++;
                if (count == 2)
                    win = true;
            }

        locX = Math.max(locX, 0);
        locX = Math.min(locX, GameFrame.GAME_WIDTH - diam);
        locY = Math.max(locY, 0);
        locY = Math.min(locY, GameFrame.GAME_HEIGHT - diam);

//        System.out.println("loc x = "+ locX);
//        System.out.println("loc y = "+ locY);


    }


    public KeyListener getKeyListener() {
        return keyHandler;
    }

    public MouseListener getMouseListener() {
        return mouseHandler;
    }

    public MouseMotionListener getMouseMotionListener() {
        return mouseHandler;
    }


    /**
     * The keyboard handler.
     */
    class KeyHandler extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    keyUP = true;
                    break;
                case KeyEvent.VK_W:
                    keyUP = true;
                    break;
                case KeyEvent.VK_DOWN:
                    keyDOWN = true;
                    break;
                case KeyEvent.VK_S:
                    keyDOWN = true;
                    break;
                case KeyEvent.VK_LEFT:
                    keyLEFT = true;
                    break;
                case KeyEvent.VK_A:
                    keyLEFT = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    keyRIGHT = true;
                    break;
                case KeyEvent.VK_D:
                    keyRIGHT = true;
                    break;
                case KeyEvent.VK_ESCAPE:
                    gameOver = true;
                    break;
                case KeyEvent.VK_ENTER:
                    keyEnter = true;
                    break;

                case KeyEvent.VK_C:
                    keyC = true;
                    break;

                case KeyEvent.VK_SPACE: {
                    if(keySpace == true)
                        keySpace = false;
                    else
                    keySpace = true;
                    break;
                }

            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    keyUP = false;
                    break;
                case KeyEvent.VK_W:
                    keyUP = false;
                    break;
                case KeyEvent.VK_DOWN:
                    keyDOWN = false;
                    break;
                case KeyEvent.VK_S:
                    keyDOWN = false;
                    break;
                case KeyEvent.VK_LEFT:
                    keyLEFT = false;
                    break;
                case KeyEvent.VK_A:
                    keyLEFT = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    keyRIGHT = false;
                    break;
                case KeyEvent.VK_D:
                    keyRIGHT = false;
                    break;
                case KeyEvent.VK_ENTER:
                    keyEnter = false;
                    break;
//                case KeyEvent.VK_C:
//                    keyC = false;
//                    break;
//                case KeyEvent.VK_SPACE:
//                    keySpace = false;
//                    break;
            }
        }

//        @Override
//        public void keyTyped(KeyEvent e) {
//         //   System.out.println("hi");
//            switch (e.getKeyCode()) {
//                case KeyEvent.VK_ENTER: {
//                    System.out.println("hi");
//                    keyEnter = true;
//                    break;
//
//                }
//                case KeyEvent.VK_A: {
//                    System.out.println("hi");
//                    keyEnter = true;
//                    break;
//                }
//                    case KeyEvent.VK_C: {
//                        //  System.out.println("hi");
//                        keyC = true;
//                        break;
//                    }
//
//                }
//        }
    }

        /**
         * The mouse handler.
         */
        class MouseHandler extends MouseAdapter {

        /*  @Override
          public void mousePressed(MouseEvent e) {
              mouseX = e.getX();
              mouseY = e.getY();
              mousePress = true;
          }
  */

            @Override
            public void mousePressed(MouseEvent e) {
//            super.mousePressed(e);
//           //System.out.println(e.getPoint());
                if (e.getButton() == MouseEvent.BUTTON1) {
//                //   System.out.println("left");
                    mouseLeftPress = true;
//                mouseX = e.getX();
////                if(myGun02) {
////                    GameFrame.getBulletController().addBullet(new Bullet(locX + 15, locY + 19, GameFrame.getAngle()
////                            , GameFrame.getMyTankGun01Image(), myGun01, myGun02));
////
////                }
//                System.out.println(mouseLeftPress);
//
//
//                if (myGun01)
//                    numberOfHeavyBullets--;
//                if (myGun02)
//                    numberOfLightBullets--;
                }
                mouseLeftPress = false;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
//            if(e.isMetaDown())
//            {
//                System.out.println("Left Click");
//                mouseRightClick = true;
//            }
//            if(e.isPopupTrigger())
//            {
//                System.out.println("Right Click");
//            }
                if (e.getButton() == MouseEvent.BUTTON1) {
                    //   System.out.println("left");
                    mouseLeftClick = true;
                    mouseX = e.getX();
//                if(myGun02) {
//                    GameFrame.getBulletController().addBullet(new Bullet(locX + 15, locY + 19, GameFrame.getAngle()
//                            , GameFrame.getMyTankGun01Image(), myGun01, myGun02));
//
//                }
                    if (myGun01) {
                        if (numberOfHeavyBullets > 0) {
                            Sound sound = new Sound("./Sounds/cannon.wav", 0);
                            sound.doInBackground();
                            GameFrame.getBulletController().addBullet(new Bullet(locX, locY, GameFrame.getAngle(), myGun01, myGun02));
                            numberOfHeavyBullets--;
                        } else {
                            Sound sound = new Sound("./Sounds/emptyGun.wav", 0);
                            sound.doInBackground();
                        }
                    }
                    if (myGun02) {
                        if (numberOfLightBullets > 0) {
                            Sound sound = new Sound("./Sounds/mashingun.wav", 0);
                            sound.doInBackground();
                            GameFrame.getBulletController().addBullet(new Bullet(locX, locY, GameFrame.getAngle(), myGun01, myGun02));
                            numberOfLightBullets--;
                        } else {
                            Sound sound = new Sound("./Sounds/emptyGun.wav", 0);
                            sound.doInBackground();
                        }
                    }
                }

//            if(me.getButton() == MouseEvent.BUTTON2) {
//                label.setText("Middle Click!");
//            }
                if (e.getButton() == MouseEvent.BUTTON3) {
                    //System.out.println("Right");
                    if (myGun01) {
                        myGun01 = false;
                        myGun02 = true;
                    } else {
                        myGun01 = true;
                        myGun02 = false;
                    }
                }
                if (e.getButton() == MouseEvent.BUTTON2) {

                    System.out.println("vasat");
                    if(!type2)
                        type2 = true;
                    else if(type2)
                        type2 = false;
                }
            }

            @Override
            public void mouseDragged(MouseEvent e) {
//            mouseX = e.getX();
//            mouseY = e.getY();
            }

            public void mouseMoved(MouseEvent me) {
                mouseX = (int) me.getPoint().getX();
                mouseY = (int) me.getPoint().getY();
//            if(mouseX - locX > 400) {
//
//                xTransfer -= 8;
//                locX -= 8;
//            }
//            if(mouseX - locX < -400)
//                xTransfer += 8;
//            locX + = 8;
            }
        }

    public static int getSpeed() {
        return speed;
    }

    public static void setSpeed(int speed) {
        GameState.speed = speed;
    }
}



