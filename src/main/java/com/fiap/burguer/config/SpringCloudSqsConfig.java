package com.fiap.burguer.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudSqsConfig {

    @Value("${aws.accessKeyId}")
    String accessKeyId;

    @Value("${aws.secretAccessKey}")
    String secretAccessKey ;

    @Value("${aws.token}")
    String token;
    @Value("${aws.regionName}")
    String regionName;


    @Bean
    public QueueMessagingTemplate queueMessagingTemplate() {
        return new QueueMessagingTemplate(amazonSQSAsync());
    }

    public AmazonSQSAsync amazonSQSAsync() {

        AmazonSQSAsyncClientBuilder amazonSQSAsyncClientBuilder = AmazonSQSAsyncClientBuilder.standard();
        AmazonSQSAsync amazonSQSAsync = null;
        amazonSQSAsyncClientBuilder.withRegion(Regions.US_EAST_1);
        BasicSessionCredentials credentials = new BasicSessionCredentials(accessKeyId, secretAccessKey, token);
        amazonSQSAsyncClientBuilder.withCredentials(new AWSStaticCredentialsProvider(credentials));
        amazonSQSAsync = amazonSQSAsyncClientBuilder.build();
        return amazonSQSAsync;

    }
}
