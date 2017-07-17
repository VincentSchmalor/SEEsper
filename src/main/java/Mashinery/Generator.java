package Mashinery;

import com.espertech.esper.client.EPRuntime;
import com.google.gson.Gson;

import java.util.Random;

import static java.lang.Math.abs;

/**
 * Created by Vincent Schmalor on 04/07/2017.
 */
public class Generator {

    private EPRuntime runtime;

    /**
     * Prepare Generator
     * @param runtime
     */
    public Generator(EPRuntime runtime) {
        this.runtime = runtime;
    }

    /**
     * Gernerate random input Stream
     */
    public void generate(){
        Random rand = new Random();
        while(true){
            if(rand.nextInt(10000000)==2){
                tblWindSpeed windSpeed = new tblWindSpeed(System.currentTimeMillis(),rand.nextInt(99999)+100000,abs(rand.nextGaussian()*15+20));
                runtime.sendEvent(windSpeed);
            }
        }
    }
}
