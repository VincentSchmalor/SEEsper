package Deprecated.Handlers;

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
public class TwitterHandler{
    //Deklasration
    private Twitter twitter = TwitterFactory.getSingleton();
    
    //Methoden
    
    /**
     * Initialisiert die Verbindung mit Twitter und ist an Benutzerinteraktion beteiligt
     */
    public void init(String CONSUMER_KEY, String CONSUMER_SECRET){
        try{
            twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
            RequestToken requestToken = twitter.getOAuthRequestToken();
            AccessToken accessToken = null;
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while(accessToken == null){
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
                }catch(TwitterException te){
                    if(401 == te.getStatusCode()){
                        System.out.println("Kein Zugang zum Accesstoken");
                    }else{
                        te.printStackTrace();
                    }
                }
            }
        }catch(Exception e){
            System.err.println("Twitterinitialisierung fehlgeschlagen. Bitte starten Sie das Programm erneut.");
        }
    }
    
    public boolean onlineAbfrage(){
        System.out.println("Möchten Sie eine Liveabfrage starten? (y/n)");
        String eingabe = "";
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            eingabe = br.readLine();
        }catch(Exception e){
            e.printStackTrace();
        }
        return eingabe.equals("y");
    }
    
    //Getter, Setter
    public Twitter getTwitter(){
        return twitter;
    }
}
