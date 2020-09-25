package com.zkna.fund.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "db-data-engine")
@Component
public interface JaegerClientService {

    @RequestMapping(value = "/jaeger/dc", method = RequestMethod.GET)
    String produceJaeger();
}
