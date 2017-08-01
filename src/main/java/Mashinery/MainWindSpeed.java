package Mashinery;

/**
 * Created by Vincent Schmalor on 04/07/2017.
 * Main-Method to allocate most important parts
 */
public class MainWindSpeed{
    
    static final String DEFAULT_STATEMENT = "Select * FROM tblWindSpeed";
    
    //Select all measurements reporting a dangerous speed of wind
    static final String PART1 = "SELECT iteration, region, AVG(windSpeed) AS Average_WindSpeed FROM tblWindSpeed.win:length(1200) WHERE region = ";
    static final String PART2 = " having AVG(windSpeed) >35";
    
    /**
     * Mainactivity
     *
     * @param args non required
     */
    public static void main(String[] args){
        Engine engine = new Engine();
        engine.updateStatement();
        Generator generator = new Generator(engine.getRuntime());
        generator.generate();
    }
}
