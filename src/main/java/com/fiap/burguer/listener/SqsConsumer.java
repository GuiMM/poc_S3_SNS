package com.fiap.burguer.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import io.awspring.cloud.sqs.annotation.SqsListener;

@Slf4j
@Service
public class SqsConsumer {

    @SqsListener("video-status.fifo")
    public void recieveMessage(String content) {

        log.info("data received ! {}", content);

    }
}
