package Mashinery;

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
        configuration.addEventType("tblWindSpeed", tblWindSpeed.class);
        EPServiceProvider serviceProvider = EPServiceProviderManager.getProvider("myEngine", configuration);
        runtime = serviceProvider.getEPRuntime();
        administrator = serviceProvider.getEPAdministrator();
    }

    /**
     * Add a Statement with a standard Listener
     */
    public void updateStatement(){
        //Use same Listener for every Statement so Reaction is equal for every Statement and least load is opposed to the PC
        Listener listener = new Listener();
        //Add dynamically adjusted Statements for each Weatherstation
        for(int i=0;i<300;i++) {
            EPStatement epStatement = null;
            try {
                epStatement = administrator.createEPL( MainWindSpeed.PART1 + i + MainWindSpeed.PART2);
                epStatement.addListener(listener);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Invalid Statement: Switching to Standardstatement");
                epStatement = administrator.createEPL(MainWindSpeed.DEFAULT_STATEMENT);
                epStatement.addListener(listener);
            }
        }
    }

    //Getter, Setter
    public EPRuntime getRuntime() {
        return runtime;
    }
}
