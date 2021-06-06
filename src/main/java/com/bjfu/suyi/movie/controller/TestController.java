package com.bjfu.suyi.movie.controller;

import com.bjfu.suyi.movie.common.pojo.SverResponse;
import com.bjfu.suyi.movie.model.Powertest;
import com.bjfu.suyi.movie.model.PowertestTest;
import com.bjfu.suyi.movie.model.Test;
import com.bjfu.suyi.movie.model.User;
import com.bjfu.suyi.movie.service.PowertestService;
import com.bjfu.suyi.movie.service.PowertestTestService;
import com.bjfu.suyi.movie.service.TestService;
import com.bjfu.suyi.movie.service.UserService;
import org.springframework.web.bind.annotation.*;

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
    @Resource
    private PowertestService powertestService;
    @Resource
    private PowertestTestService powertestTestService;

    @RequestMapping(value = "/showTestList", method = RequestMethod.GET)
    public SverResponse<List<Test>> showTestList() {
        return testService.showTestList();
    }

    /**
     * 高级用户查看出题记录
     *
     *
     * @return
     */
    @RequestMapping(value = "/showTestListByUserId", method = RequestMethod.GET)
    @CrossOrigin
    public SverResponse<List<PowertestTest>> showTestListByUserId(@RequestParam("userId") int nId) {

        return powertestTestService.showTestListByUserId(nId);
    }

    /**
     * 高级用户删除出题记录
     * @param testId
     * @param userId
     * @return
     */
    @RequestMapping(value = "/deleteTestByTestIdandPowerId", method = RequestMethod.GET)
    @CrossOrigin
    public SverResponse<String> deleteTestByTestIdandPowerId(@RequestParam("testId") int testId,
                                                             @RequestParam("userId") int userId){
        testService.deleteByPrimaryKey(testId);
        powertestService.deleteByTestIDandUserId(testId,userId);
        return SverResponse.createRespBySuccess("删除题目成功！");
    }
    /**
     * 普通用户答题
     *
     * @param testId
     * @param userAnswer
     * @param session
     * @return
     */
    @RequestMapping(value = "/checkanswer", method = RequestMethod.GET)
    public SverResponse<String> checkanswer(@RequestParam("testId") int testId, @RequestParam("userAnswer") String userAnswer, HttpSession session) {
        int flag = testService.checkanswer(testId, userAnswer);
        Test test = testService.selectByPrimaryKey(testId);
        if (flag == 1) {
            int addscore = test.getNScore();
            int LoginUserId = (int) session.getAttribute("LoginUserId");
            userService.updateScore(LoginUserId, addscore);
            User uu = userService.selectByPrimaryKey(LoginUserId);
            if (uu.getNScore() >= 60) {
                userService.updateRole(LoginUserId);
            }
            return SverResponse.createRespBySuccess("答题正确，积分已更新");
        } else
            return SverResponse.createByErrorMessage("答案错误！");
    }

    /**
     * 高级用户出题
     *
     * @param cques
     * @param canswer1
     * @param canswer2
     * @param canswer3
     * @param canswer
     * @param nscore
     * @param session
     * @return
     */
    @RequestMapping(value = "/addTest", method = RequestMethod.GET)
    public SverResponse<String> addTest(@RequestParam("cques") String cques,
                                        @RequestParam("canswer1") String canswer1,
                                        @RequestParam("canswer2") String canswer2,
                                        @RequestParam("canswer3") String canswer3,
                                        @RequestParam("canswer") String canswer,
                                        @RequestParam("nscore") int nscore,
                                        HttpSession session
    ) {
        Test test = new Test();
        test.setCQues(cques);
        test.setCAnswer1(canswer1);
        test.setCAnswer2(canswer2);
        test.setCAnswer3(canswer3);
        test.setCAnswer(canswer);
        test.setNScore(nscore);
        testService.insert(test);
//更新出题表
        int LoginUserId = (int) session.getAttribute("LoginUserId");
        Test test1 = testService.selectByCque(cques);
        Powertest powertest = new Powertest();
        powertest.setNPowerId(LoginUserId);
        powertest.setNTestId(test1.getNId());
        powertestService.insert(powertest);
        return SverResponse.createRespBySuccess("出题成功！");
    }


}
