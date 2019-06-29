import java.awt.*;
import java.util.LinkedList;
/**
 * this class controll all the Foods
 * this add and remove its to linkedlist
 * and call render method to draw its
 * and check intersects
 */
public class FoodsController {

    private LinkedList<RepairFood> repairFoods = new LinkedList<>();
    private LinkedList<Gun01Food> gun01Foods = new LinkedList<>();
    private LinkedList<Gun02Food> gun02Foods = new LinkedList<>();
    private LinkedList<UpdateStar> updateStars = new LinkedList<>();
    private LinkedList<SpeedFood> speedFoods = new LinkedList<>();


    private RepairFood tempRepairFood;
    private Gun01Food tempGun01Food;
    private Gun02Food tempGun02Food;
    private UpdateStar tempUpdateStar;
    private SpeedFood tempSpeedFood;



    public FoodsController() {
//        addRepairFood(new RepairFood(400, 500));
//
//        addGun01Food(new Gun01Food(700,50));
//
//        addGun02Food(new Gun02Food(700,400));
//
//        addUpdateStar(new UpdateStar(700,600));
    }

    public void render(Graphics2D g, GameState state) {
        checkForRemove(state);
        for (int i = 0; i < repairFoods.size(); i++) {
            tempRepairFood = repairFoods.get(i);
            tempRepairFood.render(g,state);
        }
        for (int i = 0; i < gun01Foods.size(); i++) {
            tempGun01Food = gun01Foods.get(i);
            tempGun01Food.render(g,state);
        }
        for (int i = 0; i < gun02Foods.size(); i++) {
            tempGun02Food = gun02Foods.get(i);
            tempGun02Food.render(g,state);
        }
        for (int i = 0; i < updateStars.size(); i++) {
            tempUpdateStar = updateStars.get(i);
            tempUpdateStar.render(g,state);
        }
        for (int i = 0; i < speedFoods.size(); i++) {
            tempSpeedFood = speedFoods.get(i);
            tempSpeedFood.render(g,state);
        }
    }

    public void checkForRemove(GameState state) {
        for (int i = 0; i < repairFoods.size(); i++) {
            tempRepairFood = repairFoods.get(i);
            ShapesIntersects shapesIntersects = new ShapesIntersects();
            if (shapesIntersects.checkIntersect(state.locX - GameFrame.getMyTankImage().getWidth() / 2, state.locY - GameFrame.getMyTankImage().getHeight() / 2, GameFrame.getMyTankImage().getWidth(), GameFrame.getMyTankImage().getHeight()
                    , tempRepairFood.getLocX() + state.xTransfer + tempRepairFood.getRepairFoodImage().getWidth() / 3, tempRepairFood.getLocY() + state.yTransfer + tempRepairFood.getRepairFoodImage().getHeight() / 3, tempRepairFood.getRepairFoodImage().getWidth() / 2, tempRepairFood.getRepairFoodImage().getHeight() / 2)) {
                if(state.health < 500) {
                    state.health = 500;
                    Sound sound1 = new Sound("./Sounds/repair.wav" , 0);
                    sound1.doInBackground();
                    removeRepairFood(tempRepairFood);
                }
            }
        }
        for (int i = 0; i < gun01Foods.size(); i++) {
            tempGun01Food = gun01Foods.get(i);
            ShapesIntersects shapesIntersects = new ShapesIntersects();
            if (shapesIntersects.checkIntersect(state.locX - GameFrame.getMyTankImage().getWidth() / 2, state.locY - GameFrame.getMyTankImage().getHeight() / 2, GameFrame.getMyTankImage().getWidth(), GameFrame.getMyTankImage().getHeight()
                    , tempGun01Food.getLocX() + state.xTransfer  + tempGun01Food.getGun01FoodImage().getWidth() / 3, tempGun01Food.getLocY() + state.yTransfer + tempGun01Food.getGun01FoodImage().getHeight() / 3, tempGun01Food.getGun01FoodImage().getWidth() / 2, tempGun01Food.getGun01FoodImage().getHeight() / 2)) {
                state.numberOfHeavyBullets = state.numberOfHeavyBullets + Gun01Food.getNumberOfBullets();
                removeGun01Food(tempGun01Food);
            }
        }
        for (int i = 0; i < gun02Foods.size(); i++) {
            tempGun02Food = gun02Foods.get(i);
            ShapesIntersects shapesIntersects = new ShapesIntersects();
            if (shapesIntersects.checkIntersect(state.locX - GameFrame.getMyTankImage().getWidth() / 2, state.locY - GameFrame.getMyTankImage().getHeight() / 2, GameFrame.getMyTankImage().getWidth(), GameFrame.getMyTankImage().getHeight()
                    , tempGun02Food.getLocX() + state.xTransfer + tempGun02Food.getGun02FoodImage().getWidth() / 3, tempGun02Food.getLocY() + state.yTransfer + tempGun02Food.getGun02FoodImage().getHeight() / 3, tempGun02Food.getGun02FoodImage().getWidth() / 2, tempGun02Food.getGun02FoodImage().getHeight() / 2)) {
                state.numberOfLightBullets = state.numberOfLightBullets + Gun02Food.getNumberOfBullets();
                removeGun02Food(tempGun02Food);
            }
        }
        for (int i = 0; i < updateStars.size(); i++) {
            tempUpdateStar = updateStars.get(i);
            ShapesIntersects shapesIntersects = new ShapesIntersects();
            if (shapesIntersects.checkIntersect(state.locX - GameFrame.getMyTankImage().getWidth() / 2, state.locY - GameFrame.getMyTankImage().getHeight() / 2, GameFrame.getMyTankImage().getWidth(), GameFrame.getMyTankImage().getHeight()
                    , tempUpdateStar.getLocX() + state.xTransfer  + tempUpdateStar.getUpdateStarImage().getWidth() / 3, tempUpdateStar.getLocY() + + state.yTransfer+ tempUpdateStar.getUpdateStarImage().getHeight() / 3, tempUpdateStar.getUpdateStarImage().getWidth() / 2, tempUpdateStar.getUpdateStarImage().getHeight() / 2)) {
                state.boosted = true;

                if(state.myGun01)
                {
                    Bullet.setHeavyBulletSpeed(Bullet.getHeavyBulletSpeed() * 2);
                   // Bullet.setMyHeavyBulletDamage(Bullet.getMyHeavyBulletDamage() * 2);
                }
                if(state.myGun02)
                {
                    Bullet.setLightBulletSpeed(Bullet.getLightBulletSpeed() * 2);
                    //Bullet.setMyLightBulletDamage(Bullet.getMyLightBulletDamage() * 2);
                }

                removeUpdateStar(tempUpdateStar);
            }
        }
        for (int i = 0; i < speedFoods.size(); i++) {
            tempSpeedFood = speedFoods.get(i);
            ShapesIntersects shapesIntersects = new ShapesIntersects();
            if (shapesIntersects.checkIntersect(state.locX - GameFrame.getMyTankImage().getWidth() / 2, state.locY - GameFrame.getMyTankImage().getHeight() / 2, GameFrame.getMyTankImage().getWidth(), GameFrame.getMyTankImage().getHeight()
                    , tempSpeedFood.getLocX() + state.xTransfer + tempSpeedFood.getSpeedFood().getWidth() / 3, tempSpeedFood.getLocY() + state.yTransfer + tempSpeedFood.getSpeedFood().getHeight() / 3, tempSpeedFood.getSpeedFood().getWidth() / 2, tempSpeedFood.getSpeedFood().getHeight() / 2)) {
                GameState.setSpeed(GameState.getSpeed() + 4);
                removeSpeedFood(tempSpeedFood);
            }
        }
    }

    public void removeRepairFood(RepairFood repairFood) {
        repairFoods.remove(repairFood);
    }

    public void addRepairFood(RepairFood repairFood) {
        repairFoods.add(repairFood);
    }
    public void removeGun01Food(Gun01Food gun01Food) {
        gun01Foods.remove(gun01Food);
    }

    public void addGun01Food(Gun01Food gun01Food) {
        gun01Foods.add(gun01Food);
    }
    public void removeGun02Food(Gun02Food gun02Food) {
        gun02Foods.remove(gun02Food);
    }

    public void addGun02Food(Gun02Food gun02Food) {
        gun02Foods.add(gun02Food);
    }
    public void removeUpdateStar(UpdateStar updateStar) {
        updateStars.remove(updateStar);
    }

    public void addUpdateStar(UpdateStar updateStar) {
        updateStars.add(updateStar);
    }

    public void removeSpeedFood(SpeedFood speedFood) {
        speedFoods.remove(speedFood);
    }

    public void addSpeedFood(SpeedFood speedFood) {
        speedFoods.add(speedFood);
    }

    public LinkedList<RepairFood> getRepairFoods() {
        return repairFoods;
    }

    public LinkedList<Gun01Food> getGun01Foods() {
        return gun01Foods;
    }

    public LinkedList<Gun02Food> getGun02Foods() {
        return gun02Foods;
    }

    public LinkedList<UpdateStar> getUpdateStars() {
        return updateStars;
    }

    public LinkedList<SpeedFood> getSpeedFoods() {
        return speedFoods;
    }
}

