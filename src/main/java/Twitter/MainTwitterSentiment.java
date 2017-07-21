package Twitter;

/**
 * Created by Vincent Schmalor on 18/07/2017.
 * Main-Method to allocate most important parts
 */
public class MainTwitterSentiment {

    //Show average Sentiment of the last 10 incoming events for each politician
    static final String useCase1Helper2 = "as NAME, avg(sentiment) as AverageSentiment FROM tblTweet.win:length_batch(10) WHERE sentiment IS NOT NULL AND text LIKE";
    static final String STATEMENT16 = "SELECT 'TRUMP' " + useCase1Helper2 + " '%#Trump%'";
    static final String STATEMENT17 = "SELECT 'MERKEL' " + useCase1Helper2 + " '%#Merkel%'";
    static final String STATEMENT18 = "SELECT 'PUTIN' " + useCase1Helper2 + " '%#Putin%'";
    static final String STATEMENT19 = "SELECT 'MACRON' " + useCase1Helper2 + " '%#Macron%'";
    static final String STATEMENT20 = "SELECT 'TRUDEAU' " + useCase1Helper2 + " '%#Trudeau%'";

    /**
     * Mainactivity
     * @param args non required
     */
    public static void main(String[] args){
        Engine engine = new Engine();
        engine.updateStatement(STATEMENT16,STATEMENT17,STATEMENT18,STATEMENT19,STATEMENT20);
        new InputListener(engine.getRuntime());
    }
}
