package Weather;

/**
 * Created by Vincent Schmalor on 18/07/2017.
 * Main-Method to allocate most important parts
 */
public class MainWeather{
    
    static final String DEFAULT_Statement = "SELECT * FROM tblWeather";
    
    //Show current weather updated every 10 minutes due to node configuration
    //Restrictions should be added
    private static final String STATEMENT1 = "SELECT * FROM tblWeather";
    
    public static void main(String[] args){
        Engine engine = new Engine();
        engine.updateStatement(STATEMENT1);
        new InputListener(engine.getRuntime());
        System.out.println("Show current weather updated every 10 minutes due to node configuration");
    }
}
