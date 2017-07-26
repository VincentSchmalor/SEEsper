package Twitter;

import com.espertech.esper.client.*;

import java.util.ArrayList;

/**
 * Created by Vincent Schmalor on 04/07/2017.
 * Engine making the magic happen
 */
public class Engine{
    private EPRuntime runtime;
    private EPAdministrator administrator;
    
    public Engine(){
        Configuration configuration = new Configuration();
        configuration.addEventType("tblTweet", tblTweet.class);
        configuration.addEventType("tblHashtags", tblHashtags.class);
        configuration.addEventType("tblNFTweet", tblNFTweet.class);
        configuration.addEventType("tblNFUser", tblNFUser.class);
        configuration.addEventType("tblNFHashtag", tblNFHashtag.class);
        EPServiceProvider serviceProvider = EPServiceProviderManager.getProvider("myEngine", configuration);
        runtime = serviceProvider.getEPRuntime();
        administrator = serviceProvider.getEPAdministrator();
    }
    
    /**
     * Add variable count of statements whith a standard Listener
     *
     * @param statements multiple Statements to add
     */
    public void updateStatement(String... statements){
        Listener listener = new Listener();
        for(String statement : statements){
            EPStatement epStatement;
            try{
                epStatement = administrator.createEPL(statement);
                epStatement.addListener(listener);
            }catch(Exception e){
                e.printStackTrace();
                System.out.println("Invalid Statement: Switching to Standardstatement");
                epStatement = administrator.createEPL(MainTwitterXmpls.DEFAULT_STATEMENT);
                epStatement.addListener(listener);
            }
        }
    }
    
    /**
     * Add variable count of statements whith out a Listener
     *
     * @param statements multiple Statements to add
     *
     * @return ArrayList of Statments needed to add Listeners
     */
    public ArrayList<EPStatement> updateCustomStatement(String... statements){
        ArrayList<EPStatement> epStatements = new ArrayList<EPStatement>();
        for(int i = 0; i < statements.length; i++){
            try{
                epStatements.add(administrator.createEPL(statements[i]));
            }catch(Exception e){
                e.printStackTrace();
                System.out.println("Invalid Statement: Switching to Standardstatement");
                epStatements.add(administrator.createEPL(MainTwitterXmpls.DEFAULT_STATEMENT));
            }
        }
        return epStatements;
    }
    
    public EPRuntime getRuntime(){
        return runtime;
    }
    
}
