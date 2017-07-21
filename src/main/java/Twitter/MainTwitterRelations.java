package Twitter;

import com.espertech.esper.client.EPStatement;

import java.util.ArrayList;

/**
 * Created by vince on 20.07.2017.
 */
public class MainTwitterRelations {

    final static String STATEMENT10 = "SELECT 'TRUMP' as politiker, hashtag1, hashtag2, hashtag3, hashtag4, hashtag5 FROM tblTweet WHERE text LIKE '%#Trump%'";
    final static String STATEMENT11 = "SELECT 'MERKEL' as politiker, hashtag1, hashtag2, hashtag3, hashtag4, hashtag5 FROM tblTweet WHERE text LIKE '%#Merkel%'";
    final static String STATEMENT12 = "SELECT 'MACRON' as politiker, hashtag1, hashtag2, hashtag3, hashtag4, hashtag5 FROM tblTweet WHERE text LIKE '%#Marcon%'";
    final static String STATEMENT13 = "SELECT 'TRUDEAU' as politiker, hashtag1, hashtag2, hashtag3, hashtag4, hashtag5 FROM tblTweet WHERE text LIKE '%#Trudeau%'";
    final static String STATEMENT14 = "SELECT 'PUTIN' as politiker, hashtag1, hashtag2, hashtag3, hashtag4, hashtag5 FROM tblTweet WHERE text LIKE '%#Putin%'";
    final static String STATEMENT1 = "SELECT MAX(politician) AS Politiker, hashtag, count(hashtag) AS Anzahl FROM tblHashtags " +
            "WHERE hashtag IS NOT NULL " +
            "AND hashtag != 'Trump' " +
            "AND hashtag != 'trump' " +
            "AND hashtag != 'Merkel' " +
            "AND hashtag != 'merkel' " +
            "AND hashtag != 'Macron' " +
            "AND hashtag != 'macron' " +
            "AND hashtag != 'Trudeau' " +
            "AND hashtag != 'trudeau' " +
            "AND hashtag != 'Putin' " +
            "AND hashtag != 'putin' " +
            "GROUP BY rollup(hashtag) " +
            "HAVING count(hashtag) >3" +
            "AND hashtag IS NOT NULL";

    public static void main(String[] args){
        Engine engine = new Engine();
        ArrayList<EPStatement> epStatements;
        epStatements = engine.updateCustomStatement(STATEMENT1,STATEMENT10,STATEMENT11,STATEMENT12,STATEMENT13,STATEMENT14);
        RelationsListener relationsListener = new RelationsListener(engine.getRuntime());
        epStatements.get(0).addListener(new Listener());
        epStatements.get(1).addListener(relationsListener);
        epStatements.get(2).addListener(relationsListener);
        epStatements.get(3).addListener(relationsListener);
        epStatements.get(4).addListener(relationsListener);
        epStatements.get(5).addListener(relationsListener);
        new InputListener(engine.getRuntime());
    }
}
