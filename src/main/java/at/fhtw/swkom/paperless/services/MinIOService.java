package at.fhtw.swkom.paperless.services;

import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

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
}
