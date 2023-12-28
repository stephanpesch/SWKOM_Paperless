package at.fhtw.swkom.paperless.config;

import com.rabbitmq.client.impl.AMQImpl;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class RabbitMQConfig {


    public static final String QUEUE = "rabbit_queue";
    public static final String EXCHANGE = "rabbit_exchange";

    public static final String ROUTING_KEY ="rabbit_routingkey";

    @Bean
    public Queue queue(){
        return new Queue(QUEUE);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange){
         return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with(ROUTING_KEY);

    }



}
