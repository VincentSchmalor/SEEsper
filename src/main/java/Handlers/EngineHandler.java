package Handlers;

import Tables.*;
import Listeners.Listener;
import com.espertech.esper.client.*;

/**
 * Created by Vincent Schmalor on 22/06/2017.
 */
public class EngineHandler {

    private Configuration cepConfig;
    private EPServiceProvider cep;
    private EPRuntime cepRT;
    private EPAdministrator cepAdm;
    private EPStatement cepStatement = null;

    public EngineHandler() {

    }

    public void init(String... classNames){
        cepConfig = new Configuration();
        for(String classname : classNames) {
            cepConfig.addEventType(classname, "Tables." + classname);
        }
        cep = EPServiceProviderManager.getProvider("myCEPEngine", cepConfig);
        cepRT = cep.getEPRuntime();
        cepAdm = cep.getEPAdministrator();
    }

    public void updateStatement(String update){
        cepStatement = cepAdm.createEPL(update);
    }

    public void addListener(){
        cepStatement.addListener(new Listener());
    }

    public EPRuntime getCepRT() {
        return cepRT;
    }
}
