package Handlers;

import Tables.tblTimeLine;
import com.espertech.esper.client.EPRuntime;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import java.util.List;

/**
 * Erzeugt einen Datenstream, der an die Engine übergeben wird
 * Created by Vincent Schmalor on 22/06/2017.
 */
public class StreamHandler {

    /**
     * Lädt die Timeline von Twitter in die Engine
     * @param runtime
     * @param twitter
     * @throws Exception
     */
    public void getTimeline(EPRuntime runtime, Twitter twitter){
        try {
        List<Status> timeline;
            timeline = twitter.getHomeTimeline();
        for (twitter4j.Status status : timeline) {
            tblTimeLine timeLine = new tblTimeLine(
                    status.getCreatedAt(),
                    status.getUser().getName(),
                    status.getText(),
                    status.getUser().getFollowersCount());
            runtime.sendEvent(timeLine);
        }
        }catch (TwitterException e){
            System.err.println("Timeline konnte nicht geladen werden. " +
                    "Bitte starten Sie das Programm neu und versuchen Sie es erneut.");
        }
    }
}
