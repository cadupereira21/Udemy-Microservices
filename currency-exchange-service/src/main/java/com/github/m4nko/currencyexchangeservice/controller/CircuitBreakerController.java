package com.github.m4nko.currencyexchangeservice.controller;

import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/sample-api")
    @Retry(name = "sample-api", fallbackMethod = "hardcodedResponse")
    public String sampleApi(){
        logger.info("Sample API call received");
        var entity = new RestTemplate().getForEntity("http://localhost:8080/dummy-api", String.class);

        return entity.getBody();
    }

    public String hardcodedResponse(Exception ex){
        return "Fallback Response";
    }
}
