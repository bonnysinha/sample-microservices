package com.example.controllers;

// import com.example.kafka.MS1KafkaProducer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/service")
public class MS1Controller {

    private final Logger logger = LoggerFactory.getLogger(MS1Controller.class);

    // @Autowired
    // private MS1KafkaProducer mS1KafkaProducer;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate; 

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/1/{param}")
    public String callKafkaServ(@PathVariable final String param) {
        logger.debug("Hello, in service 1");
        // mS1KafkaProducer.sendMessageToKafka("Test Param");
        kafkaTemplate.send("MSTopic",param);
        return "Sent a message to kafka";
        // ResponseEntity<String> response = restTemplate.getForEntity("http://MS2/service/2", String.class);
        // return response.getBody();
    }

    @GetMapping("/rest")
    public String callService(){
        ResponseEntity<String> response = restTemplate.getForEntity("http://MS2/service/2", String.class);
        return response.getBody();
    }
}