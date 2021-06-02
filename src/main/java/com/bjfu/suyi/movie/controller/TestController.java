package com.bjfu.suyi.movie.controller;

import com.bjfu.suyi.movie.common.pojo.SverResponse;
import com.bjfu.suyi.movie.model.Test;
import com.bjfu.suyi.movie.model.User;
import com.bjfu.suyi.movie.service.TestService;
import com.bjfu.suyi.movie.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(produces = "application/json;charset=UTF-8")
public class TestController {
    @Resource
    private TestService testService;
    @Resource
    private UserService userService;
    @RequestMapping(value = "/showTestList",method = RequestMethod.GET)
    public SverResponse<List<Test>> showTestList(){
        return testService.showTestList();
    }

    /**
     * 普通用户答题
     * @param testId
     * @param userAnswer
     * @param session
     * @return
     */
    @RequestMapping(value = "/checkanswer",method = RequestMethod.GET)
    public SverResponse<String> checkanswer(@RequestParam("testId") int testId, @RequestParam("userAnswer") String userAnswer, HttpSession  session){
         int flag=testService.checkanswer(testId,userAnswer);
         Test test=testService.selectByPrimaryKey(testId);
         if(flag==1){
             int addscore=test.getNScore();
             int LoginUserId= (int) session.getAttribute("LoginUserId");
             userService.updateScore(LoginUserId,addscore);
             User uu=userService.selectByPrimaryKey(LoginUserId);
             if(uu.getNScore()>=60){
                 userService.updateRole(LoginUserId);
             }
             return SverResponse.createRespBySuccess("答题正确，积分已更新");
         }
         else
             return SverResponse.createByErrorMessage("答案错误！");
    }
}
