package com.park.spring_study.controller;

import com.sun.org.apache.xpath.internal.operations.String;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetContoller {
    //http://127.0.0.1:8080/api/v1/get-api/hello
    @GetMapping("/hello")
    public String getHello(){
        return "Hello World";
    }
    //http://127.0.0.1:8080/api/v1/get-api/variable1/test
    @GetMapping(value = "/variable1/{var}") // {var} 중괄호 안의 var은 아래 String 변수의 var 와 일치해야함
    public String getVariable1(@PathVariable String var){
        return var;
    }

    @GetMapping(value = "/variable2/{var}") // {var} 중괄호 안의 var은 아래 PathVariable 값 var 와 일치해야함
    public String getVariable2(@PathVariable("var") String var){
        return var;
    }

    @GetMapping(value = "/request1") // {var} 중괄호 안의 var은 아래 String 변수의 var 와 일치해야함
    public String getRequestParam(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization
    ){
        return name + " " + email + " " + organization;
    }

    @GetMapping(value = "/request2") // {
    public String getRequestParam2(@RequestParam Map<String, String> param){
        StringBuilder sb = new StringBuilder();

        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }
}
