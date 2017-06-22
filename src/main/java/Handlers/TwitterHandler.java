package Handlers;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Vincent Schmalor on 22/06/2017.
 */
public class TwitterHandler {

    public Twitter twitter = TwitterFactory.getSingleton();


    public TwitterHandler(){
    }

    public void init(){
        try {
            twitter.setOAuthConsumer("41C4SELJGcqp7szwWHN4F93VO", "vJh92ndV3Z0N0qOZQDnWlr077T2Drh8eGJoM1MbhS1qHex4k2x");
            RequestToken requestToken = twitter.getOAuthRequestToken();
            AccessToken accessToken = null;
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while (null == accessToken) {
                System.out.println("Öffnen Sie die folgende Website, um Zugang zum Account zu gewähren:");
                System.out.println(requestToken.getAuthorizationURL());
                System.out.println("Gegen Sie hier die PIN von der Website ein:");
                String pin = br.readLine();
                try {
                    if (pin.length() > 0) {
                        accessToken = twitter.getOAuthAccessToken(requestToken, pin);
                    } else {
                        accessToken = twitter.getOAuthAccessToken();
                    }
                } catch (TwitterException te) {
                    if (401 == te.getStatusCode()) {
                        System.out.println("Kein Zugang zum Accesstoken");
                    } else {
                        te.printStackTrace();
                    }
                }
            }
        }catch (Exception e){
            System.err.println("Twitterinitialisierung fehlgeschlagen. Bitte starten Sie das Programm erneut.");
        }
    }

    public Twitter  getTwitter(){
        return twitter;
    }
}
