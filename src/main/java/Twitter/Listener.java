package Twitter;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

/**
 * Created by Vincent Schmalor on 04/07/2017.
 * Decides what to do if the statement picks an event
 */
public class Listener implements UpdateListener{
    
    /**
     * Autoexecuted Statement run everytime an Event occurs
     * Manages thes Consequences of an Event
     *
     * @param newData non required
     * @param oldData non required
     */
    public void update(EventBean[] newData, EventBean[] oldData){
        System.out.println("Event received: " + newData[0].getUnderlying());
    }
}