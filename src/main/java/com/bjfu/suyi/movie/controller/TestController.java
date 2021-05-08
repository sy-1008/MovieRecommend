package com.bjfu.suyi.movie.controller;

import com.bjfu.suyi.movie.common.pojo.SverResponse;
import com.bjfu.suyi.movie.model.Test;
import com.bjfu.suyi.movie.service.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(produces = "application/json;charset=UTF-8")
public class TestController {
    @Resource
    private TestService testService;

    @RequestMapping(value = "/showTestList",method = RequestMethod.GET)
    public SverResponse<List<Test>> showTestList(){
        return testService.showTestList();
    }
}
