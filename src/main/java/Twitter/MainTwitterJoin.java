package Twitter;

/**
 * Created by Vincent Schmalor on 18/07/2017.
 * Main-Method to allocate most important parts
 */
public class MainTwitterJoin{
    
    //
    static final String STATEMENT1 = "SELECT tweet.tweetID, user.userID, tweet.userID, user.username, tweet.text " + "FROM tblNFTweet.std:unique(tweetID) AS tweet " + "INNER JOIN tblNFUser.std:unique(userID) AS user ON tblNFUser.userID = tblNFTweet.userID";
    
    /**
     * Mainactivity
     *
     * @param args non required
     */
    public static void main(String[] args){
        Engine engine = new Engine();
        engine.updateStatement(STATEMENT1);
        new InputListener(engine.getRuntime());
    }
}
