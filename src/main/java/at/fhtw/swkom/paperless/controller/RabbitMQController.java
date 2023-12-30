package at.fhtw.swkom.paperless.controller;


import at.fhtw.swkom.paperless.services.RabbitMQJsonService;
import at.fhtw.swkom.paperless.services.RabbitMQService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import at.fhtw.swkom.paperless.services.dto.Document;



@RestController
@RequestMapping("/api/documents")
public class RabbitMQController {
    @Autowired
    private RabbitMQService rabbitMQService;

    @Autowired
    private RabbitMQJsonService rabbitMQJsonService;



    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message){
        rabbitMQService.sendMessage(message);
        return ResponseEntity.ok("Message sent to RabbitMQ.");
    }


    @PostMapping("/post_document")
    public ResponseEntity<String> sendJsonMessage(@RequestBody Document document){
        rabbitMQJsonService.sendJsonMessage(document);
        return ResponseEntity.ok("Json message sent to RabbitMQ.");
    }
}
