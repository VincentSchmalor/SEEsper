package Mashinery;

/**
 * Created by Vincent Schmalor on 04/07/2017.
 */
public class MainWindSpeed {

    static final String DEFAULT_STATEMENT = "Select * FROM tblWindSpeed";

    static final String PART1 = "SELECT iteration, region, AVG(windSpeed) AS Average_WindSpeed FROM tblWindSpeed.win:length(1200) WHERE region = ";
    static final String PART2 = " having AVG(windSpeed) >35";

    /**
     * Mainactivity
     * @param args non required
     */
    public static void main(String[] args){
        Engine engine = new Engine();
        engine.updateStatement();
        Generator generator = new Generator(engine.getRuntime());
        generator.generate();
    }
}
