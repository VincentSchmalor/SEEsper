package Deprecated.Handlers;

import Deprecated.Listeners.Listener;
import Deprecated.Main.Main;
import com.espertech.esper.client.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Erstellt die Laufzeitumgebung und konfigueriert diese
 * Created by Vincent Schmalor on 22/06/2017.
 */
public class EngineHandler{
    
    private EPRuntime runtime;
    private EPAdministrator administrator;
    private EPStatement statement = null;
    
    /**
     * Konfiguriert die Engine und fügt für jedes Event, das eintreten kann, ein Eventtype hinzu
     */
    public void init(String... classNames){
        Configuration configuration = new Configuration();
        for(String classname : classNames){
            configuration.addEventType(classname, "Deprecated.Tables." + classname);
        }
        EPServiceProvider serviceProvider = EPServiceProviderManager.getProvider("myEngine", configuration);
        runtime = serviceProvider.getEPRuntime();
        administrator = serviceProvider.getEPAdministrator();
    }
    
    /**
     * Setzt das Statement, mit dem die eintreffenden Events analysiert werden
     */
    public void updateStatement(){
        System.out.println("Geben Sie hier ein Statement ein und betätigen Sie Enter oder lassen Sie die Zeile leer, " + "um die Timeline anzuzeigen:");
        String eingabe = "";
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            eingabe = br.readLine();
        }catch(Exception e){
            e.printStackTrace();
        }
        if(eingabe.equals("")){
            statement = administrator.createEPL(Main.STATEMENT);
        }else{
            statement = administrator.createEPL(eingabe);
        }
        
    }
    
    /**
     * Fügt einen Listener hinzu, der die durch das Statement erzeugten Daten auffängt
     */
    public void addListener(){
        statement.addListener(new Listener());
    }
    
    //Getter, Setter
    public EPRuntime getRuntime(){
        return runtime;
    }
}
