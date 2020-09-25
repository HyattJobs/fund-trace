package com.zkna.fund.feign;

import com.zkna.fund.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "db-data-engine")
@Component
public interface DbQueryFeignClientService {

    @RequestMapping(value = "/userInfo/getInfo/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable Long id);

    @RequestMapping(value = "/testRestInfo/getInfo/{id}", method = RequestMethod.GET)
    public User tFindById(@PathVariable Long id);

    @RequestMapping(value = "/userInfo/getList", method = RequestMethod.GET)
    public List<User> getUserList();
}
