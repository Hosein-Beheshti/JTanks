public class MyTankRotation {
    /**
     * this class take keys boolean and
     * cgeck thats and give me a angle
     * for our tank rotate
     */
    private double tankAngle;

    public MyTankRotation()
    {
    }
    public double getAngle (GameState state)
    {

        if (Math.abs(tankAngle) >= 360)
            tankAngle = 0;
        if (tankAngle < 0)
            tankAngle = 359;

        if (state.keyUP && !state.keyLEFT && !state.keyRIGHT) {
            if (Math.abs(tankAngle) < 90 && Math.abs(tankAngle) >= 0)
                tankAngle = Math.abs(tankAngle) + 5;
            if (Math.abs(tankAngle) > 90 && Math.abs(tankAngle) <= 180)
                tankAngle = Math.abs(tankAngle) - 5;
            if (Math.abs(tankAngle) < 270 && Math.abs(tankAngle) >= 180 || Math.abs(tankAngle) == 0)
                tankAngle = Math.abs(tankAngle) + 5;
            if (Math.abs(tankAngle) > 270 && Math.abs(tankAngle) < 360)
                tankAngle = Math.abs(tankAngle) - 5;
        }
        if (state.keyLEFT && !state.keyUP && !state.keyDOWN) {
            if (Math.abs(tankAngle) < 180 && Math.abs(tankAngle) >= 90)
                tankAngle = Math.abs(tankAngle) + 5;
            if (Math.abs(tankAngle) > 180 && Math.abs(tankAngle) <= 270)
                tankAngle = Math.abs(tankAngle) - 5;
            if (Math.abs(tankAngle) < 360 && Math.abs(tankAngle) >= 270)
                tankAngle = Math.abs(tankAngle) + 5;
            if (Math.abs(tankAngle) > 0 && Math.abs(tankAngle) <= 90)
                tankAngle = Math.abs(tankAngle) - 5;
        }
        if (state.keyRIGHT && !state.keyDOWN && !state.keyUP) {
            if (Math.abs(tankAngle) < 180 && Math.abs(tankAngle) >= 90)
                tankAngle = Math.abs(tankAngle) + 5;
            if (Math.abs(tankAngle) > 180 && Math.abs(tankAngle) <= 270)
                tankAngle = Math.abs(tankAngle) - 5;
            if (Math.abs(tankAngle) < 360 && Math.abs(tankAngle) >= 270)
                tankAngle = Math.abs(tankAngle) + 5;
            if (Math.abs(tankAngle) > 0 && Math.abs(tankAngle) <= 90)
                tankAngle = Math.abs(tankAngle) - 5;
        }
        if (state.keyDOWN && !state.keyRIGHT && !state.keyLEFT) {
            if (Math.abs(tankAngle) < 90 && Math.abs(tankAngle) >= 0)
                tankAngle = Math.abs(tankAngle) + 5;
            if (Math.abs(tankAngle) > 90 && Math.abs(tankAngle) <= 180)
                tankAngle = Math.abs(tankAngle) - 5;
            if (Math.abs(tankAngle) < 270 && Math.abs(tankAngle) >= 180 || Math.abs(tankAngle) == 0)
                tankAngle = Math.abs(tankAngle) + 5;
            if (Math.abs(tankAngle) > 270 && Math.abs(tankAngle) < 360)
                tankAngle = Math.abs(tankAngle) - 5;
        }
        if (state.keyUP && state.keyLEFT) {
            if (Math.abs(tankAngle) < 360 && Math.abs(tankAngle) >= 315 || Math.abs(tankAngle) < 45 && Math.abs(tankAngle) >= 0)
                tankAngle = Math.abs(tankAngle) + 5;
            if (Math.abs(tankAngle) > 45 && Math.abs(tankAngle) < 135)
                tankAngle = Math.abs(tankAngle) - 5;
            if (Math.abs(tankAngle) < 225 && Math.abs(tankAngle) >= 135)
                tankAngle = Math.abs(tankAngle) + 5;
            if (Math.abs(tankAngle) > 225 && Math.abs(tankAngle) < 315)
                tankAngle = Math.abs(tankAngle) - 5;
        }

        if (state.keyUP && state.keyRIGHT) {
            if (Math.abs(tankAngle) < 135 && Math.abs(tankAngle) >= 45)
                tankAngle = Math.abs(tankAngle) + 5;
            if (Math.abs(tankAngle) > 135 && Math.abs(tankAngle) < 225) {
                tankAngle = Math.abs(tankAngle) - 5;
            }
            if (Math.abs(tankAngle) < 315 && Math.abs(tankAngle) >= 225)
                tankAngle = Math.abs(tankAngle) + 5;
            if (Math.abs(tankAngle) > 315 && Math.abs(tankAngle) < 360 || Math.abs(tankAngle) >=0 && Math.abs(tankAngle) < 45)
                tankAngle = Math.abs(tankAngle) - 5;
        }
        if (state.keyDOWN && state.keyRIGHT) {
            if (Math.abs(tankAngle) < 225 && Math.abs(tankAngle) >= 135)
                tankAngle = Math.abs(tankAngle) + 5;
            if (Math.abs(tankAngle) > 225 && Math.abs(tankAngle) < 315) {
                tankAngle = Math.abs(tankAngle) - 5;
            }
            if (Math.abs(tankAngle) < 360 && Math.abs(tankAngle) >= 315 || Math.abs(tankAngle) >= 0 && Math.abs(tankAngle) < 45)
                tankAngle = Math.abs(tankAngle) + 5;
            if (Math.abs(tankAngle) > 45 && Math.abs(tankAngle) < 135)
                tankAngle = Math.abs(tankAngle) - 5;
        }
        if (state.keyDOWN && state.keyLEFT) {
            if (Math.abs(tankAngle) < 315 && Math.abs(tankAngle) >= 225)
                tankAngle = Math.abs(tankAngle) + 5;
            if (Math.abs(tankAngle) > 315 && Math.abs(tankAngle) < 360 || Math.abs(tankAngle) >= 0 && Math.abs(tankAngle) < 45) {
                tankAngle = Math.abs(tankAngle) - 5;
            }
            if (Math.abs(tankAngle) < 135 && Math.abs(tankAngle) >= 45)
                tankAngle = Math.abs(tankAngle) + 5;
            if (Math.abs(tankAngle) > 135 && Math.abs(tankAngle) < 225)
                tankAngle = Math.abs(tankAngle) - 5;
        }

        return tankAngle;
    }

}
