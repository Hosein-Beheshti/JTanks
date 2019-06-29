import java.awt.*;
import java.util.LinkedList;
/**
 * this class controll all the Walls and plants and lines and teazels
 * this add and remove its to linkedlist
 * and call render method to draw its
 * and check intersects
 */

public class WallController {

    private LinkedList<HardWall> hardWalls = new LinkedList<>();
    private LinkedList<SoftWall> softWalls = new LinkedList<>();
    private LinkedList<Soil> soils = new LinkedList<>();
    private LinkedList<Teazel> teazels = new LinkedList<>();
    private LinkedList<Plant> plants = new LinkedList<>();
    private LinkedList<FinishLine> finishLines = new LinkedList<>();






    private HardWall tempHardWall;
    private SoftWall tempSoftWall;
    private Soil tempSoil;
    private Teazel tempTeazel;
    private Plant tempPlant;
    private  FinishLine tempFinishLine;



    public WallController()
    {
//
//        for(int i = 0 ; i<= 15 ; i++)
//        {
//            for(int j = 0 ; j>= -30 ; j--)
//            {
//                addSoil(new Soil(i*100, j*100));
//            }
//        }
//        addHardWall(new HardWall(100,500));
//        addHardWall(new HardWall(100,600));
//
//        addHardWall(new HardWall(300,500));
//        addHardWall(new HardWall(300,700));
//
//        addSoftWall(new SoftWall(700,200));
//
//        addSoil(new Soil(200,100));
//        addSoil(new Soil(300,100));
//        addSoil(new Soil(400,100));
//        addSoil(new Soil(200,200));
//        addSoil(new Soil(300,200));
//        addSoil(new Soil(400,200));
//
//        addTeazel(new Teazel(500,100));
//        addTeazel(new Teazel(600,100));
//
//        addPlant(new Plant(200,300));
//        addPlant(new Plant(300,300));

    }


    public void render(Graphics2D g , GameState state) {
        checkForRemove();
        for (int i = 0; i < soils.size(); i++) {
            tempSoil = soils.get(i);
            if(Math.abs(tempSoil.getLocX() + state.xTransfer - state.locX) <= 2000 && Math.abs(tempSoil.getLocY() + state.yTransfer - state.locY) <= 1200)
            tempSoil.render(g,state);
        }
        for (int i = 0; i < hardWalls.size(); i++) {
                tempHardWall = hardWalls.get(i);
            if(Math.abs(tempHardWall.getLocX() + state.xTransfer - state.locX) <= 2000 && Math.abs(tempHardWall.getLocY() + state.yTransfer - state.locY) <= 1200)
                tempHardWall.render(g,state);
        }

        for (int i = 0; i < softWalls.size(); i++) {
                tempSoftWall = softWalls.get(i);
            if(Math.abs(tempSoftWall.getLocX() + state.xTransfer - state.locX) <= 2000 && Math.abs(tempSoftWall.getLocY() + state.yTransfer - state.locY) <= 1200)
                tempSoftWall.render(g,state);
        }

        for (int i = 0; i < teazels.size(); i++) {
                tempTeazel = teazels.get(i);
            if(Math.abs(tempTeazel.getLocX() + state.xTransfer - state.locX) <= 2000 && Math.abs(tempTeazel.getLocY() + state.yTransfer - state.locY) <= 1200)
                tempTeazel.render(g,state);
        }
        for (int i = 0; i < finishLines.size(); i++) {
            tempFinishLine = finishLines.get(i);
            if(Math.abs(tempFinishLine.getLocX() + state.xTransfer - state.locX) <= 2000 && Math.abs(tempFinishLine.getLocY() + state.yTransfer - state.locY) <= 1200)
                tempFinishLine.render(g,state);
        }
    }
    public void renderPlants(Graphics2D g , GameState state) {
        for (int i = 0; i < plants.size(); i++) {
            tempPlant = plants.get(i);
            if(Math.abs(tempPlant.getLocX() + state.xTransfer - state.locX) <= 2000 && Math.abs(tempPlant.getLocY() + state.yTransfer - state.locY) <= 1200)
                tempPlant.render(g,state);
        }
    }
        public void checkForRemove() {
        for (int i = 0; i < softWalls.size(); i++) {
            tempSoftWall = softWalls.get(i);
            if (tempSoftWall.getHealth() <= 0) {
                if(tempSoftWall.isHaveGun01food())
                    GameFrame.getFoodsController().addGun01Food(new Gun01Food(tempSoftWall.getLocX(), tempSoftWall.getLocY()));

                if(tempSoftWall.isHaveGun02Food())
                    GameFrame.getFoodsController().addGun02Food(new Gun02Food(tempSoftWall.getLocX(), tempSoftWall.getLocY()));

                if(tempSoftWall.isHaveUpdateStar())
                    GameFrame.getFoodsController().addUpdateStar(new UpdateStar(tempSoftWall.getLocX(), tempSoftWall.getLocY()));

                if(tempSoftWall.isHaveRepairFood())
                    GameFrame.getFoodsController().addRepairFood(new RepairFood(tempSoftWall.getLocX(), tempSoftWall.getLocY()));

                removeSoftWall(tempSoftWall);
            }
        }
    }
    public void removeSoftWall (SoftWall softWall)
    {
        softWalls.remove(softWall);
    }

    public void addHardWall(HardWall hardWall)
    {
        hardWalls.add(hardWall);
    }
    public void addSoftWall(SoftWall softWall)
    {
        softWalls.add(softWall);
    }

    public void addSoil(Soil soil)
    {
        soils.add(soil);
    }
    public void addTeazel(Teazel teazel)
    {
        teazels.add(teazel);
    }

    public void addFinishLine(FinishLine finishLine)
    {
        finishLines.add(finishLine);
    }


    public void addPlant(Plant plant)
    {
        plants.add(plant);
    }
    public LinkedList<HardWall> getHardWalls() {
        return hardWalls;
    }
    public LinkedList<SoftWall> getSoftWalls() {
        return softWalls;
    }

    public LinkedList<Soil> getSoils() {
        return soils;
    }

    public LinkedList<Teazel> getTeazels() {
        return teazels;
    }

    public LinkedList<Plant> getPlants() {
        return plants;
    }

    public LinkedList<FinishLine> getFinishLines() {
        return finishLines;
    }
}
