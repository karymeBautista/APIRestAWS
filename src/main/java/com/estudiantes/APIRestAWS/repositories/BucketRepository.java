package com.estudiantes.APIRestAWS.repositories;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.nio.file.Paths;

@Repository
public class BucketRepository {
    @Autowired
    private AmazonS3 amazonS3;

    public void uploadFileToS3(String bucketname,String filename,File file){
        String key_name = Paths.get(file.getAbsolutePath()).getFileName().toString();
        try {
            amazonS3.putObject(new PutObjectRequest(bucketname, key_name, file)
                   );
        } catch (AmazonServiceException e) {
            System.out.println("No se pudo subir correctamente el archivo a S3:");
            System.out.println("Código de error: " + e.getErrorCode());
            System.out.println("Mensaje de error: " + e.getErrorMessage());
            throw e;
        }
    }
}
