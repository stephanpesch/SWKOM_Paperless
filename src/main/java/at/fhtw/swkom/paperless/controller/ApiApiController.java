package at.fhtw.swkom.paperless.controller;

import at.fhtw.swkom.paperless.services.DocumentServiceImpl;
import at.fhtw.swkom.paperless.services.dto.*;
import org.openapitools.jackson.nullable.JsonNullable;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.OffsetDateTime;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.context.request.NativeWebRequest;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-10-10T09:40:41.152453Z[Etc/UTC]")
@Controller
@RequestMapping("${openapi.paperlessRestServer.base-path:}")
@CrossOrigin(origins = "http://localhost:8080")
public class ApiApiController implements ApiApi {

    private final NativeWebRequest request;

    private final DocumentServiceImpl documentServiceImpl;

    @Autowired
    public ApiApiController(NativeWebRequest request ,DocumentServiceImpl documentServiceImpl) {
        this.request = request;
        this.documentServiceImpl = documentServiceImpl;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }



    @Override
    public ResponseEntity<Void> uploadDocument(String title, OffsetDateTime created, Integer documentType, List<Integer> tags, Integer correspondent, List<MultipartFile> file) {
        try {

            String name = file.get(0).getOriginalFilename();
            Document documentDTO = new Document();
            documentDTO.setTitle(JsonNullable.of(title == null ? name : title));
            documentDTO.setOriginalFileName(JsonNullable.of(name));
            documentDTO.setCreated(created);
            documentDTO.setDocumentType(JsonNullable.of(documentType));
            documentDTO.setTags(JsonNullable.of(tags));
            documentDTO.setCorrespondent(JsonNullable.of(correspondent));

            MultipartFile multipartFile = file.get(0);

            if(multipartFile == null || multipartFile.isEmpty()){
                return ResponseEntity.badRequest().build();
            }

            documentServiceImpl.uploadDocument(documentDTO, multipartFile);
            return ResponseEntity.ok().build();

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }

    }

}
