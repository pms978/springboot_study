package com.park.spring_study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class HelloController {
    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "<head>경은아 안뇽!! 나 민수다 하하하하하하하하</head>";
    }


}
