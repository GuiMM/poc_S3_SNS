package com.fiap.burguer.publish;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import com.amazonaws.services.sns.model.Topic;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class SnsProducer {

    private AmazonSNS snsClient;
    private Topic productEventsTopic;
    String messageGroupId = "meu-message-group-id";
    String messageDeduplicationId = UUID.randomUUID().toString();

    public SnsProducer(AmazonSNS snsClient,
                            @Qualifier("productEventsTopic")Topic productEventsTopic) {
        this.snsClient = snsClient;
        this.productEventsTopic = productEventsTopic;
    }

    public void publishStatusEvent(String message) {
        PublishResult publishResult = snsClient.publish(
                new PublishRequest(productEventsTopic.getTopicArn(), message)
                        .withMessageGroupId(messageGroupId)
                        .withMessageGroupId(messageGroupId)
                        .withMessageDeduplicationId(messageDeduplicationId))
             ;

        log.info("MessageId: {}", publishResult.getMessageId());
    }
}
