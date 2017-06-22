package Listeners;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

/**
 * Created by Vincent Schmalor on 22/06/2017.
 */
public class Listener implements UpdateListener {
    public void update(EventBean[] newData, EventBean[] oldData) {
        System.out.println("Event received: " + newData[0].getUnderlying());
    }
}
