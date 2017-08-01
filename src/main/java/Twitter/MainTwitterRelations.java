package Twitter;

import com.espertech.esper.client.EPStatement;

import java.util.ArrayList;

/**
 * Created by Vincent Schmalor on 20.07.2017.
 * Main-Method to allocate most important parts
 */
public class MainTwitterRelations{
    
    //Select the name of the politician and all hashtags used in the post
    private final static String useCaseHelper = "as politiker, hashtag1, hashtag2, hashtag3, hashtag4, hashtag5 FROM tblTweet WHERE text LIKE ";
    private final static String STATEMENT10 = "SELECT 'TRUMP' " + useCaseHelper + "'%#Trump%'";
    private final static String STATEMENT11 = "SELECT 'MERKEL' " + useCaseHelper + "'%#Merkel%'";
    private final static String STATEMENT12 = "SELECT 'MACRON' " + useCaseHelper + "'%#Marcon%'";
    private final static String STATEMENT13 = "SELECT 'TRUDEAU' " + useCaseHelper + "'%#Trudeau%'";
    private final static String STATEMENT14 = "SELECT 'PUTIN' " + useCaseHelper + "'%#Putin%'";
    //Select the name of the politician, the hashtag and the count of the appearences
    private final static String STATEMENT1 = "SELECT MAX(politician) AS Politiker, hashtag, count(hashtag) AS Anzahl FROM tblHashtags " +
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
        //Add Listeners due to absence of this part in the updateCustomStatement method
        RelationsListener relationsListener = new RelationsListener(engine.getRuntime());
        epStatements.get(0).addListener(new Listener());
        for(int i = 1; i < epStatements.size(); i++) epStatements.get(i).addListener(relationsListener);
        new InputListener(engine.getRuntime());
        System.out.println("Show the most popular hashtags used in Relation with each politician having more than 3 mentions");
    }
}
