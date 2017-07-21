package Twitter;

import com.espertech.esper.client.EPRuntime;
import com.google.gson.Gson;

/**
 * Created by Vincent Schmalor on 04/07/2017.
 * Translates JSON-Strings in POJOs with the "tbl[...]" Templates and pushes them into the engine
 */
public class Translator {

    private EPRuntime runtime;
    Gson gson;

    public Translator(EPRuntime runtime) {
        this.runtime = runtime;
        gson = new Gson();
    }

    /**
     * Translate JSON-String to usable POJO and send it to the engine.
     * @param input json to convert
     */
    public void translate(String input){
        tblTweet tweet = gson.fromJson(input,tblTweet.class);
        runtime.sendEvent(tweet);
    }
}
