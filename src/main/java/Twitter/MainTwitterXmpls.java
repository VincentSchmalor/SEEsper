package Twitter;

/**
 * Created by Vincent Schmalor on 18/07/2017.
 * Main-Method to allocate most important parts
 * Some basic example Queries showing off what Esper can do
 */
public class MainTwitterXmpls {

    //Working Defaultstatement
    static final String DEFAULT_STATEMENT = "SELECT * from tblTweet()";

    //1. Example: Show count of tweets for each politician every 60 seconds
    static final String xmplHelper1 = "as NAME, count(*) as ANZAHL from tblTweet.win:time_batch(60sec) WHERE text LIKE";
    static final String STATEMENT1 = "SELECT 'TRUMP' " + xmplHelper1 + " '%#Trump%'";
    static final String STATEMENT2 = "SELECT 'MERKEL' " + xmplHelper1 + " '%#Merkel%'";
    static final String STATEMENT3 = "SELECT 'PUTIN' " + xmplHelper1 + " '%#Putin%'";
    static final String STATEMENT4 = "SELECT 'MACRON' " + xmplHelper1 + " '%#Macron%'";
    static final String STATEMENT5 = "SELECT 'TRUDEAU' " + xmplHelper1 + " '%#Trudeau%'";

    //2. Example:Show average count of followers of the last 30 tweeters for every politician
    static final String xmplHelper2 = "as NAME, avg(followers) as AVGFollowersPerTweeter from tblTweet.win:length(30) WHERE text LIKE";
    static final String STATEMENT6 = "SELECT 'TRUMP' " + xmplHelper2 + " '%#Trump%'";
    static final String STATEMENT7 = "SELECT 'MERKEL' " + xmplHelper2 + " '%#Merkel%'";
    static final String STATEMENT8 = "SELECT 'PUTIN' " + xmplHelper2 + " '%#Putin%'";
    static final String STATEMENT9 = "SELECT 'MACRON' " + xmplHelper2 + " '%#Macron%'";
    static final String STATEMENT10 = "SELECT 'TRUDEAU' " + xmplHelper2 + " '%#Trudeau%'";

    /**
     * Mainactivity
     * @param args non required
     */
    public static void main(String[] args){
        Engine engine = new Engine();
        engine.updateStatement(STATEMENT1,STATEMENT2,STATEMENT3,STATEMENT4,STATEMENT5); //1. Example
        engine.updateStatement(STATEMENT6,STATEMENT7,STATEMENT8,STATEMENT9,STATEMENT10); //2. Esample
        new InputListener(engine.getRuntime());
    }
}
