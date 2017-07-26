package Twitter;


import com.espertech.esper.client.EPRuntime;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * Created by Vincent Schmalor on 04/07/2017.
 * Get a predefined Twitterstream
 */
public class InputListener{
    
    /**
     * @param runtime runtime of the engine
     */
    public InputListener(EPRuntime runtime){
        try{
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            final Connection con = factory.newConnection();
            final Translator translator = new Translator(runtime);
            
            //Twitterout Channel
            Channel twitteroutChannel = con.createChannel();
            String twitteroutQueueName = twitteroutChannel.queueDeclare().getQueue();
            twitteroutChannel.queueBind(twitteroutQueueName, "twitterout", "");
            Consumer twitteroutConsumer = new DefaultConsumer(twitteroutChannel){
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException{
                    translator.translateAllInOne(new String(body, "UTF-8"));
                }
            };
            
            twitteroutChannel.basicConsume(twitteroutQueueName, true, twitteroutConsumer);
            
            //NFTweet Channel
            Channel nfTweetChannel = con.createChannel();
            String nfTweetQueueName = nfTweetChannel.queueDeclare().getQueue();
            nfTweetChannel.queueBind(nfTweetQueueName, "NFTweet", "");
            Consumer nfTweetConsumer = new DefaultConsumer(nfTweetChannel){
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException{
                    translator.translateNFTweet(new String(body, "UTF-8"));
                }
            };
            
            twitteroutChannel.basicConsume(nfTweetQueueName, true, nfTweetConsumer);
            
            //NFUser Channel
            Channel nfUserChannel = con.createChannel();
            String nfUserQueueName = nfUserChannel.queueDeclare().getQueue();
            nfUserChannel.queueBind(nfUserQueueName, "NFUser", "");
            Consumer nfUserConsumer = new DefaultConsumer(nfUserChannel){
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException{
                    translator.translateNFUser(new String(body, "UTF-8"));
                }
            };
            
            twitteroutChannel.basicConsume(nfUserQueueName, true, nfUserConsumer);
            
            //NFHashtag Channel
            Channel nfHashtagChannel = con.createChannel();
            String nfHashtagQueueName = nfHashtagChannel.queueDeclare().getQueue();
            nfHashtagChannel.queueBind(nfHashtagQueueName, "NFHashtag", "");
            Consumer nfHashtagConsumer = new DefaultConsumer(nfHashtagChannel){
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException{
                    translator.translateNFHashtag(new String(body, "UTF-8"));
                }
            };
            
            twitteroutChannel.basicConsume(nfHashtagQueueName, true, nfHashtagConsumer);
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}