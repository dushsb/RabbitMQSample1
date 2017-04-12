package com.example.mq.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.example.mq.MessageConfig;
import com.example.mq.message.CustomMessage;

@Service
public class CustomMessageListener {
	
	private static final Logger log = LoggerFactory.getLogger(CustomMessageListener.class);
	 
    @RabbitListener(queues = MessageConfig.QUEUE_GENERIC_NAME)
    public void receiveMessage(final Message message) {
        log.info("Received message as generic: {}", message.toString());
    }
 
    @RabbitListener(queues = MessageConfig.QUEUE_SPECIFIC_NAME)
    public void receiveMessage(final CustomMessage customMessage) {
        log.info("Received message as specific class: {}", customMessage.toString());
    }
}
