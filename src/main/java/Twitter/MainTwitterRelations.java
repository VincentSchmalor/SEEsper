package Twitter;

import com.espertech.esper.client.EPStatement;

/**
 * Created by vince on 20.07.2017.
 */
public class MainTwitterRelations {

    final static String STATEMENT1 = "SELECT hashtag1, count(hashtag1) AS Anzahl FROM tblTweet where text LIKE '%#Trump'GROUP BY rollup(hashtag1)";

    public static void main(String[] args){
        Engine engine = new Engine();
        engine.updateStatement(STATEMENT1);
        new InputListener(engine.getRuntime());
    }
}
