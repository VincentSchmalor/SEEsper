package Moduled;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

/**
 * Created by Vincent Schmalor on 04/07/2017.
 */
public class Listener implements UpdateListener {
    /**
     * Methode, die die folgende Vorgehensweise festlegt, wenn ein Event eintrifft
     *
     * @param newData wird von der Engine gesetzt
     * @param oldData wird von der Engine gesetzt
     */
    public void update(EventBean[] newData, EventBean[] oldData) {
        System.out.println("Event received: " + newData[0].getUnderlying());
    }
}