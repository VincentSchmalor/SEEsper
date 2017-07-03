package Deprecated.Handlers;

import Deprecated.Tables.tblTimeLine;
import com.google.gson.Gson;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Vincent Schmalor on 29/06/2017.
 */
public class OfflineHandler {

    private Calendar cal = Calendar.getInstance();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
    private String now = sdf.format(cal.getTime());
    private Gson gson = new Gson();

    public void createFile(){
        try {
            PrintWriter writer = new PrintWriter(now + ".txt", "UTF-8");
            //writer.print("[");
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void schreiben(tblTimeLine timeLine){
        try {
            BufferedReader reader;
            if (!new File(now + ".txt").exists()) {
                new File(now + ".txt").createNewFile();
            }
            reader = new BufferedReader(new FileReader(now + ".txt"));
            StringBuilder sb = new StringBuilder();
            String line = reader.readLine();
            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = reader.readLine();
            }
            PrintWriter writer = new PrintWriter(now + ".txt", "UTF-8");
            String everything = sb.toString();
            writer.print(everything + gson.toJson(timeLine));
            reader.close();
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public ArrayList<tblTimeLine> lesen(){
        try {
            System.out.println("Welchen File möchten Sie lesen?");
            String eingabe = "";
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            eingabe = br.readLine();
            ArrayList<tblTimeLine> set = new ArrayList<tblTimeLine>();
            BufferedReader reader = new BufferedReader(new FileReader(eingabe + ".txt"));
            String line = reader.readLine();
            while (line != null) {
                set.add(gson.fromJson(line, tblTimeLine.class));
                line = reader.readLine();
            }

            //Gelesenen Input in Objekte verpacken
            return set;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
