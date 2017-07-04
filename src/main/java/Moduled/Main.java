package Moduled;

/**
 * Created by Vincent Schmalor on 04/07/2017.
 */
public class Main {

    static final String DEFAULT_STATEMENT = "SELECT * from tblTweet()";
    static final String STATEMENT1 = "SELECT 'TRUMP' as NAME, count(*) as ANZAHL from tblTweet.win:time(60sec) WHERE text LIKE '%#Trump%'";
    static final String STATEMENT2 = "SELECT 'MERKEL' as NAME, count(*) as ANZAHL from tblTweet.win:time(60sec) WHERE text LIKE '%#Merkel%'";
    static final String STATEMENT3 = "SELECT 'PUTIN' as NAME, count(*) as ANZAHL from tblTweet.win:time(60sec) WHERE text LIKE '%#Putin%'";
    static final String STATEMENT4 = "SELECT 'Macron' as NAME, count(*) as ANZAHL from tblTweet.win:time(60sec) WHERE text LIKE '%#Macron%'";


    /**
     * Mainactivity
     * @param args non required
     */
    public static void main(String[] args){
        Engine engine = new Engine();
        engine.updateStatement1(STATEMENT1,STATEMENT2,STATEMENT3,STATEMENT4);
        new InputListener(engine.getRuntime());
    }
}
