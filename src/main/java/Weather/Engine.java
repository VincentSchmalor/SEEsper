package Weather;

import com.espertech.esper.client.*;

/**
 * Created by Vincent Schmalor on 04/07/2017.
 * Engine making the magic happen
 */
public class Engine {
    private EPRuntime runtime;
    private EPAdministrator administrator;

    public Engine(){
        Configuration configuration = new Configuration();
        configuration.addEventType("tblWeather", tblWeather.class);
        EPServiceProvider serviceProvider = EPServiceProviderManager.getProvider("myEngine", configuration);
        runtime = serviceProvider.getEPRuntime();
        administrator = serviceProvider.getEPAdministrator();
    }

    /**
     * Add variable count of statements whith a standard Listener
     * @param statements multiple Statements to add
     */
    public void updateStatement(String... statements){
        Listener listener = new Listener();
        for(String statement:statements) {
            EPStatement epStatement = null;
            try {
                epStatement = administrator.createEPL(statement);
                epStatement.addListener(listener);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Invalid Statement: Switching to Standardstatement");
                epStatement = administrator.createEPL(MainWeather.DEFAULT_Statement);
                epStatement.addListener(listener);
            }
        }
    }

    //Getter, Setter
    public EPRuntime getRuntime() {
        return runtime;
    }
}
