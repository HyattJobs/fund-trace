package com.zkna.fund.controller;

import com.zkna.fund.feign.JaegerClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class JaegerController {
    private static Logger log = LoggerFactory.getLogger(JaegerController.class);

    @Autowired
    private JaegerClientService jClient;

    @GetMapping("/jaeger-log")
    public String jaeger_log() {
        log.info("feign-consumer");
        return jClient.produceJaeger();
    }

}
