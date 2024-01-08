package at.fhtw.swkom.paperless.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class OCRService {

    @Autowired
    private MinIOService minIOService;

    public String processDocument(String filePath) {
        // Retrieve the PDF document from MinIO
        byte[] pdfContent = minIOService.getFile(filePath);

        // Use Ghostscript and Tesseract to perform OCR on the PDF
        return performOcrOnPdf(pdfContent);
    }

    private String performOcrOnPdf(byte[] pdfContent) {
        try {
            // Write the PDF content to a temporary file
            Path pdfTempFile = Files.createTempFile("tempPdf", ".pdf");
            Files.write(pdfTempFile, pdfContent);

            // Convert PDF to TIFF using Ghostscript
            Path tiffTempFile = convertPdfToTiff(pdfTempFile);

            // Perform OCR using Tesseract on the TIFF file
            return performOcrWithTesseract(tiffTempFile);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "OCR failed";
        }
    }

    private Path convertPdfToTiff(Path pdfFile) throws IOException, InterruptedException {
        Path tiffFile = Files.createTempFile("tempTiff", ".tiff");
        ProcessBuilder processBuilder = new ProcessBuilder("gs", "-dBATCH", "-dNOPAUSE", "-sDEVICE=tiffg4",
                "-r300", "-sOutputFile=" + tiffFile.toString(), pdfFile.toString());
        Process process = processBuilder.start();
        process.waitFor();
        return tiffFile;
    }

    private String performOcrWithTesseract(Path tiffFile) throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder("tesseract", tiffFile.toString(), "stdout");
        Process process = processBuilder.start();

        // Capture the output of Tesseract
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder output = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line).append("\n");
        }

        process.waitFor();
        return output.toString();
    }
}