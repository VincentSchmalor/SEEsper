package Twitter;

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
                epStatement = administrator.createEPL(MainTwitter.DEFAULT_STATEMENT);
                epStatement.addListener(listener);
            }
        }
    }

    //Getter, Setter
    public EPRuntime getRuntime() {
        return runtime;
    }
}
