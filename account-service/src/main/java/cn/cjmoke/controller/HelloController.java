package cn.cjmoke.controller;

import cn.cjmoke.pojo.Account;
import cn.cjmoke.pojo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("hello")
    public String hello(){
        return "hello world";
    }


}
