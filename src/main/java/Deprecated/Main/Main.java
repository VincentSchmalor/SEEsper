package Deprecated.Main;

import Deprecated.Handlers.EngineHandler;
import Deprecated.Handlers.StreamHandler;
import Deprecated.Handlers.TwitterHandler;


/**
 * Created by Vincent Schmalor on 22/06/2017.
 */
public class Main{
    
    public static final String STATEMENT = "select * " + "from tblTimeLine()";
    private static final String CONSUMER_KEY = "41C4SELJGcqp7szwWHN4F93VO";
    private static final String CONSUMER_SECRET = "vJh92ndV3Z0N0qOZQDnWlr077T2Drh8eGJoM1MbhS1qHex4k2x";
    
    
    public static void xmain(String[] args){
        TwitterHandler twitter = new TwitterHandler();
        StreamHandler stream = new StreamHandler();
        EngineHandler engine = new EngineHandler();
        boolean online = twitter.onlineAbfrage();
        if(online) twitter.init(CONSUMER_KEY, CONSUMER_SECRET);
        engine.init("tblTimeLine");
        engine.updateStatement();
        engine.addListener();
        if(online) stream.getRealTimeLine(engine.getRuntime(), twitter.getTwitter());
        else stream.getOldTimeLine(engine.getRuntime());
    }
}
