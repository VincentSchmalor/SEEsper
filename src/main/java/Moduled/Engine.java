package Moduled;

import com.espertech.esper.client.*;

/**
 * Created by Vincent Schmalor on 04/07/2017.
 */
public class Engine {
    private EPRuntime runtime;
    private EPAdministrator administrator;
    private EPStatement statement = null;

    /**
     * Konfiguriert die Engine und fügt für jedes Event, das eintreten kann, ein Eventtype hinzu
     */
    public void init(String className){
        Configuration configuration = new Configuration();
        configuration.addEventType(className, className.getClass());
        EPServiceProvider serviceProvider = EPServiceProviderManager.getProvider("myEngine", configuration);
        runtime = serviceProvider.getEPRuntime();
        administrator = serviceProvider.getEPAdministrator();
    }

    /**
     * Setzt das Statement, mit dem die eintreffenden Events analysiert werden
     */
    public void updateStatement(String eingabe){
        statement = administrator.createEPL(eingabe);
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
