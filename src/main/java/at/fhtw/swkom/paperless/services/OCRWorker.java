package at.fhtw.swkom.paperless.services;


import at.fhtw.swkom.paperless.config.MinIOConfig;
import at.fhtw.swkom.paperless.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OCRWorker {

    @Autowired
    private OCRService ocrService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    RabbitMQConfig rabbitMQConfig;

    public static final String MESSAGE_OUT_QUEUE = "Echo_Out";

    @RabbitListener(queues = RabbitMQConfig.MESSAGE_IN_QUEUE)
    public void receiveMessage(String message) {
        String filePath = extractDocumentPath(message);
        String extractedText = ocrService.processDocument(filePath);

        // Create OCR result object
       // String OcrResult  =
       // ocrResult.setExtractedText(extractedText);
       // ocrResult.setDocumentPath(filePath);

        // Send OCR result to another queue
        rabbitTemplate.convertAndSend(MESSAGE_OUT_QUEUE, extractedText);
    }

    private String extractDocumentPath(String message) {
        // Simple extraction logic (adjust based on your message format)
        return message; // Placeholder for actual extraction logic
    }
}



