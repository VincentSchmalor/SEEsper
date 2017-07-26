package Twitter;

import com.espertech.esper.client.EPStatement;

import java.util.ArrayList;

/**
 * Created by Vincent Schmalor on 20.07.2017.
 * Main-Method to allocate most important parts
 */
public class MainTwitterRelations{
    
    //Select the name of the politician and all hashtags used in the post
    final static String STATEMENT10 = "SELECT 'TRUMP' as politiker, hashtag1, hashtag2, hashtag3, hashtag4, hashtag5 FROM tblTweet WHERE text LIKE '%#Trump%'";
    final static String STATEMENT11 = "SELECT 'MERKEL' as politiker, hashtag1, hashtag2, hashtag3, hashtag4, hashtag5 FROM tblTweet WHERE text LIKE '%#Merkel%'";
    final static String STATEMENT12 = "SELECT 'MACRON' as politiker, hashtag1, hashtag2, hashtag3, hashtag4, hashtag5 FROM tblTweet WHERE text LIKE '%#Marcon%'";
    final static String STATEMENT13 = "SELECT 'TRUDEAU' as politiker, hashtag1, hashtag2, hashtag3, hashtag4, hashtag5 FROM tblTweet WHERE text LIKE '%#Trudeau%'";
    final static String STATEMENT14 = "SELECT 'PUTIN' as politiker, hashtag1, hashtag2, hashtag3, hashtag4, hashtag5 FROM tblTweet WHERE text LIKE '%#Putin%'";
    //Select the name of the politician, the hashtag and the count of the appearences
    final static String STATEMENT1 = "SELECT MAX(politician) AS Politiker, hashtag, count(hashtag) AS Anzahl FROM tblHashtags " +
            //filtering
            "WHERE hashtag IS NOT NULL " + "AND hashtag != 'Trump' " + "AND hashtag != 'trump' " + "AND hashtag != 'Merkel' " + "AND hashtag != 'merkel' " + "AND hashtag != 'Macron' " + "AND hashtag != 'macron' " + "AND hashtag != 'Trudeau' " + "AND hashtag != 'trudeau' " + "AND hashtag != 'Putin' " + "AND hashtag != 'putin' " + "GROUP BY rollup(hashtag) " + "HAVING count(hashtag) >3" + "AND hashtag IS NOT NULL";
    
    /**
     * Mainactivity
     *
     * @param args non required
     */
    public static void main(String[] args){
        Engine engine = new Engine();
        ArrayList<EPStatement> epStatements;
        epStatements = engine.updateCustomStatement(STATEMENT1, STATEMENT10, STATEMENT11, STATEMENT12, STATEMENT13, STATEMENT14);
        //Add Listeners due to absence of this part in the updateCustomStatement
        RelationsListener relationsListener = new RelationsListener(engine.getRuntime());
        epStatements.get(0).addListener(new Listener());
        for(int i = 1; i < epStatements.size(); i++) epStatements.get(i).addListener(relationsListener);
        new InputListener(engine.getRuntime());
    }
}
