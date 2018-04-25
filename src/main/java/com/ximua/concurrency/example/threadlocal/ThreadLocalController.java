package com.ximua.concurrency.example.threadlocal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ThreadLocalController {
    @RequestMapping(value= "/threadlocal/test")
    @ResponseBody
    public Long testThreadLocal(){
        return RequestHolder.getId();
    }
}
