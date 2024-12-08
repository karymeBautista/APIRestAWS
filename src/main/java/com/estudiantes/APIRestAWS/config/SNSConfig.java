package com.estudiantes.APIRestAWS.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicSessionCredentials;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.amazonaws.services.sns.*;

@Configuration
public class SNSConfig {
    @Value("${amazon.aws.accesskey}")
    private String amazonAWSAccessKey;

    @Value("${amazon.aws.secretkey}")
    private String amazonAWSSecretKey;

    @Value("${amazon.aws.region}")
    private String amazonAWSRegion;

    @Value("${amazon.aws.sessiontoken}")
    private String amazonAWSSessionToken;

    @Bean
    public AmazonSNS amazonSNS(){
        return AmazonSNSClientBuilder
                .standard()
                .withRegion(amazonAWSRegion)
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials()))
                .build();
    }

    public AWSCredentials awsCredentials(){
        return new BasicSessionCredentials(amazonAWSAccessKey,amazonAWSSecretKey,amazonAWSSessionToken);
    }
}
