package Moduled;

/**
 * Created by Vincent Schmalor on 04/07/2017.
 */
public class Main {

    public static void main(String[] args){
        System.out.println("mache Sachen");
        Engine engine = new Engine();
        engine.init("tblTweet");
        engine.updateStatement("SELECT * from tblTweet()");
        engine.addListener();
        InputListener input = new InputListener();
        input.listen(engine.getRuntime());
    }
}
