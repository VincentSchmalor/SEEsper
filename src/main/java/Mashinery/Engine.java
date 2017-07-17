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
        for(int i=0;i<300;i++) {
            EPStatement epStatement = null;
            try {
                //Alarmiere, wenn in einer Region die Durchschnittswerte der letzten 3 Messungen 35km/h übersteigen
                epStatement = administrator.createEPL("SELECT iteration, region, AVG(windSpeed) AS Average_WindSpeed FROM tblWindSpeed.win:length(1200) WHERE region = " + i + " having AVG(windSpeed) >35");
                epStatement.addListener(new Listener());
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Invalid Statement: Switching to Standardstatement");
                epStatement = administrator.createEPL(MainWindSpeed.DEFAULT_STATEMENT);
                epStatement.addListener(new Listener());
            }
        }
    }

    //Getter, Setter
    public EPRuntime getRuntime() {
        return runtime;
    }
}
