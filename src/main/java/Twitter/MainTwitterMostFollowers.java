package Twitter;

/**
 * Created by Vincent Schmalor on 18/07/2017.
 * Main-Method to allocate most important parts
 */
public class MainTwitterMostFollowers{
    
    //Select the tweeter having the most followers in every minute
    private static final String useCase1Helper1 = "as NAME, username, followers FROM tblTweet.win:time_batch(60sec).ext:rank(followers, 1, followers desc) WHERE text LIKE";
    private static final String STATEMENT11 = "SELECT 'TRUMP' " + useCase1Helper1 + " '%#Trump%'";
    private static final String STATEMENT12 = "SELECT 'MERKEL' " + useCase1Helper1 + " '%#Merkel%'";
    private static final String STATEMENT13 = "SELECT 'PUTIN' " + useCase1Helper1 + " '%#Putin%'";
    private static final String STATEMENT14 = "SELECT 'MACRON' " + useCase1Helper1 + " '%#Macron%'";
    private static final String STATEMENT15 = "SELECT 'TRUDEAU' " + useCase1Helper1 + " '%#Trudeau%'";
    
    /**
     * Mainactivity
     *
     * @param args non required
     */
    public static void main(String[] args){
        Engine engine = new Engine();
        engine.updateStatement(STATEMENT11, STATEMENT12, STATEMENT13, STATEMENT14, STATEMENT15);
        new InputListener(engine.getRuntime());
        System.out.println("Select the tweeter having the most followers in every minute");
    }
}
