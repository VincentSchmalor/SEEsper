import Handlers.EngineHandler;
import Handlers.StreamHandler;
import Handlers.TwitterHandler;


/**
 * Created by Vincent Schmalor on 22/06/2017.
 */
public class Main {
    /**
     * Ruft Handler auf, die im Hintergrund die Daten schubsen.
     * Hauptprogramm
     * @param args kann unbeachtet belassen werden
     */
    public static void main(String[] args){
        TwitterHandler th = new TwitterHandler();
        EngineHandler eh = new EngineHandler();
        StreamHandler sh = new StreamHandler();
        th.init();
        eh.init("tblTimeLine");
        eh.updateStatement("select * " +
                "from tblTimeLine()");
        eh.addListener();
        sh.getTimeline(eh.getRuntime(),th.getTwitter());
    }
}
