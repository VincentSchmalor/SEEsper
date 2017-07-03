package Moduled;

import com.espertech.esper.client.EPRuntime;
import com.google.gson.Gson;

/**
 * Created by Vincent Schmalor on 04/07/2017.
 */
public class Translator {

    EPRuntime runtime;


    public Translator(EPRuntime runtime){
        this.runtime = runtime;
    }

    public void translate(String input){
        Gson gson = new Gson();
        tblTweet tweet = gson.fromJson(input,tblTweet.class);
        runtime.sendEvent(tweet);
    }
}
