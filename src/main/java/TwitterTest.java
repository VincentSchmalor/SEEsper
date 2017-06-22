import twitter4j.*;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by Vincent Schmalor on 22/06/2017.
 */
public class TwitterTest {
    public static void main(String args[]) throws Exception{
        // The factory instance is re-useable and thread safe.
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
        //persist to the accessToken for future reference.
        //storeAccessToken((int) twitter.verifyCredentials().getId(), accessToken);
        List<Status> statuses = twitter.getHomeTimeline();
        System.out.println("\n\nZeige Timeline:");
        for (Status status : statuses) {
            System.out.println("\n" + status.getUser().getName() + ":" +
                    status.getText());
        }
        System.exit(0);
    }
    /*
    private static void storeAccessToken(int useId, AccessToken accessToken){
        store accessToken.getToken()
        store accessToken.getTokenSecret()
    }*/

}
