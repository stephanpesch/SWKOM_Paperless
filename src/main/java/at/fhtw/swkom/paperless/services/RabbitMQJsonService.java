package at.fhtw.swkom.paperless.services;

import at.fhtw.swkom.paperless.services.dto.Document;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;



@Slf4j
@Service
public class RabbitMQJsonService {

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.json.key}")
    private String routingJsonKey;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendJsonMessage(Document document){
        log.info(String.format("Json message sent -> %s",document.toString()));
        rabbitTemplate.convertAndSend(exchange,routingJsonKey,document);
    }
}
