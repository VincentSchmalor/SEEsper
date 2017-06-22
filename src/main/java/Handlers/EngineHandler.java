package Handlers;

import Listeners.Listener;
import com.espertech.esper.client.*;

/**
 * Erstellt die Laufzeitumgebung und konfigueriert diese
 * Created by Vincent Schmalor on 22/06/2017.
 */
public class EngineHandler {

    //Deklaration
    private Configuration configuration;
    private EPServiceProvider serviceProvider;
    private EPRuntime runtime;
    private EPAdministrator administrator;
    private EPStatement statement = null;

    /**
     * Konfiguriert die Engine und fügt für jedes Event, das eintreten kann, ein Eventtype hinzu
     */
    public void init(String... classNames){
        configuration = new Configuration();
        for(String classname : classNames) {
            configuration.addEventType(classname, "Tables." + classname);
        }
        serviceProvider = EPServiceProviderManager.getProvider("myEngine", configuration);
        runtime = serviceProvider.getEPRuntime();
        administrator = serviceProvider.getEPAdministrator();
    }

    /**
     * Setzt das Statement, mit dem die eintreffenden Events analysiert werden
     * @param update Statement
     */
    public void updateStatement(String update){
        statement = administrator.createEPL(update);
    }

    /**
     * Fügt einen Listener hinzu, der die durch das Statement erzeugten Daten auffängt
     */
    public void addListener(){
        statement.addListener(new Listener());
    }

    //Getter, Setter
    public EPRuntime getRuntime() {
        return runtime;
    }
}
