package Mashinery;

import java.util.Date;

/**
 * Created by vince on 17.07.2017.
 */
public class tblWindSpeed {

    long timeStamp;
    private int plz;
    private double windSpeed;

    public tblWindSpeed(long timeStamp, int plz, double windSpeed) {
        this.timeStamp = timeStamp;
        this.plz = plz;
        this.windSpeed = windSpeed;
    }

    public String toString(){
        return "Time: " + timeStamp + "; PLZ: " + plz + "; Windspeed: " + windSpeed + ";";
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public int getPlz() {
        return plz;
    }

    public double getWindSpeed() {
        return windSpeed;
    }
}
