package Twitter;

import com.espertech.esper.client.EPStatement;

import java.util.ArrayList;

/**
 * Created by vince on 20.07.2017.
 */
public class MainTwitterRelations {

    final static String STATEMENT1 = "SELECT 'Trump' as politiker, hashtag1, hashtag2, hashtag3, hashtag4, hashtag5 FROM tblTweet WHERE text LIKE '%#Trump%'";
    final static String STATEMENT2 = "SELECT hashtag, count(hashtag) FROM tblHashtags WHERE hashtag IS NOT NULL AND hashtag != 'Trump' AND hashtag != 'trump' GROUP BY rollup(hashtag)";

    public static void main(String[] args){
        Engine engine = new Engine();
        ArrayList<EPStatement> epStatements;
        epStatements = engine.updateCustomStatement(STATEMENT1,STATEMENT2);
        epStatements.get(0).addListener(new RelationsListener(engine.getRuntime()));
        epStatements.get(1).addListener(new Listener());
        new InputListener(engine.getRuntime());
    }
}
