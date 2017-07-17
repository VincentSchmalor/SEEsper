package Twitter;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

/**
 * Created by Vincent Schmalor on 04/07/2017.
 */
public class Listener implements UpdateListener {

    /**
     * Autoexecuted Statement run everytime an Event occurs
     * Manages thes Consequences of an Event
     * @param newData
     * @param oldData
     */
    public void update(EventBean[] newData, EventBean[] oldData) {
        System.out.println("Event received: " + newData[0].getUnderlying());
    }
}