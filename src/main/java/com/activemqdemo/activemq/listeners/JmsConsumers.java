package com.activemqdemo.activemq.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JmsConsumers {

    private static final Logger logger = LoggerFactory.getLogger(JmsConsumers.class);

    @JmsListener(destination = "amy.queue")
    public void  consumeAmyQueue(String message){
        logger.info(message);
    }

    @JmsListener(destination = "others.queue")
    public void  consumeOthersQueue(String message){
        logger.info(message);
    }

    @JmsListener(destination = "demoQueue")
    public void  consumedemoQueue(String message){
        logger.info(message);
    }
}
