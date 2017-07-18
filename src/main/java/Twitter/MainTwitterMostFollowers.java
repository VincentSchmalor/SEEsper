package Twitter;

/**
 * Created by Vincent Schmalor on 18/07/2017.
 */
public class MainTwitterMostFollowers {

    //1. Use-Case Selektiere den Tweeter mit den meisten Followern
    static final String useCase1Helper1 = "as NAME, username, followers FROM tblTweet.win:time_batch(60sec).ext:rank(followers, 1, followers desc) WHERE text LIKE";
    static final String STATEMENT11 = "SELECT 'TRUMP' " + useCase1Helper1 + " '%#Trump%'";
    static final String STATEMENT12 = "SELECT 'MERKEL' " + useCase1Helper1 + " '%#Merkel%'";
    static final String STATEMENT13 = "SELECT 'PUTIN' " + useCase1Helper1 + " '%#Putin%'";
    static final String STATEMENT14 = "SELECT 'MACRON' " + useCase1Helper1 + " '%#Macron%'";
    static final String STATEMENT15 = "SELECT 'TRUDEAU' " + useCase1Helper1 + " '%#Trudeau%'";

    public static void main(String[] args){
        Engine engine = new Engine();
        engine.updateStatement(STATEMENT11,STATEMENT12,STATEMENT13,STATEMENT14,STATEMENT15); //1. Use-Case
        new InputListener(engine.getRuntime());
    }
}
