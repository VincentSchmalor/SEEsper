package Handlers;

import Tables.tblTimeLine;
import com.espertech.esper.client.EPRuntime;
import com.google.gson.Gson;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Erzeugt einen Datenstream, der an die Engine übergeben wird
 * Created by Vincent Schmalor on 22/06/2017.
 */
public class StreamHandler {
    OfflineHandler offline = new OfflineHandler();


    /**
     * Lädt die Timeline von Twitter in die Engine
     * @param runtime
     * @param twitter
     * @throws Exception
     */
    public void getRealTimeLine(EPRuntime runtime, Twitter twitter){
        try {
            List<Status> timeline;
            timeline = twitter.getHomeTimeline();
            offline.startFile();
            for (twitter4j.Status status : timeline) {
                tblTimeLine timeLine = new tblTimeLine(
                        status.getCreatedAt(),
                        status.getUser().getName(),
                        status.getText(),
                        status.getUser().getFollowersCount());
                offline.speichern(timeLine);
                runtime.sendEvent(timeLine);
            }
            //offline.appendEnd();
        }catch (TwitterException e){
            System.err.println("Timeline konnte nicht geladen werden. " +
                    "Bitte starten Sie das Programm neu und versuchen Sie es erneut.");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void getOldTimeLine(EPRuntime runtime){
        for(tblTimeLine status : offline.lesen("abc"))
        runtime.sendEvent(status);
    }
}
