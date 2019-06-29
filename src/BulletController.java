import java.awt.*;
import java.util.LinkedList;

/**
 * this class controll all bullets
 * (my bullets and enemy bullets)
 *
 */
public class BulletController {

    private LinkedList<Bullet> myBulletsList = new LinkedList<>();
    private LinkedList<Enemy01Bullet> enemyBullets01List = new LinkedList<>();

    private Bullet tempBullet;
    private Enemy01Bullet tempEnemy01Bullet;

    private GameState state;

    /**
     * constructor
     */
    public BulletController() {
        // addBullet(new Bullet(100,100,180));
    }

    /**
     * call method move for all bullets
     */
    public void move() {
        for (int i = 0; i < myBulletsList.size(); i++) {
            tempBullet = myBulletsList.get(i);
            tempBullet.move();

        }
        for (int i = 0; i < enemyBullets01List.size(); i++) {
            tempEnemy01Bullet = enemyBullets01List.get(i);
            tempEnemy01Bullet.move();
        }
    }
    /**
     * check intersect bullet and if true remove bullet
     */
    public void checkStrik() {
        for (int i = 0; i < myBulletsList.size(); i++) {
            tempBullet = myBulletsList.get(i);

            ShapesIntersects shapesIntersects = new ShapesIntersects();
            for (Enemy01 e1 : GameFrame.getEnemyController().getE1()) {

                if (shapesIntersects.checkIntersect(e1.getLocX() + state.xTransfer- e1.getSmallEnemyBodyImage().getWidth() / 2, e1.getLocY() + state.yTransfer - e1.getSmallEnemyBodyImage().getHeight() / 2, e1.getSmallEnemyBodyImage().getWidth(), e1.getSmallEnemyBodyImage().getHeight()
                        , (int) tempBullet.getX(), (int) tempBullet.getY(), tempBullet.getMyHeavyBullet().getWidth(), tempBullet.getMyHeavyBullet().getHeight())) {
                    removeBullet(tempBullet);
                    if (tempBullet.isMyGun01())
                        e1.setHealth(e1.getHealth() - Bullet.getMyHeavyBulletDamage());
                    if (tempBullet.isMyGun02())
                        e1.setHealth(e1.getHealth() - Bullet.getMyLightBulletDamage());

                }
            }
            for (Enemy03 e3 : GameFrame.getEnemyController().getE3()) {

                if (shapesIntersects.checkIntersect(e3.getLocX() + state.xTransfer - e3.getBigEnemyBodyImage().getWidth() / 2, e3.getLocY() + state.yTransfer - e3.getBigEnemyBodyImage().getHeight() / 2, e3.getBigEnemyBodyImage().getWidth(), e3.getBigEnemyBodyImage().getHeight()
                        , (int) tempBullet.getX(), (int) tempBullet.getY(), tempBullet.getMyHeavyBullet().getWidth(), tempBullet.getMyHeavyBullet().getHeight())) {
                    removeBullet(tempBullet);
                    if (tempBullet.isMyGun01())
                        e3.setHealth(e3.getHealth() - Bullet.getMyHeavyBulletDamage());
                    if (tempBullet.isMyGun02())
                        e3.setHealth(e3.getHealth() - Bullet.getMyLightBulletDamage());

                }
            }
            for (Enemy02 e2 : GameFrame.getEnemyController().getE2()) {
                if (shapesIntersects.checkIntersect(e2.getLocX() + state.xTransfer - e2.getMovingEnemyImage().getWidth() / 3, e2.getLocY() + state.yTransfer- e2.getMovingEnemyImage().getHeight() / 3, e2.getMovingEnemyImage().getWidth() / 2, e2.getMovingEnemyImage().getHeight() / 2
                        , (int) tempBullet.getX(), (int) tempBullet.getY(), tempBullet.getMyHeavyBullet().getWidth(), tempBullet.getMyHeavyBullet().getHeight())) {
                    removeBullet(tempBullet);
                    if (tempBullet.isMyGun01())
                        e2.setHealth(e2.getHealth() - Bullet.getMyHeavyBulletDamage());
                    if (tempBullet.isMyGun02())
                        e2.setHealth(e2.getHealth() - Bullet.getMyLightBulletDamage());
                }
            }
            for (HardWall hW : GameFrame.getWallController().getHardWalls()) {
                if (shapesIntersects.checkIntersect(hW.getLocX()+ state.xTransfer, hW.getLocY() + state.yTransfer, hW.getHardWallImage().getWidth(), hW.getHardWallImage().getHeight()
                        , (int) tempBullet.getX(), (int) tempBullet.getY(), tempBullet.getMyHeavyBullet().getWidth(), tempBullet.getMyHeavyBullet().getHeight())) {
                    Sound sound = new Sound("./Sounds/recosh.wav" , 0);
                    sound.doInBackground();
                    removeBullet(tempBullet);
                  /*  if (tempBullet.isMyGun01())
                        e2.setHealth(e2.getHealth() - Bullet.getMyHeavyBulletDamage());
                    if (tempBullet.isMyGun02())
                        e2.setHealth(e2.getHealth() - Bullet.getMyLightBulletDamage());
                        */
                }
            }
            for (SoftWall sW : GameFrame.getWallController().getSoftWalls()) {

                if (shapesIntersects.checkIntersect(sW.getLocX() + state.xTransfer, sW.getLocY() + state.yTransfer, sW.getSoftWall01Image().getWidth(), sW.getSoftWall01Image().getHeight()
                        , (int) tempBullet.getX() , (int) tempBullet.getY(), tempBullet.getMyHeavyBullet().getWidth(), tempBullet.getMyHeavyBullet().getHeight())) {
                    Sound sound = new Sound("./Sounds/softwall.wav" , 0);
                    sound.doInBackground();
                    removeBullet(tempBullet);
                   if (tempBullet.isMyGun01())
                        sW.setHealth(sW.getHealth() - Bullet.getMyHeavyBulletDamage());
                    if (tempBullet.isMyGun02())
                        sW.setHealth(sW.getHealth() - Bullet.getMyLightBulletDamage());
                }

            }

        }
        // Strik for Enemmy01Bullets

        for (int i = 0; i < enemyBullets01List.size(); i++) {
            ShapesIntersects shapesIntersects = new ShapesIntersects();
            tempEnemy01Bullet = enemyBullets01List.get(i);
            if (shapesIntersects.checkIntersect(state.locX - GameFrame.getMyTankImage().getWidth() / 2, state.locY - GameFrame.getMyTankImage().getHeight() / 2,
                    GameFrame.getMyTankImage().getWidth(), GameFrame.getMyTankImage().getHeight()
                    , (int) tempEnemy01Bullet.getX() + state.xTransfer, (int) tempEnemy01Bullet.getY() + state.yTransfer, tempEnemy01Bullet.getEnemy01BulletImage().getWidth(), tempEnemy01Bullet.getEnemy01BulletImage().getHeight())) {
                Sound sound1 = new Sound("./Sounds/EnemyBulletToMyTank.wav" , 0);
                sound1.doInBackground();
                removeBullet(tempEnemy01Bullet);
                state.health = state.health - Enemy01Bullet.getEnemy01Bulletdamage();
            }

            for (HardWall hW : GameFrame.getWallController().getHardWalls()) {
                if (shapesIntersects.checkIntersect(hW.getLocX() + state.xTransfer, hW.getLocY() + state.yTransfer, hW.getHardWallImage().getWidth(), hW.getHardWallImage().getHeight()
                        ,(int) tempEnemy01Bullet.getX() + state.xTransfer, (int) tempEnemy01Bullet.getY() + state.yTransfer, tempEnemy01Bullet.getEnemy01BulletImage().getWidth(), tempEnemy01Bullet.getEnemy01BulletImage().getHeight())) {
                    removeBullet(tempEnemy01Bullet);
                }
            }
            for (SoftWall sW : GameFrame.getWallController().getSoftWalls()) {
                if (shapesIntersects.checkIntersect(sW.getLocX() + state.xTransfer, sW.getLocY() + state.yTransfer, sW.getSoftWall01Image().getWidth(), sW.getSoftWall01Image().getHeight()
                        ,(int) tempEnemy01Bullet.getX() + state.xTransfer, (int) tempEnemy01Bullet.getY() + state.yTransfer, tempEnemy01Bullet.getEnemy01BulletImage().getWidth(), tempEnemy01Bullet.getEnemy01BulletImage().getHeight())) {
                    removeBullet(tempEnemy01Bullet);
                }
            }

        }
    }

    /**
     * call render method for all bullets
     * @param g
     * @param state
     */
        public void render (Graphics2D g, GameState state)
        {
            for (int i = 0; i < myBulletsList.size(); i++) {
                tempBullet = myBulletsList.get(i);
                tempBullet.render(g,state);

//            if(tempBullet.getX() > 1000)
//            {
//                removeBullet(tempBullet);
//            }
            }
            for (int i = 0; i < enemyBullets01List.size(); i++) {
                tempEnemy01Bullet = enemyBullets01List.get(i);
                tempEnemy01Bullet.render(g,state);

//            if(tempBullet.getX() > 1000)
//            {
//                removeBullet(tempBullet);
//            }
            }
        }

    /**
     * getters and setters
     *
     */
    public void addBullet (Bullet bullet)
        {
            myBulletsList.add(bullet);
        }
        public void addBullet (Enemy01Bullet enemy01Bullet)
        {
            enemyBullets01List.add(enemy01Bullet);
        }
        public void removeBullet (Bullet bullet)
        {
            myBulletsList.remove(bullet);
        }
        public void removeBullet (Enemy01Bullet enemy01Bullet)
        {
            enemyBullets01List.remove(enemy01Bullet);
        }

        public void setState (GameState state){
            this.state = state;
        }

    public LinkedList<Bullet> getMyBulletsList() {
        return myBulletsList;
    }

    public LinkedList<Enemy01Bullet> getEnemyBullets01List() {
        return enemyBullets01List;
    }
}
