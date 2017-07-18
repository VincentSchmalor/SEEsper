package Mashinery;

import com.espertech.esper.client.*;

import java.util.Date;

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
        configuration.addEventType("tblWindSpeed", tblWindSpeed.class);
        EPServiceProvider serviceProvider = EPServiceProviderManager.getProvider("myEngine", configuration);
        runtime = serviceProvider.getEPRuntime();
        administrator = serviceProvider.getEPAdministrator();
    }

    /**
     * Adjust the selecting STATEMENT1
     */
    public void updateStatement(){
        Listener listener = new Listener();
        for(int i=0;i<300;i++) {
            EPStatement epStatement = null;
            try {
                //Alarmiere, wenn in einer Region die Durchschnittswerte der letzten 3 Messungen 35km/h übersteigen
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
