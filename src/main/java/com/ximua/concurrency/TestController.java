package com.ximua.concurrency;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @GetMapping(value="/test/spring")
    @ResponseBody
    public String testSpringBoot(){
        return "Hello,SpringBoot";
    }

    @GetMapping("/test")
    @ResponseBody
    public String test(){
        return "test";
    }
}
