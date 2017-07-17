package Mashinery;

/**
 * Created by Vincent Schmalor on 04/07/2017.
 */
public class MainWindSpeed {

    static final String DEFAULT_STATEMENT = "Select * FROM tblWindSpeed";

    static final String STATEMENT1 = "Select MAX(timeStamp), AVG(windSpeed) FROM tblWindSpeed.win:length(10) having avg(windSpeed) > 30";

    /**
     * Mainactivity
     * @param args non required
     */
    public static void main(String[] args){
        Engine engine = new Engine();
        engine.updateStatement(STATEMENT1);
        Generator generator = new Generator(engine.getRuntime());
        generator.generate();
    }
}
