import java.awt.*;
import java.util.LinkedList;

/**
 * this class controll all the enemies
 * this add and remove its to linkedlist
 * and call render method to draw its
 * and check intersects
 */
public class EnemyController {

    private LinkedList<Enemy01> e1 = new LinkedList<>();
    private LinkedList<Enemy02> e2 = new LinkedList<>();
    private LinkedList<Enemy03> e3 = new LinkedList<>();
    private LinkedList<Enemy04> e4 = new LinkedList<>();



    private Enemy01 tempEnemy01;
    private Enemy02 tempEnemy02;
    private Enemy03 tempEnemy03;
    private Enemy04 tempEnemy04;


    public EnemyController()
    {
//        addEnemy(new Enemy02(500,500));
////       addEnemy(new Enemy02(800,500));
//       addEnemy(new Enemy02(0,-500));
////
//       addEnemy(new Enemy01(500,1200));
////       addEnemy(new Enemy01(1000,700));
//        Enemy01 hasan = new Enemy01(1500,5500);
//        hasan.setHaveGun01food(true);
//      addEnemy(hasan);
//      addEnemy(new Enemy01(-200,500));
//      addEnemy(new Enemy01(-200,100));

    }

    /**
     * check Health enemy and if be less 0 call remove method
     */
    public void checkForRemove(GameState state)
    {
       // System.out.println("hii");
        for (int i = 0 ; i < e1.size() ; i++)
        {
            tempEnemy01 = e1.get(i);
          //  System.out.println(tempEnemy01.getHealth());
           // System.out.println("health = " + tempEnemy01.getHealth());
            if(tempEnemy01.getHealth() <= 0)
            {
                if(tempEnemy01.isHaveGun01food())
                    GameFrame.getFoodsController().addGun01Food(new Gun01Food(tempEnemy01.getLocX(), tempEnemy01.getLocY()));

                if(tempEnemy01.isHaveGun02Food())
                    GameFrame.getFoodsController().addGun02Food(new Gun02Food(tempEnemy01.getLocX(), tempEnemy01.getLocY()));

                if(tempEnemy01.isHaveUpdateStar())
                    GameFrame.getFoodsController().addUpdateStar(new UpdateStar(tempEnemy01.getLocX(), tempEnemy01.getLocY()));

                if(tempEnemy01.isHaveRepairFood())
                    GameFrame.getFoodsController().addRepairFood(new RepairFood(tempEnemy01.getLocX(), tempEnemy01.getLocY()));

                Sound sound1 = new Sound("./Sounds/enemydestroyed.wav" , 0);
                sound1.doInBackground();
                    removeEnemy(tempEnemy01);
            }
        }
        for (int i = 0 ; i < e3.size() ; i++)
        {
            tempEnemy03 = e3.get(i);
            //  System.out.println(tempEnemy01.getHealth());
            // System.out.println("health = " + tempEnemy01.getHealth());
            if(tempEnemy03.getHealth() <= 0)
            {
                if(tempEnemy03.isHaveGun01food())
                    GameFrame.getFoodsController().addGun01Food(new Gun01Food(tempEnemy03.getLocX(), tempEnemy03.getLocY()));

                if(tempEnemy03.isHaveGun02Food())
                    GameFrame.getFoodsController().addGun02Food(new Gun02Food(tempEnemy03.getLocX(), tempEnemy03.getLocY()));

                if(tempEnemy03.isHaveUpdateStar())
                    GameFrame.getFoodsController().addUpdateStar(new UpdateStar(tempEnemy03.getLocX(), tempEnemy03.getLocY()));

                if(tempEnemy03.isHaveRepairFood())
                    GameFrame.getFoodsController().addRepairFood(new RepairFood(tempEnemy03.getLocX(), tempEnemy03.getLocY()));

                Sound sound1 = new Sound("./Sounds/enemydestroyed.wav" , 0);
                sound1.doInBackground();

                removeEnemy(tempEnemy03);
            }
        }
        for (int i = 0 ; i < e2.size() ; i++)
        {
            tempEnemy02 = e2.get(i);
           // System.out.println(tempEnemy02.getHealth());
            // System.out.println("health = " + tempEnemy01.getHealth());
            ShapesIntersects shapesIntersects = new ShapesIntersects();
            if(shapesIntersects.checkIntersect(state.locX - GameFrame.getMyTankImage().getWidth() / 2, state.locY - GameFrame.getMyTankImage().getHeight() / 2
                    ,GameFrame.getMyTankImage().getWidth() ,GameFrame.getMyTankImage().getHeight() , tempEnemy02.getLocX() + state.xTransfer- tempEnemy02.getMovingEnemyImage().getWidth() / 2, tempEnemy02.getLocY() + state.yTransfer - tempEnemy02.getMovingEnemyImage().getHeight() / 2
                    ,tempEnemy02.getMovingEnemyImage().getWidth()  ,tempEnemy02.getMovingEnemyImage().getHeight() ))
            {
                state.health = state.health - Enemy02.getDemage() ;

                if(tempEnemy02.isHaveGun01food())
                    GameFrame.getFoodsController().addGun01Food(new Gun01Food(tempEnemy02.getLocX(), tempEnemy02.getLocY()));

                if(tempEnemy02.isHaveGun02Food())
                    GameFrame.getFoodsController().addGun02Food(new Gun02Food(tempEnemy02.getLocX(), tempEnemy02.getLocY()));

                if(tempEnemy02.isHaveUpdateStar())
                    GameFrame.getFoodsController().addUpdateStar(new UpdateStar(tempEnemy02.getLocX(), tempEnemy02.getLocY()));

                if(tempEnemy02.isHaveRepairFood())
                    GameFrame.getFoodsController().addRepairFood(new RepairFood(tempEnemy02.getLocX(), tempEnemy02.getLocY()));
                Sound sound1 = new Sound("./Sounds/enemydestroyed.wav" , 0);
                sound1.doInBackground();
                e2.remove(tempEnemy02);
            }
            if(tempEnemy02.getHealth() <= 0)
            {
                if(tempEnemy02.isHaveGun01food())
                    GameFrame.getFoodsController().addGun01Food(new Gun01Food(tempEnemy02.getLocX(), tempEnemy02.getLocY()));

                if(tempEnemy02.isHaveGun02Food())
                    GameFrame.getFoodsController().addGun02Food(new Gun02Food(tempEnemy02.getLocX(), tempEnemy02.getLocY()));

                if(tempEnemy02.isHaveUpdateStar())
                    GameFrame.getFoodsController().addUpdateStar(new UpdateStar(tempEnemy02.getLocX(), tempEnemy02.getLocY()));

                if(tempEnemy02.isHaveRepairFood())
                    GameFrame.getFoodsController().addRepairFood(new RepairFood(tempEnemy02.getLocX(), tempEnemy02.getLocY()));
                Sound sound1 = new Sound("./Sounds/enemydestroyed.wav" , 0);
                sound1.doInBackground();
                removeEnemy(tempEnemy02);
            }
        }
        for (int i = 0 ; i < e4.size() ; i++)
        {
            tempEnemy04 = e4.get(i);

            ShapesIntersects shapesIntersects = new ShapesIntersects();
            if(shapesIntersects.checkIntersect(state.locX - GameFrame.getMyTankImage().getWidth() / 2, state.locY - GameFrame.getMyTankImage().getHeight() / 2
                    ,GameFrame.getMyTankImage().getWidth() ,GameFrame.getMyTankImage().getHeight() , tempEnemy04.getLocX() + state.xTransfer + tempEnemy04.getMineImage().getWidth() / 3, tempEnemy04.getLocY() + state.yTransfer + tempEnemy04.getMineImage().getHeight() / 3
                    ,tempEnemy04.getMineImage().getWidth() / 4 ,tempEnemy04.getMineImage().getHeight() / 4)) {
                state.health = state.health - Enemy04.getDemage();

                Sound sound1 = new Sound("./Sounds/enemydestroyed.wav" , 0);
                sound1.doInBackground();
                removeEnemy(tempEnemy04);
            }
            }
        }
    public void render(Graphics2D g,GameState state)
    {
        checkForRemove(state);
        for (int i = 0 ; i < e1.size() ; i++)
        {
            tempEnemy01 = e1.get(i);
            tempEnemy01.render(g,state);

        }
        for (int i = 0 ; i < e3.size() ; i++)
        {
            tempEnemy03 = e3.get(i);
            tempEnemy03.render(g,state);

        }
        for (int i = 0 ; i < e2.size() ; i++)
        {
            tempEnemy02 = e2.get(i);
            tempEnemy02.render(g,state);

        }
        for (int i = 0 ; i < e4.size() ; i++)
        {
            tempEnemy04 = e4.get(i);
            tempEnemy04.render(g,state);
        }
    }
    public void addEnemy(Enemy01 enemy01)
    {
       // System.out.println("enemy1");
        e1.add(enemy01);
    }
    public void addEnemy(Enemy02 enemy02)
    {
        //System.out.println("hi");
        e2.add(enemy02);
    }
    public void addEnemy(Enemy03 enemy03)
    {
        e3.add(enemy03);
    }

    public void addEnemy(Enemy04 enemy04)
    {
        e4.add(enemy04);
    }

    public void removeEnemy(Enemy01 enemy01)
    {
        e1.remove(enemy01);
    }
    public void removeEnemy(Enemy02 enemy02)
    {
        e2.remove(enemy02);
    }
    public void removeEnemy(Enemy03 enemy03)
    {
        e3.remove(enemy03);
    }
    public void removeEnemy(Enemy04 enemy04)
    {
        e4.remove(enemy04);
    }



    public LinkedList<Enemy01> getE1() {
        return e1;
    }

    public LinkedList<Enemy02> getE2() {
        return e2;
    }

    public LinkedList<Enemy03> getE3() {
        return e3;
    }

    public LinkedList<Enemy04> getE4() {
        return e4;
    }


}

