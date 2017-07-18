package Weather;

/**
 * Created by Vincent Schmalor on 18/07/2017.
 */
public class MainWeather {

    static final String DEFAULT_Statement = "SELECT * FROM tblWeather";

    //Aktuelles Wetter: Einschränkungen möglich
    static final String STATEMENT1 = "SELECT * FROM tblWeather";

    public static void main(String[] args){
        Engine engine = new Engine();
        engine.updateStatement(STATEMENT1);
        new InputListener(engine.getRuntime());
    }
}
