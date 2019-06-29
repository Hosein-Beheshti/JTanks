import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Array;

/**
 * this class read all maps
 * and add objects to arraylists
 */
public class Map {

    private int sizeX;
    private int sizeY;
    private char[][] map;
    private int i,j,k = 0,l = 0,m = 0,n = 0;
    private static boolean stage1,stage2,stage3;
    private static boolean myMapBool = true;

    /**
     * constructor
     * initialize stage1 is true
     */
    public Map()
    {
        map = new char[100][100];
        stage1 = true;
        stage2 = false;
        stage3 = false;
        myMapBool = false;
    }
    public void readAndAddMap(boolean easy , boolean normal , boolean hard){
        FileReader mapFile = null;
        try {
            if(myMapBool)
            {
                mapFile = new FileReader("./maps/myMap.txt");
                BufferedReader bufferedReader = new BufferedReader(new FileReader("./maps/myMap.txt"));
                sizeX = bufferedReader.readLine().toString().length();
            }
            else if(stage1) {
                if (easy) {
                    mapFile = new FileReader("./maps/easyMapStage1.txt");
                    BufferedReader bufferedReader = new BufferedReader(new FileReader("./maps/easyMapStage1.txt"));
                    sizeX = bufferedReader.readLine().toString().length();
                }
                if (normal) {
                    mapFile = new FileReader("./maps/normalMapStage1.txt");
                    BufferedReader bufferedReader = new BufferedReader(new FileReader("./maps/easyMapStage1.txt"));
                    sizeX = bufferedReader.readLine().toString().length();
                }
                if (hard) {
                    mapFile = new FileReader("./maps/hardMapStage1.txt");
                    BufferedReader bufferedReader = new BufferedReader(new FileReader("./maps/easyMapStage1.txt"));
                    sizeX = bufferedReader.readLine().toString().length();
                }
            }
            else if(stage2)
            {
                if (easy) {
                    mapFile = new FileReader("./maps/easyMapStage2.txt");
                    BufferedReader bufferedReader = new BufferedReader(new FileReader("./maps/easyMapStage1.txt"));
                    sizeX = bufferedReader.readLine().toString().length();
                }
                if (normal) {
                    mapFile = new FileReader("./maps/normalMapStage2.txt");
                    BufferedReader bufferedReader = new BufferedReader(new FileReader("./maps/easyMapStage1.txt"));
                    sizeX = bufferedReader.readLine().toString().length();
                }
                if (hard) {
                    mapFile = new FileReader("./maps/hardMapStage2.txt");
                    BufferedReader bufferedReader = new BufferedReader(new FileReader("./maps/easyMapStage1.txt"));
                    sizeX = bufferedReader.readLine().toString().length();
                }
            }
            else if(stage3)
            {
                if (easy) {
                    mapFile = new FileReader("./maps/easyMapStage3.txt");
                    BufferedReader bufferedReader = new BufferedReader(new FileReader("./maps/easyMapStage1.txt"));
                    sizeX = bufferedReader.readLine().toString().length();
                }
                if (normal) {
                    mapFile = new FileReader("./maps/normalMapStage3.txt");
                    BufferedReader bufferedReader = new BufferedReader(new FileReader("./maps/easyMapStage1.txt"));
                    sizeX = bufferedReader.readLine().toString().length();
                }
                if (hard) {
                    mapFile = new FileReader("./maps/hardMapStage3.txt");
                    BufferedReader bufferedReader = new BufferedReader(new FileReader("./maps/easyMapStage1.txt"));
                    sizeX = bufferedReader.readLine().toString().length();
                }
            }
            int c;
            int i = 0, j = 0;
            while ((c = mapFile.read()) != -1)
            {
               // System.out.println((char)c);
                //char r = (char) c;
                map[j][i] =  (char) c;
                i++;
                if(i == sizeX )
                {
                    j++;
                    i = 0;
                    mapFile.read();
                    if(!myMapBool)
                    mapFile.read();
                    sizeY = j;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(sizeX);
        System.out.println(sizeY);

        for(int j = 0 ; j < sizeY ; j++) {
            for (int i = 0; i < sizeX; i++) {
                if(!String.valueOf(map[j][i]).equals("W"))
                GameFrame.getWallController().addSoil(new Soil(i*100,j*100));
            }
        }
        for(int j = 0 ; j < sizeY ; j++)
        {
            for(int i = 0 ; i < sizeX ; i++)
            {
               if(String.valueOf(map[j][i]).equals("W"))
               {
                   GameFrame.getWallController().addHardWall(new HardWall(i*100 , j*100));
               }
                if(String.valueOf(map[j][i]).equals("s"))
                {
                  // GameFrame.getWallController().addSoil(new Soil(i*100 , j*100));
                }
                if(String.valueOf(map[j][i]).equals("w"))
                {
                    m++;
                    SoftWall sW = new SoftWall(i*100 , j*100);
                    if(m % 4 == 0)
                        sW.setHaveGun01food(true);
                    else if(m % 6 == 0)
                        sW.setHaveGun02Food(true);
                    else if(m % 10 == 0)
                        sW.setHaveRepairFood(true);
                    else if(m % 14 == 0)
                        sW.setHaveUpdateStar(true);

                    GameFrame.getWallController().addSoftWall(sW);
                }
                if(String.valueOf(map[j][i]).equals("t"))
                {
                    GameFrame.getWallController().addTeazel(new Teazel(i*100 , j*100));
                }
                if(String.valueOf(map[j][i]).equals("p"))
                {
                    GameFrame.getWallController().addPlant(new Plant(i*100 , j*100));
                }
                if(String.valueOf(map[j][i]).equals("1"))
                {
                    n++;
                    Enemy01 enemy01 = new Enemy01(i*100 , j*100);
                    if(n % 4 == 0)
                    enemy01.setHaveGun01food(true);
                    else if(n % 6 == 0)
                        enemy01.setHaveGun02Food(true);
                    else if(n % 10 == 0)
                        enemy01.setHaveRepairFood(true);
                    else if(n % 7 == 0)
                        enemy01.setHaveUpdateStar(true);

                    GameFrame.getEnemyController().addEnemy(enemy01);
                }
                if(String.valueOf(map[j][i]).equals("2"))
                {
                    k++;
                    Enemy02 enemy02 = new Enemy02(i*100 , j*100);
                    if(k % 4 == 0)
                        enemy02.setHaveGun01food(true);
                    else if(k % 6 == 0)
                        enemy02.setHaveGun02Food(true);
                    else if(k % 10 == 0)
                        enemy02.setHaveRepairFood(true);
                    else if(k % 14 == 0)
                        enemy02.setHaveUpdateStar(true);

                    GameFrame.getEnemyController().addEnemy(enemy02);
                }
                if(String.valueOf(map[j][i]).equals("3"))
                {
                    l++;
                    Enemy03 enemy03 = new Enemy03(i*100 , j*100);
                    if(l % 4 == 0)
                        enemy03.setHaveGun01food(true);
                    else if(l % 6 == 0)
                        enemy03.setHaveGun02Food(true);
                    else if(l % 10 == 0)
                        enemy03.setHaveRepairFood(true);
                    else if(l % 14 == 0)
                        enemy03.setHaveUpdateStar(true);

                    GameFrame.getEnemyController().addEnemy(enemy03);
                }
                if(String.valueOf(map[j][i]).equals("4"))
                {
                    Enemy04 enemy04 = new Enemy04(i*100 , j*100);
                    GameFrame.getEnemyController().addEnemy(enemy04);
                  //  System.out.println(GameFrame.getEnemyController().getE4().size());
                }
                if(String.valueOf(map[j][i]).equals("r"))
                {
                    GameFrame.getFoodsController().addRepairFood(new RepairFood(i*100 , j*100));
                }
                if(String.valueOf(map[j][i]).equals("F"))
                {
                    GameFrame.getFoodsController().addGun01Food(new Gun01Food(i*100 , j*100));
                }
                if(String.valueOf(map[j][i]).equals("f"))
                {
                    GameFrame.getFoodsController().addGun02Food(new Gun02Food(i*100 , j*100));
                }
                if(String.valueOf(map[j][i]).equals("u"))
                {
                    GameFrame.getFoodsController().addUpdateStar(new UpdateStar(i*100 , j*100));
                }
                if(String.valueOf(map[j][i]).equals("E"))
                {
                    GameFrame.getWallController().addFinishLine(new FinishLine(i*100 , j*100));
                }
                if(String.valueOf(map[j][i]).equals("S"))
                {
                    GameFrame.getFoodsController().addSpeedFood(new SpeedFood(i*100 , j*100));
                }

            }
        }
    }

    public static boolean isStage1() {
        return stage1;
    }

    public static void setStage1(boolean stage1) {
        Map.stage1 = stage1;
    }

    public static boolean isStage2() {
        return stage2;
    }

    public static void setStage2(boolean stage2) {
        Map.stage2 = stage2;
    }

    public static boolean isStage3() {
        return stage3;
    }

    public static void setStage3(boolean stage3) {
        Map.stage3 = stage3;
    }

    public static boolean isMyMapBool() {
        return myMapBool;
    }

    public static void setMyMapBool(boolean myMapBool) {
        Map.myMapBool = myMapBool;
    }
}
