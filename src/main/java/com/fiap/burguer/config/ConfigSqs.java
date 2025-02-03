package com.fiap.burguer.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicSessionCredentials;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.AwsSessionCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;

import java.net.URI;

@Configuration
public class ConfigSqs {

    @Value("${aws.accessKeyId}")
    String accessKeyId;

    @Value("${aws.secretAccessKey}")
    String secretAccessKey;

    @Value("${aws.token}")
    String token;


    @Value("${aws.uriSqs}")
    String uriSqs;

    AwsSessionCredentials credentials = AwsSessionCredentials.create(accessKeyId, secretAccessKey, token);

    @Bean
    public SqsAsyncClient sqsAsyncClient() {
        return SqsAsyncClient.builder()
                .credentialsProvider( StaticCredentialsProvider.create(credentials))
                .endpointOverride(URI.create(uriSqs))
                .region(Region.US_EAST_1)
                .build();
    }
}

