/**
 * this class take up down left right booleans and
 * check thats and give me a angle
 * for Enemy tank rotate
 */
public class EnemyTankRotation {

        private double tankAngle;

        public EnemyTankRotation()
        {

        }

    /**
     * this class take angle
     * @param keyUP
     * @param keyDOWN
     * @param keyLEFT
     * @param keyRIGHT
     * @return
     */
        public double getAngle (boolean keyUP,boolean keyDOWN , boolean keyLEFT , boolean keyRIGHT)
        {
//            System.out.println("up = " + keyUP);
//            System.out.println("down = " + keyDOWN);
//            System.out.println("left = " + keyLEFT);
//            System.out.println("right = " + keyRIGHT);


            if (Math.abs(tankAngle) >= 360)
                tankAngle = 0;
            if (tankAngle < 0)
                tankAngle = 359;

            if (keyUP && !keyLEFT && !keyRIGHT) {
                if (Math.abs(tankAngle) < 90 && Math.abs(tankAngle) >= 0)
                    tankAngle = Math.abs(tankAngle) + 2;
                if (Math.abs(tankAngle) > 90 && Math.abs(tankAngle) <= 180)
                    tankAngle = Math.abs(tankAngle) - 2;
                if (Math.abs(tankAngle) < 270 && Math.abs(tankAngle) >= 180 || Math.abs(tankAngle) == 0)
                    tankAngle = Math.abs(tankAngle) + 2;
                if (Math.abs(tankAngle) > 270 && Math.abs(tankAngle) < 360)
                    tankAngle = Math.abs(tankAngle) - 2;
            }
            if (keyLEFT && !keyUP && !keyDOWN) {
                if (Math.abs(tankAngle) < 180 && Math.abs(tankAngle) >= 90)
                    tankAngle = Math.abs(tankAngle) + 2;
                if (Math.abs(tankAngle) > 180 && Math.abs(tankAngle) <= 270)
                    tankAngle = Math.abs(tankAngle) - 2;
                if (Math.abs(tankAngle) < 360 && Math.abs(tankAngle) >= 270)
                    tankAngle = Math.abs(tankAngle) + 2;
                if (Math.abs(tankAngle) > 0 && Math.abs(tankAngle) <= 90)
                    tankAngle = Math.abs(tankAngle) - 2;
            }
            if (keyRIGHT && !keyDOWN && !keyUP) {
                if (Math.abs(tankAngle) < 180 && Math.abs(tankAngle) >= 90)
                    tankAngle = Math.abs(tankAngle) + 2;
                if (Math.abs(tankAngle) > 180 && Math.abs(tankAngle) <= 270)
                    tankAngle = Math.abs(tankAngle) - 2;
                if (Math.abs(tankAngle) < 360 && Math.abs(tankAngle) >= 270)
                    tankAngle = Math.abs(tankAngle) + 2;
                if (Math.abs(tankAngle) > 0 && Math.abs(tankAngle) <= 90)
                    tankAngle = Math.abs(tankAngle) - 2;
            }
            if (keyDOWN && !keyRIGHT && !keyLEFT) {
                if (Math.abs(tankAngle) < 90 && Math.abs(tankAngle) >= 0)
                    tankAngle = Math.abs(tankAngle) + 2;
                if (Math.abs(tankAngle) > 90 && Math.abs(tankAngle) <= 180)
                    tankAngle = Math.abs(tankAngle) - 2;
                if (Math.abs(tankAngle) < 270 && Math.abs(tankAngle) >= 180 || Math.abs(tankAngle) == 0)
                    tankAngle = Math.abs(tankAngle) +2;
                if (Math.abs(tankAngle) > 270 && Math.abs(tankAngle) < 360)
                    tankAngle = Math.abs(tankAngle) - 2;
            }
            if (keyUP && keyLEFT) {
                if (Math.abs(tankAngle) < 360 && Math.abs(tankAngle) >= 315 || Math.abs(tankAngle) < 45 && Math.abs(tankAngle) >= 0)
                    tankAngle = Math.abs(tankAngle) + 2;
                if (Math.abs(tankAngle) > 45 && Math.abs(tankAngle) < 135)
                    tankAngle = Math.abs(tankAngle) - 2;
                if (Math.abs(tankAngle) < 225 && Math.abs(tankAngle) >= 135)
                    tankAngle = Math.abs(tankAngle) + 2;
                if (Math.abs(tankAngle) > 225 && Math.abs(tankAngle) < 315)
                    tankAngle = Math.abs(tankAngle) - 2;
            }

            if (keyUP && keyRIGHT) {
                if (Math.abs(tankAngle) < 135 && Math.abs(tankAngle) >= 45)
                    tankAngle = Math.abs(tankAngle) + 2;
                if (Math.abs(tankAngle) > 135 && Math.abs(tankAngle) < 225) {
                    tankAngle = Math.abs(tankAngle) - 2;
                }
                if (Math.abs(tankAngle) < 315 && Math.abs(tankAngle) >= 225)
                    tankAngle = Math.abs(tankAngle) + 2;
                if (Math.abs(tankAngle) > 315 && Math.abs(tankAngle) < 360 || Math.abs(tankAngle) >=0 && Math.abs(tankAngle) < 45)
                    tankAngle = Math.abs(tankAngle) - 2;
            }
            if (keyDOWN && keyRIGHT) {
                if (Math.abs(tankAngle) < 225 && Math.abs(tankAngle) >= 135)
                    tankAngle = Math.abs(tankAngle) + 2;
                if (Math.abs(tankAngle) > 225 && Math.abs(tankAngle) < 315) {
                    tankAngle = Math.abs(tankAngle) - 2;
                }
                if (Math.abs(tankAngle) < 360 && Math.abs(tankAngle) >= 315 || Math.abs(tankAngle) >= 0 && Math.abs(tankAngle) < 45)
                    tankAngle = Math.abs(tankAngle) + 2;
                if (Math.abs(tankAngle) > 45 && Math.abs(tankAngle) < 135)
                    tankAngle = Math.abs(tankAngle) - 2;
            }
            if (keyDOWN && keyLEFT) {
                if (Math.abs(tankAngle) < 315 && Math.abs(tankAngle) >= 225)
                    tankAngle = Math.abs(tankAngle) + 2;
                if (Math.abs(tankAngle) > 315 && Math.abs(tankAngle) < 360 || Math.abs(tankAngle) >= 0 && Math.abs(tankAngle) < 45) {
                    tankAngle = Math.abs(tankAngle) - 2;
                }
                if (Math.abs(tankAngle) < 135 && Math.abs(tankAngle) >= 45)
                    tankAngle = Math.abs(tankAngle) + 2;
                if (Math.abs(tankAngle) > 135 && Math.abs(tankAngle) < 225)
                    tankAngle = Math.abs(tankAngle) - 2;
            }

            return tankAngle;
        }

    public void setTankAngle(double tankAngle) {
        this.tankAngle = tankAngle;
    }
}
