package com.itangcent.springboot.demo.swagger.controller;

import com.itangcent.common.dto.Result;
import com.itangcent.common.model.UserInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "swagger")
@Api(value = "这是@Api swagger测试 SwaggerDemoController", tags = "swagger测试 SwaggerDemoController", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class SwaggerDemoController {

    @RequestMapping(value = "/index", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    @ApiOperation(value = "打个招呼接口")
    public String greeting() {
        return "hello world";
    }

    @ApiOperation(value = "设置接口", notes = "这是设置接口")
    @RequestMapping(value = "/set", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponse(code = 300, message = "这是响应", response = UserInfo.class)
    @ApiParam(value = "这是入参id", name = "这是method's name", defaultValue = "1")
    public Object set(
            @ApiParam(value = "这是入参id", name = "这是param's name", defaultValue = "1")
                    long id,
            @ApiParam(value = "入参新名字",defaultValue = "默认名字")
            @RequestParam String newName,
            @ApiParam(value = "入参哈哈哈", required = true,defaultValue = "默认无")
            @RequestParam(required = false, defaultValue = "haha") String slogon,
            @ApiParam(value = "入参times",defaultValue = "20")
            @RequestParam(required = false, defaultValue = "11")
                    long times) {

        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        userInfo.setName(newName);
        userInfo.setAge(45);
        return Result.success(userInfo);
    }
}
