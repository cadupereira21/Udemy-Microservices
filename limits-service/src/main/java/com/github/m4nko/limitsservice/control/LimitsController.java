package com.github.m4nko.limitsservice.control;

import com.github.m4nko.limitsservice.bean.Limits;
import com.github.m4nko.limitsservice.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

    @Autowired
    private Configuration config;

    @GetMapping("/limits")
    public Limits retrieveLimits(){

        return new Limits(config.getMinimum(), config.getMaximum());
        //return new Limits(1, 1000);
    }
}
