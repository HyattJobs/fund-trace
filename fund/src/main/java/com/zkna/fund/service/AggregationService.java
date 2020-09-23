package com.zkna.fund.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zkna.fund.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rx.Observable;

@Service
public interface AggregationService {

    @HystrixCommand(fallbackMethod = "fallback")
    public Observable<User> getUserId(Long id);

    @HystrixCommand(fallbackMethod = "fallback")
    public Observable<User> getNodejsName(Long id);

    public User fallback(Long id);
}
