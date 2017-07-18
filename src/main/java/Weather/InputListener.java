package Weather;


import com.espertech.esper.client.EPRuntime;
import com.rabbitmq.client.*;

import java.io.IOException;

public class InputListener {

    /**
     * Standard Contructor
     * @param runtime runtime of the engine
     */
    public InputListener(EPRuntime runtime){
        try{
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            final Connection con = factory.newConnection();
            final Translator translator = new Translator(runtime);
            Channel channel = con.createChannel();
            String queueName = channel.queueDeclare().getQueue();
            channel.queueBind(queueName, "weatherout", "");
            Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    translator.translate(new String(body, "UTF-8"));
                }
            };

            channel.basicConsume(queueName, true, consumer);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}