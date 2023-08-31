package com.park.spring_study.controller;

import com.park.spring_study.dto.MemberDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetContoller {

    private final Logger LOGGER = LoggerFactory.getLogger(GetContoller.class);
    //http://127.0.0.1:8080/api/v1/get-api/hello
    @GetMapping("/hello")
    public String getHello(){
        LOGGER.info("call getHello() Method");
        return "Hello World";
    }
    //http://127.0.0.1:8080/api/v1/get-api/variable1/test
    @GetMapping(value = "/variable1/{var}") // {var} 중괄호 안의 var은 아래 String 변수의 var 와 일치해야함
    public String getVariable1(@PathVariable String var){
        LOGGER.info("call getVariable1");
        LOGGER.info("@PathVaruable을 통해 들어온 값 : {}", var);
        return var;
    }

    @GetMapping(value = "/variable2/{var}") // {var} 중괄호 안의 var은 아래 PathVariable 값 var 와 일치해야함
    public String getVariable2(@PathVariable("var") String var){
        LOGGER.info("call getVariable2");
        LOGGER.info("@PathVaruable을 통해 들어온 값 : " + var); //2ms
        return var;
    }

    @ApiOperation(value = "GET 메서드 예제", notes = "@RequestParam을 활용한 GET Method")
    //http://127.0.0.1:8080/api/v1/get-api/request1?name=박민수&organization=지티원&email=dwoz@gtone.co.kr
    @GetMapping(value = "/request1") // 쿼리스트링의 key 값이 변수값과 일치해야함
    public String getRequestParam(
            @ApiParam(value = "이름", required = true) @RequestParam String name,
            @ApiParam(value = "이메일", required = true)@RequestParam String email,
            @ApiParam(value = "회사", required = true)@RequestParam String organization
    ){
        LOGGER.info("call getRequestParam");
        LOGGER.info("@RequestParam을 통해 들어온 name : ".concat(name) );
        LOGGER.info("@RequestParam을 통해 들어온 email : ".concat(email) );
        LOGGER.info("@RequestParam을 통해 들어온 email : ".concat(organization) );
        return name + " " + email + " " + organization;
    }

    @GetMapping(value = "/request2") // {
    public String getRequestParam2(@RequestParam Map<String, String> param){
        LOGGER.info("call getRequestParam2");

        StringBuilder sb = new StringBuilder();

        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    @GetMapping(value = "/request3") // {
    public String getRequestParam3(MemberDto memberDto){
        return memberDto.toString();
    }
}
