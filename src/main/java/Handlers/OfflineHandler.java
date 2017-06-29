package Handlers;

import Tables.tblTimeLine;
import com.google.gson.Gson;
import sun.reflect.generics.tree.Tree;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TreeSet;

/**
 * Created by Vincent Schmalor on 29/06/2017.
 */
public class OfflineHandler {

    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
    String now = sdf.format(cal.getTime());
    Gson gson = new Gson();

    public void startFile(){
        try {
            PrintWriter writer = new PrintWriter(now + ".txt", "UTF-8");
            //writer.print("[");
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void speichern(tblTimeLine timeLine){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(now + ".txt"));
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

    public void appendEnd(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(now + ".txt"));
            StringBuilder sb = new StringBuilder();
            String line = reader.readLine();
            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = reader.readLine();
            }
            PrintWriter writer = new PrintWriter(now + ".txt", "UTF-8");
            String everything = sb.toString();
            writer.print(everything + "]");
            reader.close();
            writer.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<tblTimeLine> lesen(String name){
        try {
            ArrayList<tblTimeLine> set = new ArrayList<tblTimeLine>();
            BufferedReader reader = new BufferedReader(new FileReader(name + ".txt"));
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
