package com.zkna.servicesysteminfo.controller;

import com.zkna.servicesysteminfo.service.SystemInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SystemInfoController {

    @Autowired
    private SystemInfoService  sis;

    // System信息，从jvm获取
    public String property(){
        String result = "";
        return result;
    }
    // cpu信息
    public String cpu(){
        String result = "";
        return result;
    }
    // 内存信息
    public String memory(){
        String result = "";
        return result;
    }
    // 操作系统信息
    public String os(){
        String result = "";
        return result;
    }
    // 用户信息
    public String who(){
        String result = "";
        return result;
    }
    // 文件系统信息
    public String file(){
        String result = "";
        return result;
    }
    // 网络信息
    @GetMapping("net")
    public String net(){
        String result = "";
        try {
            sis.net();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return result;
    }
    // 以太网信息
    public String ethernet(){
        String result = "";
        return result;
    }
}
