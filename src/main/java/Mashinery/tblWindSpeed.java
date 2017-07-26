package Mashinery;

/**
 * Created by Vincent Schmalor on 17.07.2017.
 * Template for items pushed into the engine
 */
public class tblWindSpeed{
    
    int iteration;
    long timeStamp;
    private int region;
    private double windSpeed;
    
    public tblWindSpeed(int iteration, long timeStamp, int plz, double windSpeed){
        this.iteration = iteration;
        this.timeStamp = timeStamp;
        this.region = plz;
        this.windSpeed = windSpeed;
    }
    
    @Override
    public String toString(){
        return "tblWindSpeed{" + "iteration=" + iteration + ", timeStamp=" + timeStamp + ", region=" + region + ", windSpeed=" + windSpeed + '}';
    }
    
    //Getters
    public int getIteration(){
        return iteration;
    }
    
    public long getTimeStamp(){
        return timeStamp;
    }
    
    public int getRegion(){
        return region;
    }
    
    public double getWindSpeed(){
        return windSpeed;
    }
}
