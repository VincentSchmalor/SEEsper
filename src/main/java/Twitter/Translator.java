package Twitter;

import com.espertech.esper.client.EPRuntime;
import com.google.gson.Gson;

/**
 * Created by Vincent Schmalor on 04/07/2017.
 * Translates JSON-Strings in POJOs with the "tbl[...]" Templates and pushes them into the engine
 */
public class Translator{
    
    Gson gson;
    private EPRuntime runtime;
    
    public Translator(EPRuntime runtime){
        this.runtime = runtime;
        gson = new Gson();
    }
    
    /**
     * Translate JSON-String to usable POJO and send it to the engine.
     *
     * @param input json to convert
     */
    public void translateAllInOne(String input){
        tblTweet tweet = gson.fromJson(input, tblTweet.class);
        runtime.sendEvent(tweet);
    }
    
    public void translateNFTweet(String input){
        tblNFTweet nfTweet = gson.fromJson(input, tblNFTweet.class);
        runtime.sendEvent(nfTweet);
    }
    
    public void translateNFUser(String input){
        tblNFUser nfUser = gson.fromJson(input, tblNFUser.class);
        runtime.sendEvent(nfUser);
    }
    
    public void translateNFHashtag(String input){
        tblNFHashtag nfHashtag = gson.fromJson(input, tblNFHashtag.class);
        runtime.sendEvent(nfHashtag);
    }
}
