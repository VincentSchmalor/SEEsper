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

    Gson gson = new Gson();
    String json = "";
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
    String now = sdf.format(cal.getTime());


    /**
     * Lädt die Timeline von Twitter in die Engine
     * @param runtime
     * @param twitter
     * @throws Exception
     */
    public void getRealTimeLine(EPRuntime runtime, Twitter twitter){
        try {
            PrintWriter writer = new PrintWriter(now + ".txt", "UTF-8");
            writer.print("[");
            writer.close();
            List<Status> timeline;
            timeline = twitter.getHomeTimeline();
            for (twitter4j.Status status : timeline) {
                tblTimeLine timeLine = new tblTimeLine(
                        status.getCreatedAt(),
                        status.getUser().getName(),
                        status.getText(),
                        status.getUser().getFollowersCount());
                json = gson.toJson(timeLine);
                speichern();
                runtime.sendEvent(timeLine);
            }
            PrintWriter writer2 = new PrintWriter(now + ".txt", "UTF-8");
            writer2.print("]");
            writer2.close();
        }catch (TwitterException e){
            System.err.println("Timeline konnte nicht geladen werden. " +
                    "Bitte starten Sie das Programm neu und versuchen Sie es erneut.");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void speichern()throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader(now + ".txt"));
        StringBuilder sb = new StringBuilder();
        String line = reader.readLine();
        while (line != null) {
            sb.append(line);
            line = reader.readLine();
        }
        PrintWriter writer2 = new PrintWriter(now + ".txt", "UTF-8");
        String everything = sb.toString();
        writer2.print(everything + json);
        reader.close();
        writer2.close();
    }

    private tblTimeLine[] lesen(String name){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(name + ".txt"));
            String res = reader.readLine();

            //Gelesenen Input in Objekte verpacken
            return gson.fromJson(res, tblTimeLine[].class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void getOldTimeLine(EPRuntime runtime, Twitter twitter){
        try {
            new PrintWriter(now + ".txt", "UTF-8");
            tblTimeLine[] oldData = lesen("2017-06-28-19-18-23");
            for (tblTimeLine status : oldData) {
                runtime.sendEvent(status);
            }
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
