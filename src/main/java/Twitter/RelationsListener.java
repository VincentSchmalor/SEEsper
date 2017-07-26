package Twitter;

import com.espertech.esper.client.EPRuntime;
import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

import java.util.HashMap;

/**
 * Created by Vincent Schmalor on 20.07.2017.
 * Decides what to do if the statement picks an event
 * Specialized Listener for TwitterRelations Usecase
 */
public class RelationsListener implements UpdateListener{
    
    EPRuntime runtime;
    
    public RelationsListener(EPRuntime runtime){
        this.runtime = runtime;
    }
    
    public void update(EventBean[] eventBeans, EventBean[] eventBeans1){
        HashMap<String, Object> resultmap = (HashMap<String, Object>) eventBeans[0].getUnderlying();
        tblHashtags hashtag1 = new tblHashtags((String) resultmap.get("politiker"), (String) resultmap.get("hashtag1"));
        tblHashtags hashtag2 = new tblHashtags((String) resultmap.get("politiker"), (String) resultmap.get("hashtag2"));
        tblHashtags hashtag3 = new tblHashtags((String) resultmap.get("politiker"), (String) resultmap.get("hashtag3"));
        tblHashtags hashtag4 = new tblHashtags((String) resultmap.get("politiker"), (String) resultmap.get("hashtag4"));
        tblHashtags hashtag5 = new tblHashtags((String) resultmap.get("politiker"), (String) resultmap.get("hashtag5"));
        runtime.sendEvent(hashtag1);
        runtime.sendEvent(hashtag2);
        runtime.sendEvent(hashtag3);
        runtime.sendEvent(hashtag4);
        runtime.sendEvent(hashtag5);
    }
}
