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
     * Adjust the selecting STATEMENT
     */
    public void updateStatement(String statement){
        try {
            this.statement = administrator.createEPL(statement);
        }catch (Exception e){
            System.out.println("Invalid Statement: Switching to Standardstatement");
            this.statement = administrator.createEPL(Main.DEFAULT_STATEMENT);
        }
    }

    /**
     * Add Listener to Statement
     */
    public void addListener(){
        statement.addListener(new Listener());
    }

    //Getter, Setter
    public EPRuntime getRuntime() {
        return runtime;
    }
}
