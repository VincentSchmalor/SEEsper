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
        int iteration = 1;
        for(int i = 1;i<=300;i++){
            tblWindSpeed windSpeed = new tblWindSpeed(iteration,System.currentTimeMillis(),i,abs(rand.nextGaussian()*20));
            runtime.sendEvent(windSpeed);
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(i==300){
                i=1;
                iteration++;
            }
        }
    }
}
