import Handlers.EngineHandler;
import Handlers.StreamHandler;
import Handlers.TwitterHandler;

import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * Created by Vincent Schmalor on 22/06/2017.
 */
public class Main {
    /**
     * Ruft Handler auf, die im Hintergrund die Daten schubsen.
     * Hauptprogramm
     * @param args kann unbeachtet belassen werden
     */

    static final String STATEMENT =
            "select * " +
            "from tblTimeLine()"
            ;//+"where status LIKE '%#Ehefüralle%'";

    static final String CONSUMER_KEY = "41C4SELJGcqp7szwWHN4F93VO";
    static final String CONSUMER_SECRET = "vJh92ndV3Z0N0qOZQDnWlr077T2Drh8eGJoM1MbhS1qHex4k2x";

    public static void main(String[] args){
        TwitterHandler twitter = new TwitterHandler();
        EngineHandler engine = new EngineHandler();
        StreamHandler stream = new StreamHandler();
        twitter.init(CONSUMER_KEY,CONSUMER_SECRET);
        engine.init("tblTimeLine");
        System.out.println("Geben Sie hier ein Statement ein und betätigen Sie Enter oder lassen Sie die Zeile leer, " +
                "um die Timeline anzuzeigen:");
        String eingabe = "";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            eingabe = br.readLine();
        }catch (Exception e){}
        if (eingabe.equals("")){
            engine.updateStatement(STATEMENT);
        }else{
            engine.updateStatement(eingabe);
        }
        engine.updateStatement(STATEMENT);
        engine.addListener();
        stream.getOldTimeLine(engine.getRuntime(),twitter.getTwitter());
    }
}
