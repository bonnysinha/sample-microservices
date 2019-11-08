package com.example.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service")
public class MS2Controller{

    private Logger logger = LoggerFactory.getLogger(MS2Controller.class);

    @GetMapping("/2")
    public String serv2(){
        logger.debug("In service 2");
        return "Successful call to Service 2";
    }


}