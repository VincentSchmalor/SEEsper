package Twitter;

/**
 * Created by Vincent Schmalor on 18/07/2017.
 * Main-Method to allocate most important parts
 * Some basic example Queries showing off what Esper can do
 */
public class MainTwitterXmpls{
    
    //Working Defaultstatement
    static final String DEFAULT_STATEMENT = "SELECT * from tblTweet()";
    
    //1. Example: Show count of tweets for each politician every 60 seconds
    private static final String xmplHelper1 = "as NAME, count(*) as ANZAHL from tblTweet.win:time_batch(60sec) WHERE text LIKE";
    private static final String STATEMENT1 = "SELECT 'TRUMP' " + xmplHelper1 + " '%#Trump%'";
    private static final String STATEMENT2 = "SELECT 'MERKEL' " + xmplHelper1 + " '%#Merkel%'";
    private static final String STATEMENT3 = "SELECT 'PUTIN' " + xmplHelper1 + " '%#Putin%'";
    private static final String STATEMENT4 = "SELECT 'MACRON' " + xmplHelper1 + " '%#Macron%'";
    private static final String STATEMENT5 = "SELECT 'TRUDEAU' " + xmplHelper1 + " '%#Trudeau%'";
    
    //2. Example: Show average count of followers of the last 30 tweeters for every politician
    private static final String xmplHelper2 = "as NAME, avg(followers) as AVGFollowersPerTweeter from tblTweet.win:length(30) WHERE text LIKE";
    private static final String STATEMENT6 = "SELECT 'TRUMP' " + xmplHelper2 + " '%#Trump%'";
    private static final String STATEMENT7 = "SELECT 'MERKEL' " + xmplHelper2 + " '%#Merkel%'";
    private static final String STATEMENT8 = "SELECT 'PUTIN' " + xmplHelper2 + " '%#Putin%'";
    private static final String STATEMENT9 = "SELECT 'MACRON' " + xmplHelper2 + " '%#Macron%'";
    private static final String STATEMENT10 = "SELECT 'TRUDEAU' " + xmplHelper2 + " '%#Trudeau%'";
    
    //3. Example: Show absolute number of followers and absolute number of tweets for every politician
    private static final String xmplHelper3 = "as NAME, username, text, followers, count(followers) as NumberTweeter FROM tblTweet() WHERE text LIKE ";
    private static final String STATEMENT11 = "SELECT 'TRUMP' " + xmplHelper3 + " '%#Trump%'";
    private static final String STATEMENT12 = "SELECT 'MERKEL' " + xmplHelper3 + " '%#Merkel%'";
    private static final String STATEMENT13 = "SELECT 'PUTIN' " + xmplHelper3 + " '%#Putin%'";
    private static final String STATEMENT14 = "SELECT 'MACRON' " + xmplHelper3 + " '%#Macron%'";
    private static final String STATEMENT15 = "SELECT 'TRUDEAU' " + xmplHelper3 + " '%#Trudeau%'";
    
    /**
     * Mainactivity
     *
     * @param args non required
     */
    public static void main(String[] args){
        Engine engine = new Engine();
        //Comment lines to see results of single statements
        engine.updateStatement(STATEMENT1, STATEMENT2, STATEMENT3, STATEMENT4, STATEMENT5); //1. Example
        engine.updateStatement(STATEMENT6, STATEMENT7, STATEMENT8, STATEMENT9, STATEMENT10); //2. Example
        engine.updateStatement(STATEMENT11,STATEMENT12,STATEMENT13,STATEMENT14,STATEMENT15); //3. Example
        new InputListener(engine.getRuntime());
    }
}
