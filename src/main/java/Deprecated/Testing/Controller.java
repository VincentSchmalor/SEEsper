package Deprecated.Testing;

import com.espertech.esper.client.*;
import java.util.Random;
import java.util.Date;


public class Controller{

    /**
     * Legt das Schema eines Events an. Besitzt Symbol, Preis und Zeitstempel
     */
    public static class Tick {
        String symbol;
        Double price;
        Date timeStamp;

        public Tick(String s, double p, long t) {
            symbol = s;
            price = p;
            timeStamp = new Date(t);
        }

        public double getPrice() {
            return price;
        }

        public String getSymbol() {
            return symbol;
        }

        public Date getTimeStamp() {
            return timeStamp;
        }

        @Override
        public String toString() {
            return "Price: " + price.toString() + " time: " + timeStamp.toString();
        }
    }

    private static Random generator = new Random();

    /**
     * Generiert zufällige Ticks, um einen Stream zu erzeugen, der analysiert werden kann. Vorlage ist die Klasse "Tick"
     * @param cepRT Laufzeitumgebung des Serviceproviders der Engine (Wird verwendet, um den generierten Tick
     *              an die Engine zu senden)
     */
    public static void GenerateRandomTick(EPRuntime cepRT) {
        //zufällige Werte erzeugen
        String symbol = "AAPL";
        double price = (double) generator.nextInt(10);
        long timeStamp = System.currentTimeMillis();
        //Tick generieren
        Tick tick = new Tick(symbol, price, timeStamp);
        System.out.println("\nSending tick:" + tick);
        //Tick an Engine übergeben
        cepRT.sendEvent(tick);
    }

    /**
     * Wartet auf Erzeugen eines Events durch das Statement. Implementiert, was folgen soll, falls ein Event eintritt
     */
    public static class CEPListener implements UpdateListener {
        //Wird automatisch von der Engine angesprochen
        public void update(EventBean[] newData, EventBean[] oldData) {
            System.out.println("Event received: " + newData[0].getUnderlying());
        }
    }

    /**
     * Hauptprogramm
     * @param args kann unbeachtet belassen werden
     */
    public static void main(String[] args) {
        //Configuration der Engine
        Configuration cepConfig = new Configuration();
        cepConfig.addEventType("StockTick", Tick.class.getName());
        EPServiceProvider cep = EPServiceProviderManager.getProvider("myCEPEngine", cepConfig);
        EPRuntime cepRT = cep.getEPRuntime();
        EPAdministrator cepAdm = cep.getEPAdministrator();
        //Statement, mit dem der Stream analysiert wird
        EPStatement cepStatement = cepAdm.createEPL(
                "select * from " + "StockTick(symbol='AAPL').win:length(2) " +
                        "having avg(price) > 3");
        //Deprecated.Listeners.Listener aktivieren
        cepStatement.addListener(new CEPListener());
        //Sehr kleinen Stream generieren
        for (int i = 0; i < 10; i++) {
            GenerateRandomTick(cepRT);
        }
    }
}