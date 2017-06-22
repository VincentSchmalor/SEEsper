import Handlers.EngineHandler;
import Handlers.StreamHandler;
import Handlers.TwitterHandler;
import Tables.tblTimeLine;


/**
 * Created by Vincent Schmalor on 22/06/2017.
 */
public class Main {
    /**
     * Hauptprogramm
     * @param args kann unbeachtet belassen werden
     */
    public static void main(String[] args) throws Exception{
        TwitterHandler th = new TwitterHandler();
        EngineHandler eh = new EngineHandler();
        StreamHandler sh = new StreamHandler();
        th.init();
        eh.init("tblTimeLine");
        eh.updateStatement("select * " +
                "from tblTimeLine()");
        eh.addListener();
        sh.getTimeline(eh.getCepRT(),th.getTwitter());
    }
}
