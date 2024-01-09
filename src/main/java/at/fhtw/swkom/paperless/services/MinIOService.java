package at.fhtw.swkom.paperless.services;

import at.fhtw.swkom.paperless.persistance.entities.DocumentsDocumentEntity;
import at.fhtw.swkom.paperless.persistance.repositories.DocumentsDocumentRepository;
import at.fhtw.swkom.paperless.services.dto.Document;
import at.fhtw.swkom.paperless.services.mapper.DocumentMapper;
import io.minio.GetObjectArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.OffsetDateTime;

@Data
@Service
public class MinIOService {

    @Value("${minio.bucketName}")
    private String bucketName;

    private MinioClient minioClient;

    @Autowired
    public MinIOService(MinioClient minioClient) {
        this.minioClient = minioClient;
    }

    private void CreateNewBucket() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        minioClient.makeBucket(
                MakeBucketArgs
                        .builder()
                        .bucket(bucketName)
                        .build());
    }


    public void uploadDocument(MultipartFile documentFile, String path) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        CreateNewBucket();

        try {

            InputStream inputStream = documentFile.getInputStream();

            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(bucketName)
                            .object(path)
                            .stream(documentFile.getInputStream(), documentFile.getSize(), -1)
                            .contentType(documentFile.getContentType())
                            .build()
            );

        } catch (Exception e) {

            throw new RuntimeException("Failed uploading document!", e);
        }

    }

    public byte[] getFile(String filePath) {
        try {
            // Get object from MinIO
            try (InputStream stream = minioClient.getObject(
                    GetObjectArgs
                            .builder()
                            .bucket(bucketName)
                            .object(filePath)
                            .build());

                 ByteArrayOutputStream buffer = new ByteArrayOutputStream()) {

                int nRead;
                byte[] data = new byte[1024];
                while ((nRead = stream.read(data, 0, data.length)) != -1) {
                    buffer.write(data, 0, nRead);
                }
                return buffer.toByteArray();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}