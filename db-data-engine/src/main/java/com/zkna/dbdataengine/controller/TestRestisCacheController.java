package com.zkna.dbdataengine.controller;

import com.zkna.dbdataengine.entity.UserInfoEntity;
import com.zkna.dbdataengine.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testRestInfo")
public class TestRestisCacheController {
    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/getInfo/{userId}")
    public UserInfoEntity getInfo(@PathVariable Long userId){
        System.out.println("uid:"+userId);
        UserInfoEntity userInfoEntity = userInfoService.getById(userId);
        return userInfoEntity;
    }
}
