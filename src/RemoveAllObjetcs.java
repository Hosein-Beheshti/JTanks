/**
 * remove all object in map
 */
public class RemoveAllObjetcs {

    private HardWall tempHardWall;
    private SoftWall tempSoftWall;
    private Soil tempSoil;
    private Teazel tempTeazel;
    private Plant tempPlant;
    private FinishLine tempFinishLine;

    private RepairFood tempRepairFood;
    private Gun01Food tempGun01Food;
    private Gun02Food tempGun02Food;
    private UpdateStar tempUpdateStar;
    private SpeedFood tempSpeedFood;

    private Enemy01 tempEnemy01;
    private Enemy02 tempEnemy02;
    private Enemy03 tempEnemy03;
    private Enemy04 tempEnemy04;

    private Bullet tempBullet;
    private Enemy01Bullet tempEnemy01Bullet;

    private boolean done = false;


    public RemoveAllObjetcs() {
        for (int i = 0; i < GameFrame.getEnemyController().getE1().size(); i++) {
            tempEnemy01 = GameFrame.getEnemyController().getE1().get(i);
            GameFrame.getEnemyController().removeEnemy(tempEnemy01);
        }
        for (int i = 0; i < GameFrame.getEnemyController().getE2().size(); i++) {
            tempEnemy02 = GameFrame.getEnemyController().getE2().get(i);
            GameFrame.getEnemyController().removeEnemy(tempEnemy02);
        }
        for (int i = 0; i < GameFrame.getEnemyController().getE3().size(); i++) {
            tempEnemy03 = GameFrame.getEnemyController().getE3().get(i);
            GameFrame.getEnemyController().removeEnemy(tempEnemy03);
        }
        for (int i = 0; i < GameFrame.getEnemyController().getE4().size(); i++) {
            tempEnemy04 = GameFrame.getEnemyController().getE4().get(i);
            GameFrame.getEnemyController().removeEnemy(tempEnemy04);
        }

        for (int i = 0; i < GameFrame.getWallController().getSoils().size(); i++) {
            tempSoil = GameFrame.getWallController().getSoils().get(i);
            GameFrame.getWallController().getSoils().remove(tempSoil);
        }
        for (int i = 0; i < GameFrame.getWallController().getHardWalls().size(); i++) {
            tempHardWall = GameFrame.getWallController().getHardWalls().get(i);
            GameFrame.getWallController().getHardWalls().remove(tempHardWall);
        }
        for (int i = 0; i < GameFrame.getWallController().getSoftWalls().size(); i++) {
            tempSoftWall = GameFrame.getWallController().getSoftWalls().get(i);
            GameFrame.getWallController().getSoftWalls().remove(tempSoftWall);
        }
        for (int i = 0; i < GameFrame.getWallController().getTeazels().size(); i++) {
            tempTeazel = GameFrame.getWallController().getTeazels().get(i);
            GameFrame.getWallController().getTeazels().remove(tempTeazel);
        }
        for (int i = 0; i < GameFrame.getWallController().getPlants().size(); i++) {
            tempPlant = GameFrame.getWallController().getPlants().get(i);
            GameFrame.getWallController().getPlants().remove(tempPlant);
        }
        for (int i = 0; i < GameFrame.getWallController().getFinishLines().size(); i++) {
            tempFinishLine = GameFrame.getWallController().getFinishLines().get(i);
            GameFrame.getWallController().getFinishLines().remove(tempFinishLine);
        }

        for (int i = 0; i < GameFrame.getFoodsController().getGun01Foods().size(); i++) {
            tempGun01Food = GameFrame.getFoodsController().getGun01Foods().get(i);
            GameFrame.getFoodsController().removeGun01Food(tempGun01Food);
        }
        for (int i = 0; i < GameFrame.getFoodsController().getGun02Foods().size(); i++) {
            tempGun02Food = GameFrame.getFoodsController().getGun02Foods().get(i);
            GameFrame.getFoodsController().removeGun02Food(tempGun02Food);
        }
        for (int i = 0; i < GameFrame.getFoodsController().getGun02Foods().size(); i++) {
            tempGun02Food = GameFrame.getFoodsController().getGun02Foods().get(i);
            GameFrame.getFoodsController().removeGun02Food(tempGun02Food);
        }
        for (int i = 0; i < GameFrame.getFoodsController().getRepairFoods().size(); i++) {
            tempRepairFood = GameFrame.getFoodsController().getRepairFoods().get(i);
            GameFrame.getFoodsController().removeRepairFood(tempRepairFood);
        }
        for (int i = 0; i < GameFrame.getFoodsController().getSpeedFoods().size(); i++) {
            tempSpeedFood = GameFrame.getFoodsController().getSpeedFoods().get(i);
            GameFrame.getFoodsController().removeSpeedFood(tempSpeedFood);
        }
        for (int i = 0; i < GameFrame.getFoodsController().getUpdateStars().size(); i++) {
            tempUpdateStar = GameFrame.getFoodsController().getUpdateStars().get(i);
            GameFrame.getFoodsController().removeUpdateStar(tempUpdateStar);
        }

        for (int i = 0; i < GameFrame.getBulletController().getEnemyBullets01List().size(); i++) {
            tempEnemy01Bullet = GameFrame.getBulletController().getEnemyBullets01List().get(i);
            GameFrame.getBulletController().removeBullet(tempEnemy01Bullet);
        }
        for (int i = 0; i < GameFrame.getBulletController().getMyBulletsList().size(); i++) {
            tempBullet = GameFrame.getBulletController().getMyBulletsList().get(i);
            GameFrame.getBulletController().removeBullet(tempBullet);
        }
        done = true;

    }

    public boolean isDone() {
        return done;
    }
}
