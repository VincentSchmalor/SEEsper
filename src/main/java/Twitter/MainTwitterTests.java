package Twitter;

/**
 * Created by Vincent Schmalor on 04/07/2017.
 */
public class MainTwitterTests {

    //3. Use-Case Bullshit
    static final String STATEMENT1 = "SELECT 'TRUMP' as NAME, username, text, followers, count(followers) as NumberTweeter FROM tblTweet() WHERE text LIKE '%#Trump%'";
    static final String STATEMENT2 = "SELECT 'MERKEL' as NAME, username, text, followers, count(followers) as NNumberTweeter FROM tblTweet() WHERE text LIKE '%#Merkel%'";
    static final String STATEMENT3 = "SELECT 'PUTIN' as NAME, username, text, followers, count(followers) as NumberTweeter FROM tblTweet() WHERE text LIKE '%#Putin%'";
    static final String STATEMENT4 = "SELECT 'MACRON' as NAME, username, text, followers, count(followers) as NumberTweeter FROM tblTweet() WHERE text LIKE '%#Macron%'";
    static final String STATEMENT5 = "SELECT 'TRUDEAU' as NAME, username, text, followers, count(followers) as NumberTweeter FROM tblTweet() WHERE text LIKE '%#Trudeau%'";

    //Hashtagstest
    static final String STATEMENT6 = "SELECT hashtag1 FROM tblTweet";

    /**
     * Mainactivity
     * @param args non required
     */
    public static void main(String[] args){
        Engine engine = new Engine();
        //engine.updateStatement(STATEMENT1,STATEMENT2,STATEMENT3,STATEMENT4,STATEMENT5); //3. Use-Case
        engine.updateStatement("SELECT hashtag1 FROM tblTweet");
        new InputListener(engine.getRuntime());
    }
}
