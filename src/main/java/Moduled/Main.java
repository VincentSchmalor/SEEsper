package Moduled;

/**
 * Created by Vincent Schmalor on 04/07/2017.
 */
public class Main {

    static final String DEFAULT_STATEMENT = "SELECT * from tblTweet()";
    static final String STATEMENT = "SELECT username, created_at, text from tbTweet()";
    /**
     * Mainactivity
     * @param args non required
     */
    public static void main(String[] args){
        Engine engine = new Engine();
        engine.updateStatement(STATEMENT);
        engine.addListener();
        new InputListener(engine.getRuntime());
    }
}
