import com.espertech.esper.client.*;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

import java.io.*;
import java.util.List;

/**
 * Created by Vincent Schmalor on 22/06/2017.
 */
public class TwitterAnalysis {
    private static class Status{
        private String status = "";

        public Status(String status){
            this.status = status;
        }
        public String getStatus() {return status;}
        @Override public String toString(){
            return status;
        }
    }

    public static void getTimeline(EPRuntime cepRT, Twitter twitter)throws Exception{
        List<twitter4j.Status> statuses = twitter.getHomeTimeline();
        for (twitter4j.Status status : statuses) {
            Status status1 = new Status(
                    status.getCreatedAt() +
                    "\nUser: " + status.getUser().getName() +
                    "\n" + status.getText() +
                    "\nFollowers:" + status.getUser().getFollowersCount() + "\n\n");
            cepRT.sendEvent(status1);
        }
    }

    /**
     * Hauptprogramm
     * @param args kann unbeachtet belassen werden
     */
    public static void main(String[] args) throws Exception{
        //Configuration der Engine
        Twitter twitter = TwitterFactory.getSingleton();
        twitter.setOAuthConsumer("41C4SELJGcqp7szwWHN4F93VO", "vJh92ndV3Z0N0qOZQDnWlr077T2Drh8eGJoM1MbhS1qHex4k2x");
        RequestToken requestToken = twitter.getOAuthRequestToken();
        AccessToken accessToken = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (null == accessToken) {
            System.out.println("Öffnen Sie die folgende Website, um Zugang zum Account zu gewähren:");
            System.out.println(requestToken.getAuthorizationURL());
            System.out.println("Gegen Sie hier die PIN von der Website ein:");
            String pin = br.readLine();
            try{
                if(pin.length() > 0){
                    accessToken = twitter.getOAuthAccessToken(requestToken, pin);
                }else{
                    accessToken = twitter.getOAuthAccessToken();
                }
            } catch (TwitterException te) {
                if(401 == te.getStatusCode()){
                    System.out.println("Kein Zugang zum Accesstoken");
                }else{
                    te.printStackTrace();
                }
            }
        }
        Configuration cepConfig = new Configuration();
        cepConfig.addEventType("Timeline", TwitterAnalysis.Status.class.getName());
        EPServiceProvider cep = EPServiceProviderManager.getProvider("myCEPEngine", cepConfig);
        EPRuntime cepRT = cep.getEPRuntime();
        EPAdministrator cepAdm = cep.getEPAdministrator();
        //Statement, mit dem der Stream analysiert wird
        EPStatement cepStatement = cepAdm.createEPL(
                "select * from " + "Timeline()" +
                        "");
        //Listener aktivieren
        cepStatement.addListener(new Controller.CEPListener());
        //Sehr kleinen Stream generieren
        getTimeline(cepRT,twitter);
    }

    /**
     * Wartet auf Erzeugen eines Events durch das Statement. Implementiert, was folgen soll, falls ein Event eintritt
     */
    public static class CEPListener implements UpdateListener{
        //Wird automatisch von der Engine angesprochen
        public void update(EventBean[] newData, EventBean[] oldData) {
            System.out.println("Event received: " + newData[0].getUnderlying());
        }
    }
}
