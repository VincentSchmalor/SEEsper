package Twitter;

import com.espertech.esper.client.EPRuntime;
import com.google.gson.Gson;

/**
 * Created by Vincent Schmalor on 04/07/2017.
 */
public class Translator {

    private EPRuntime runtime;

    /**
     * Prepare Generator
     * @param runtime
     */
    public Translator(EPRuntime runtime) {
        this.runtime = runtime;
    }

    /**
     * Translate json to usable Object and send it to the engine.
     * @param input json to convert
     */
    public void translate(String input){
        Gson gson = new Gson();
        tblTweet tweet = gson.fromJson(input,tblTweet.class);
        runtime.sendEvent(tweet);
    }
}
