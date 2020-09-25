package com.zkna.fund.controller;

import com.google.common.collect.Maps;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zkna.fund.entity.UserHandlerError;
import com.zkna.fund.entity.User;
import com.zkna.fund.feign.DbQueryFeignClientService;
import com.zkna.fund.service.AggregationService;
import io.micrometer.core.util.internal.logging.InternalLogger;
import io.micrometer.core.util.internal.logging.InternalLoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.async.DeferredResult;
import rx.Observable;
import rx.Observer;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancerClient loadBalancerClient;


    @Autowired
    private DbQueryFeignClientService dbQueryFeignClient;

    //聚合服务
    @Autowired
    private AggregationService aggregationService;

    @GetMapping("/user/{id}")
    @HystrixCommand(fallbackMethod = "findByIdFallback")
    public User findById(@PathVariable Long id) {
        //        User findOne = this.userRepository.restTemplate().getForObject("http://localhost:9011/userInfo/getInfo/"+id,User.class);
        //User findOne = this.restTemplate.getForObject("http://db-mysql/userInfo/getInfo/"+id,User.class);

        LOGGER.debug("Logger---id"+id);
        return this.dbQueryFeignClient.findById(id);
    }

    @GetMapping("/tuser/{id}")
    @HystrixCommand(fallbackMethod = "findByIdFallback")
    public User tFindById(@PathVariable Long id) {
        //        User findOne = this.userRepository.restTemplate().getForObject("http://localhost:9011/userInfo/getInfo/"+id,User.class);
//        User findOne = this.restTemplate.getForObject("http://db-data-engine/userInfo/getInfo/1",User.class);
//        System.out.println(findOne.getId());
        LOGGER.debug("Logger---id"+id);
        return this.dbQueryFeignClient.tFindById(id);
    }

    @GetMapping("/nodejs-data")
    public String getNodeData() {
        return this.restTemplate.getForObject("http://sidecar-service/nodejs/user",String.class);
    }

    @GetMapping("/aggregate/{id}")
    public DeferredResult<HashMap<String, User>> aggregate(@PathVariable Long id) {
        Observable<HashMap<String, User>> result = this.aggregateObservable(id);
        return this.toDeferredResult(result);
    }

    public Observable<HashMap<String, User>> aggregateObservable(Long id) {
        // 合并两个或者多个Observables发射出的数据项，根据指定的函数变换它们
        return Observable.zip(
                this.aggregationService.getUserId(id),
                this.aggregationService.getNodejsName(id),
                (user, movieUser) -> {
                    HashMap<String, User> map = Maps.newHashMap();
                    map.put("user", user);
                    map.put("movieUser", movieUser);
                    return map;
                }
        );
    }

    @RequestMapping("/getList")
    public List<User> getList(){
        List<User> userInfoEntityList = this.dbQueryFeignClient.getUserList();
        return userInfoEntityList;
    }


    public UserHandlerError findByIdFallback(Long id){
        UserHandlerError fe = new UserHandlerError();
        fe.setId(0L);
        fe.setName("error");
        fe.setDetail("connection close");
        fe.setResult("fall back");
        return fe;
    }

    @GetMapping("/log-user-instance")
    public void logUserInstance() {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("db-data-engine");
        // 打印当前选择的是哪个节点
        LOGGER.info("{}:{}:{}", serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort());
    }

    public DeferredResult<HashMap<String, User>> toDeferredResult(Observable<HashMap<String, User>> details) {
        DeferredResult<HashMap<String, User>> result = new DeferredResult<>();
        // 订阅
        details.subscribe(new Observer<HashMap<String, User>>() {
            @Override
            public void onCompleted() {
                LOGGER.info("完成...");
            }

            @Override
            public void onError(Throwable throwable) {
                LOGGER.error("发生错误...", throwable);
            }

            @Override
            public void onNext(HashMap<String, User> movieDetails) {
                result.setResult(movieDetails);
            }
        });
        return result;
    }

}
