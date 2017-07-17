package Twitter;

/**
 * Created by Vincent Schmalor on 04/07/2017.
 */
public class MainTwitter {


    static final String DEFAULT_STATEMENT = "SELECT * from tblTweet()";

    //1. Example: Zeige alle 60 Sekunden die Anzahl der Tweets der letzten 60 Sekunden mit dem Hashtag des jeweiligen Politikers
    static final String xmplHelper1 = "as NAME, count(*) as ANZAHL from tblTweet.win:time_batch(60sec) WHERE text LIKE";
    static final String STATEMENT1 = "SELECT 'TRUMP' " + xmplHelper1 + " '%#Trump%'";
    static final String STATEMENT2 = "SELECT 'MERKEL' " + xmplHelper1 + " '%#Merkel%'";
    static final String STATEMENT3 = "SELECT 'PUTIN' " + xmplHelper1 + " '%#Putin%'";
    static final String STATEMENT4 = "SELECT 'MACRON' " + xmplHelper1 + " '%#Macron%'";
    static final String STATEMENT5 = "SELECT 'TRUDEAU' " + xmplHelper1 + " '%#Trudeau%'";

    //2. Example: Zeige alle 60 Sekunden die durchschnittliche Anzahl an Followern der Tweeter je Politiker je 60 Sekunden an
    static final String xmplHelper2 = "as NAME, avg(followers) as AVGFollowersPerTweeter from tblTweet.win:time_batch(60 sec) WHERE text LIKE";
    static final String STATEMENT6 = "SELECT 'TRUMP' " + xmplHelper2 + " '%#Trump%'";
    static final String STATEMENT7 = "SELECT 'MERKEL' " + xmplHelper2 + " '%#Merkel%'";
    static final String STATEMENT8 = "SELECT 'PUTIN' " + xmplHelper2 + " '%#Putin%'";
    static final String STATEMENT9 = "SELECT 'MACRON' " + xmplHelper2 + " %#Macron%'";
    static final String STATEMENT10 = "SELECT 'TRUDEAU " + xmplHelper2 + " %#Trudeau%'";

    //1. Use-Case Selektiere den Tweeter mit den meisten Followern
    static final String useCase1Helper1 = "as NAME, username, followers FROM tblTweet.win:time_batch(60sec).ext:rank(followers, 1, followers desc) WHERE text LIKE";
    static final String STATEMENT11 = "SELECT 'TRUMP' " + useCase1Helper1 + " '%#Trump%'";
    static final String STATEMENT12 = "SELECT 'MERKEL' " + useCase1Helper1 + " '%#Merkel%'";
    static final String STATEMENT13 = "SELECT 'PUTIN' " + useCase1Helper1 + " '%#Putin%'";
    static final String STATEMENT14 = "SELECT 'MACRON' " + useCase1Helper1 + " '%#Macron%'";
    static final String STATEMENT15 = "SELECT 'TRUDEAU " + useCase1Helper1 + " '%#Trudeau%'";

    //2. Use-Case Gib bei jedem 10. Event das durchschnittliche Sentiment der letzten 10 Events aus
    static final String getUseCase1Helper2 = "as NAME, avg(sentiment) as AverageSentiment FROM tblTweet.win:length_batch(10) WHERE text LIKE";
    static final String STATEMENT16 = "SELECT 'TRUMP' " + useCase1Helper1 + " '%#Trump%'";
    static final String STATEMENT17 = "SELECT 'MERKEL' " + useCase1Helper1 + " '%#Merkel%'";
    static final String STATEMENT18 = "SELECT 'PUTIN' " + useCase1Helper1 + " '%#Putin%'";
    static final String STATEMENT19 = "SELECT 'MACRON' " + useCase1Helper1 + " '%#Macron%'";
    static final String STATEMENT20 = "SELECT 'TRUDEAU' " + useCase1Helper1 + " '%#Trudeau%'";

    //3. Use-Case Bullshit
    static final String STATEMENT21 = "SELECT 'TRUMP' as NAME, username, text, followers, count(followers) as NumberTweeter FROM tblTweet() WHERE text LIKE '%#Trump%'";
    static final String STATEMENT22 = "SELECT 'MERKEL' as NAME, username, text, followers, count(followers) as NNumberTweeter FROM tblTweet() WHERE text LIKE '%#Merkel%'";
    static final String STATEMENT23 = "SELECT 'PUTIN' as NAME, username, text, followers, count(followers) as NumberTweeter FROM tblTweet() WHERE text LIKE '%#Putin%'";
    static final String STATEMENT24 = "SELECT 'MACRON' as NAME, username, text, followers, count(followers) as NumberTweeter FROM tblTweet() WHERE text LIKE '%#Macron%'";
    static final String STATEMENT25 = "SELECT 'TRUDEAU' as NAME, username, text, followers, count(followers) as NumberTweeter FROM tblTweet() WHERE text LIKE '%#Trudeau%'";


    static final String STATEMENT100 = "SELECT username, followers, text, sentiment FROM tblTweet()";

    /**
     * Mainactivity
     * @param args non required
     */
    public static void main(String[] args){
        Engine engine = new Engine();
        //engine.updateStatement(DEFAULT_STATEMENT);
        //engine.updateStatement(STATEMENT1,STATEMENT2,STATEMENT3,STATEMENT4,STATEMENT5); //1. Example
        //engine.updateStatement(STATEMENT6,STATEMENT7,STATEMENT8,STATEMENT9,STATEMENT10); //2. Esample
        //engine.updateStatement(STATEMENT11,STATEMENT12,STATEMENT13,STATEMENT14,STATEMENT15); //1. Use-Case
        engine.updateStatement(STATEMENT16,STATEMENT17,STATEMENT18,STATEMENT19,STATEMENT20); //2. Use-Case
        //engine.updateStatement(STATEMENT21,STATEMENT22,STATEMENT23,STATEMENT24,STATEMENT25); //3. Use-Case
        //engine.updateStatement(STATEMENT100);
        new InputListener(engine.getRuntime());
    }
}
