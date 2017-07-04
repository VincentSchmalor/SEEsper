package Moduled;

import com.espertech.esper.client.*;

/**
 * Created by Vincent Schmalor on 04/07/2017.
 */
public class Engine {
    private EPRuntime runtime;
    private EPAdministrator administrator;

    /**
     * runnable instance of Engine
     */
    public Engine(){
        Configuration configuration = new Configuration();
        configuration.addEventType("tblTweet", tblTweet.class);
        EPServiceProvider serviceProvider = EPServiceProviderManager.getProvider("myEngine", configuration);
        runtime = serviceProvider.getEPRuntime();
        administrator = serviceProvider.getEPAdministrator();
    }

    /**
     * Adjust the selecting STATEMENT1
     */
    public void updateStatement1(String... statements){
        for(String statement:statements) {
            EPStatement epStatement = null;
            try {
                epStatement = administrator.createEPL(statement);
                epStatement.addListener(new Listener());
            } catch (Exception e) {
                System.out.println("Invalid Statement: Switching to Standardstatement");
                epStatement = administrator.createEPL(Main.DEFAULT_STATEMENT);
                epStatement.addListener(new Listener());
            }
        }
    }

    //Getter, Setter
    public EPRuntime getRuntime() {
        return runtime;
    }
}
