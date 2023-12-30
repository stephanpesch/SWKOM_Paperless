package at.fhtw.swkom.paperless.controller;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import at.fhtw.swkom.paperless.services.RabbitMQService;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.util.List;


/*
@RestController
@RequestMapping("/api/documents")
public class DocumentController {

    @Autowired
    private RabbitMQService rabbitMQService;

    @PostMapping("/post_document")
    public ResponseEntity<String> uploadDocument(
            @RequestParam(value = "title", required = false) String title,
           // @RequestParam(value = "created", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime created,
            //@RequestParam(value = "document_type", required = false) Integer documentType,
            //@RequestParam(value = "tags", required = false) List<Integer> tags,
            //@RequestParam(value = "correspondent", required = false) Integer correspondent,
            @RequestParam(value = "document", required = false) MultipartFile document
    ) throws IOException {
        // Here, process and send the message using RabbitMQ
        String fileContent = new String(document.getBytes(), StandardCharsets.UTF_8);
        rabbitMQService.sendMessage(fileContent);

        return ResponseEntity.ok("Document uploaded and message sent to RabbitMQ.");
    }

}

*/