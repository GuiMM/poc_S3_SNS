package com.fiap.burguer.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.regions.RegionUtils;
import com.amazonaws.services.sns.model.SetTopicAttributesRequest;
import com.amazonaws.services.sns.model.Topic;
import com.amazonaws.services.sns.model.GetTopicAttributesRequest;
import com.amazonaws.services.sns.model.GetTopicAttributesResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import software.amazon.awssdk.regions.Region;


@Configuration
public class ConfigSns {


    @Value("${aws.accessKeyId}")
    String accessKeyId;

    @Value("${aws.secretAccessKey}")
    String secretAccessKey;

    @Value("${aws.token}")
    String token;


    String regionName = Region.US_EAST_1.toString();

    @Value("${aws.accountId}")
    String accountId;

    @Value("${aws.topic}")
    String topic;

    BasicSessionCredentials credentials = new BasicSessionCredentials(accessKeyId, secretAccessKey, token);

    String arn = "arn:aws:sns:" + regionName +":"+accountId+":"+topic;

    @Bean
    public AmazonSNS snsClient() {
         AmazonSNS snsClient = AmazonSNSClientBuilder.standard()
                .withRegion(regionName)
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();

        SetTopicAttributesRequest setTopicAttributesRequest = new SetTopicAttributesRequest()
                .withTopicArn("arn:aws:sns:" + regionName +":"+accountId+":video-update-status.fifo")
                .withAttributeName("ContentBasedDeduplication")
                .withAttributeValue("true");

        snsClient.setTopicAttributes(setTopicAttributesRequest);

        return snsClient;
    }

    @Bean
    public String arnTopic() {
        return arn;
    }

    @Bean(name = "productEventsTopic")
    public Topic snsProductEventsTopic() {

        GetTopicAttributesRequest getTopicAttributesRequest = new GetTopicAttributesRequest()
                .withTopicArn(arn);
        GetTopicAttributesResult getTopicAttributesResult = snsClient().getTopicAttributes(getTopicAttributesRequest);

        String topicArn = getTopicAttributesResult.getAttributes().get("TopicArn");


        return new Topic().withTopicArn(topicArn);
    }
}
