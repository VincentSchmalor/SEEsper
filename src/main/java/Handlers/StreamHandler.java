package Handlers;

import Tables.tblTimeLine;
import com.espertech.esper.client.EPRuntime;
import twitter4j.Status;
import twitter4j.Twitter;

import java.util.List;

/**
 * Created by Vincent Schmalor on 22/06/2017.
 */
public class StreamHandler {

    public void getTimeline(EPRuntime cepRT, Twitter twitter)throws Exception{
        List<Status> statuses = twitter.getHomeTimeline();
        for (twitter4j.Status status : statuses) {
            tblTimeLine timeLine = new tblTimeLine(
                    status.getCreatedAt(), status.getUser().getName(), status.getText(), status.getUser().getFollowersCount());
            cepRT.sendEvent(timeLine);
        }
    }
}
