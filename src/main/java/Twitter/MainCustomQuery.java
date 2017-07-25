package Twitter;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Vincent Schmalor on 25/07/2017.
 * Main-Method to allocate most important parts
 */
public class MainCustomQuery {

    /**
     * Mainactivity
     * @param args non required
     */
    public static void main(String[] args) {
        Engine engine = new Engine();
        userInteraction(engine);
        new InputListener(engine.getRuntime());
    }

    public static void userInteraction(Engine engine){
        System.out.println("Geben Sie hier ein Statement ein und betätigen Sie Enter oder lassen Sie die Zeile leer, " +
                "um das Standardstatement zu verwenden. Für Hilfe geben Sie 'help' ein:");
        String eingabe = "";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            eingabe = br.readLine();
        }catch (Exception e){
            e.printStackTrace();
        }
        if(eingabe.equals("")){
            engine.updateStatement(MainTwitterXmpls.DEFAULT_STATEMENT);
        } else if(eingabe.equals("help")){
            System.out.println("Please read the documentation on http://www.espertech.com/esper/documentation.php\n");
            userInteraction(engine);
        } else{
            engine.updateStatement(eingabe);
        }
    }
}
