package Mashinery;

/**
 * Created by Vincent Schmalor on 04/07/2017.
 */
public class MainWindSpeed {

    static final String DEFAULT_STATEMENT = "Select * FROM tblWindSpeed";

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
