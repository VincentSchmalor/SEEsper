package Weather;

/**
 * Created by vince on 18.07.2017.
 * Template for items pushed into the engine
 */
public class tblWeather{
    private String weather;
    private String detail;
    private double tempk;
    private double tempc;
    private double temp_maxc;
    private double temp_minc;
    private double humidity;
    private double maxtemp;
    private double mintemp;
    private double windspeed;
    private double winddirection;
    private String location;
    private long sunrise;
    private long sunset;
    private double clouds;
    private String description;
    
    public tblWeather(String weather, String detail, double tempk, double tempc, double temp_maxc, double temp_minc, double humidity, double maxtemp, double mintemp, double windspeed, double winddirection, String location, long sunrise, long sunset, double clouds, String description){
        this.weather = weather;
        this.detail = detail;
        this.tempk = tempk;
        this.tempc = tempc;
        this.temp_maxc = temp_maxc;
        this.temp_minc = temp_minc;
        this.humidity = humidity;
        this.maxtemp = maxtemp;
        this.mintemp = mintemp;
        this.windspeed = windspeed;
        this.winddirection = winddirection;
        this.location = location;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.clouds = clouds;
        this.description = description;
    }
    
    @Override
    public String toString(){
        return "tblWeather{" + "weather='" + weather + '\'' + ", detail='" + detail + '\'' + ", tempk=" + tempk + ", tempc=" + tempc + ", temp_maxc=" + temp_maxc + ", temp_minc=" + temp_minc + ", humidity=" + humidity + ", maxtemp=" + maxtemp + ", mintemp=" + mintemp + ", windspeed=" + windspeed + ", winddirection=" + winddirection + ", location='" + location + '\'' + ", sunrise=" + sunrise + ", sunset=" + sunset + ", clouds=" + clouds + ", description='" + description + '\'' + '}';
    }
    
    //Getters
    public String getDetail(){
        return detail;
    }
    
    public double getTempc(){
        return tempc;
    }
    
    public double getTemp_maxc(){
        return temp_maxc;
    }
    
    public double getTemp_minc(){
        return temp_minc;
    }
    
    public double getHumidity(){
        return humidity;
    }
    
    public double getWindspeed(){
        return windspeed;
    }
    
    public String getLocation(){
        return location;
    }
    
    public double getClouds(){
        return clouds;
    }
    
    public String getDescription(){
        return description;
    }
    
    public String getWeather(){
        return weather;
    }
    
    public double getTempk(){
        return tempk;
    }
    
    public double getMaxtemp(){
        return maxtemp;
    }
    
    public double getMintemp(){
        return mintemp;
    }
    
    public double getWinddirection(){
        return winddirection;
    }
    
    public long getSunrise(){
        return sunrise;
    }
    
    public long getSunset(){
        return sunset;
    }
}
