package com.activemqdemo.activemq.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;
import javax.xml.ws.Response;

@RestController
@RequestMapping(path = "/messages")
public class MessagesController {

    @Autowired
    public JmsTemplate jmsTemplate;

    @GetMapping("/sendMessage/{message}")
    public ResponseEntity sendMessage(@PathVariable("message") String message) {
        if (message.contains("Amy")){
            jmsTemplate.convertAndSend("amy.queue", message);
        }else
        {
            jmsTemplate.convertAndSend("others.queue", message);
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}
