package com.fiap.burguer.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SqsConsumer {

    @SqsListener("video-status.fifo")
    public void recieveMessage(String content) throws Exception{

        log.info("data received ! {}", content);

    }

}
