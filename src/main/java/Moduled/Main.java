package Moduled;

/**
 * Created by Vincent Schmalor on 04/07/2017.
 */
public class Main {


    static final String DEFAULT_STATEMENT = "SELECT * from tblTweet()";
    static final String STATEMENT1 = "SELECT 'TRUMP' as NAME, count(*) as ANZAHL from tblTweet.win:time_batch(60sec) WHERE text LIKE '%#Trump%'";
    static final String STATEMENT2 = "SELECT 'MERKEL' as NAME, count(*) as ANZAHL from tblTweet.win:time_batch(60sec) WHERE text LIKE '%#Merkel%'";
    static final String STATEMENT3 = "SELECT 'PUTIN' as NAME, count(*) as ANZAHL from tblTweet.win:time_batch(60sec) WHERE text LIKE '%#Putin%'";
    static final String STATEMENT4 = "SELECT 'MACRON' as NAME, count(*) as ANZAHL from tblTweet.win:time_batch(60sec) WHERE text LIKE '%#Macron%'";
    static final String STATEMENT5 = "SELECT 'TRUDEAU' as NAME, count(*) as ANZAHL from tblTweet.win:time_batch(60sec) WHERE text LIKE '%#Trudeau%'";

    static final String STATEMENT6 = "SELECT 'TRUMP' as NAME, avg(followers) as AVGFollowersPerTweeter from tblTweet.win:time_batch(60 sec) WHERE text LIKE'%#Trump%'";
    static final String STATEMENT7 = "SELECT 'MERKEL' as NAME, avg(followers) as AVGFollowersPerTweeter from tblTweet.win:time_batch(60 sec) WHERE text LIKE'%#Merkel%'";
    static final String STATEMENT8 = "SELECT 'PUTIN' as NAME, avg(followers) as AVGFollowersPerTweeter from tblTweet.win:time_batch(60 sec) WHERE text LIKE'%#Putin%'";
    static final String STATEMENT9 = "SELECT 'MACRON' as NAME, avg(followers) as AVGFollowersPerTweeter from tblTweet.win:time_batch(60 sec) WHERE text LIKE'%#Macron%'";
    static final String STATEMENT10 = "SELECT 'TRUDEAU as NAME, avg(follewers) as AVGFollowersPerTweeter from tblTweet.win:time_batch(60 sec) WHERE text LIKE '%#Trudeau%'";

    //1. Use-Case
    static final String STATEMENT11 = "SELECT 'TRUMP' as NAME, username, followers FROM tblTweet.win:time_batch(60sec).ext:rank(followers, 1, followers desc) WHERE text LIKE '%#Trump%'";
    static final String STATEMENT12 = "SELECT 'MERKEL' as NAME, username, followers FROM tblTweet.win:time_batch(60sec).ext:rank(followers, 1, followers desc) WHERE text LIKE '%#Merkel%'";
    static final String STATEMENT13 = "SELECT 'PUTIN' as NAME, username, followers FROM tblTweet.win:time_batch(60sec).ext:rank(followers, 1, followers desc) WHERE text LIKE '%#Putin%'";
    static final String STATEMENT14 = "SELECT 'MACRON' as NAME, username, followers FROM tblTweet.win:time_batch(60sec).ext:rank(followers, 1, followers desc) WHERE text LIKE '%#Macron%'";
    static final String STATEMENT15 = "SELECT 'TRUDEAU as NAME, username, followers FROM tblTweet.win:time_batch(60sec).ext:rank(followers, 1, followers desc) WHERE text LIKE '%#Trudeau%'";

    //2. Use-Case
    static final String STATEMENT16 = "SELECT 'TRUMP' as NAME, username, text, sentiment, avg(sentiment) as AverageSentiment FROM tblTweet() WHERE text LIKE '%#Trump%'";
    static final String STATEMENT17 = "SELECT 'MERKEL' as NAME, username, text, sentiment, avg(sentiment) as AverageSentiment FROM tblTweet() WHERE text LIKE '%#Merkel%'";
    static final String STATEMENT18 = "SELECT 'PUTIN' as NAME, username, text, sentiment, avg(sentiment) as AverageSentiment FROM tblTweet() WHERE text LIKE '%#Putin%'";
    static final String STATEMENT19 = "SELECT 'MACRON' as NAME, username, text, sentiment, avg(sentiment) as AverageSentiment FROM tblTweet() WHERE text LIKE '%#Macron%'";
    static final String STATEMENT20 = "SELECT 'TRUDEAU' as NAME, username, text, sentiment, avg(sentiment) as AverageSentiment FROM tblTweet() WHERE text LIKE '%#Trudeau%'";

    //3. Use-Case
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
        //engine.updateStatement(STATEMENT1,STATEMENT2,STATEMENT3,STATEMENT4,STATEMENT5);
        //engine.updateStatement(STATEMENT6,STATEMENT7,STATEMENT8,STATEMENT9,STATEMENT10);
        //engine.updateStatement(STATEMENT11,STATEMENT12,STATEMENT13,STATEMENT14,STATEMENT15); //1. Use-Case
        //engine.updateStatement(STATEMENT16,STATEMENT17,STATEMENT18,STATEMENT19,STATEMENT20); //2. Use-Case
        //engine.updateStatement(STATEMENT21,STATEMENT22,STATEMENT23,STATEMENT24,STATEMENT25); //3. Use-Case
        engine.updateStatement(STATEMENT100);
        new InputListener(engine.getRuntime());
    }
}
