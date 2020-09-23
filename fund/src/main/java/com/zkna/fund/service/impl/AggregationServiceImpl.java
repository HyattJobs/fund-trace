package com.zkna.fund.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zkna.fund.entity.User;
import com.zkna.fund.service.AggregationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rx.Observable;

@Service
public class AggregationServiceImpl implements AggregationService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback")
    public Observable<User> getUserId(Long id){
        return Observable.create(ob ->{
            User user = this.restTemplate.getForObject("http://db-data-engine/userInfo/getInfo/{id}",User.class,id);
            ob.onNext(user);
            ob.onCompleted();
        });
    }
    @HystrixCommand(fallbackMethod = "fallback")
    public Observable<User> getNodejsName(Long id){
        return Observable.create(ob ->{
            User user = this.restTemplate.getForObject("http://sidecar-service/nodejs/user?id={id}",User.class,id);
            ob.onNext(user);
            ob.onCompleted();
        });
    }

    public User fallback(Long id) {
        User user = new User();
        user.setId(-1L);
        return user;
    }

}
