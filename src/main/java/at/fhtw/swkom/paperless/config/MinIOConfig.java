package at.fhtw.swkom.paperless.config;


import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.errors.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Slf4j
@Configuration
public class MinIOConfig {

    @Value("${minio.url}")
    private String url;

    @Value("${minio.access.name}")
    private String accessKey;

    @Value("${minio.access.secret}")
    private String accessSecret;

    @Value("${minio.bucketName}")
    private String bucketName;


    @Bean
    public MinioClient MinioClient() {
        try{
            MinioClient minioClient = MinioClient.builder()
                    .endpoint(url)
                    .credentials(accessKey, accessSecret)
                    .build();
            createNewBucket(minioClient);
            log.info("MinioClient initialized, url: {}", url);
            return minioClient;
        }catch (Exception e){
            throw new RuntimeException("Could not init MinioClient",e);
        }
    }

    private void createNewBucket(MinioClient minioClient) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        minioClient.makeBucket(
                MakeBucketArgs
                .builder()
                .bucket(bucketName)
                .build());
    }
}

