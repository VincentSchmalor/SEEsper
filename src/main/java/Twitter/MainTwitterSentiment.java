package Twitter;

/**
 * Created by Vincent Schmalor on 18/07/2017.
 * Main-Method to allocate most important parts
 */
public class MainTwitterSentiment{
    
    //Show the average Sentiment of the last 10 incoming events for each politician
    private static final String useCase1Helper2 = "SELECT hashtag.hashtag as NAME, avg(tweet.sentiment) as AverageSentiment, avg(user.followers) as AverageFollowers FROM tblNFTweet.win:length_batch(10) AS tweet " +
            "INNER JOIN tblNFHashtag.std:unique(tweetID) AS hashtag ON tweet.tweetID = hashtag.tweetID " +
            "INNER JOIN tblNFUser.win:length_batch(10) AS user ON tweet.userID = user.userID " +
            "WHERE sentiment IS NOT NULL AND hashtag.hashtag =";
    private static final String STATEMENT16 = useCase1Helper2 + " 'Trump'";
    private static final String STATEMENT17 = useCase1Helper2 + " 'Merkel'";
    private static final String STATEMENT18 = useCase1Helper2 + " 'Putin'";
    private static final String STATEMENT19 = useCase1Helper2 + " 'Macron'";
    private static final String STATEMENT20 = useCase1Helper2 + " 'Trudeau'";
    
    /**
     * Mainactivity
     *
     * @param args non required
     */
    public static void main(String[] args){
        Engine engine = new Engine();
        engine.updateStatement(STATEMENT16, STATEMENT17, STATEMENT18, STATEMENT19, STATEMENT20);
        new InputListener(engine.getRuntime());
        System.out.println("Show the average Sentiment of the last 10 incoming events for each politician");
    }
}
