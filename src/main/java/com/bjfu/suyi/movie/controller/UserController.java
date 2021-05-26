package com.bjfu.suyi.movie.controller;

import com.bjfu.suyi.movie.common.pojo.SverResponse;
import com.bjfu.suyi.movie.model.User;
import com.bjfu.suyi.movie.service.UserService;
import com.bjfu.suyi.movie.utils.ConstUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(produces = "application/json;charset=UTF-8")
public class UserController {
    @Resource
    UserService userService;

    /**
     * 前台用户登录
     * @param account
     * @param password
     * @param session
     * @return
     */
    @RequestMapping(value = "do_login",method = RequestMethod.POST)
    public SverResponse<User>doLogin(String account,String password, HttpSession session){
        SverResponse<User> response = userService.doLogin(account, password);
        if (response.getData() == null) {
            // user does not exit
            return SverResponse.createByErrorMessage("用户名或密码错误");
        } else {
            session.setAttribute(ConstUtil.CUR_USER, response.getData()); // user
        }
        return response;
    }

    /**
     * 用户注册
     * @param username
     * @param email
     * @param phone
     * @param password
     * @return
     */
    @RequestMapping(value = "do_register",method = RequestMethod.POST)
    public SverResponse<String> doRegister(String username,String email,String phone,String password){

        User user1=userService.selectUserByEmail(email);
        if(user1!=null){
            return SverResponse.createByErrorMessage("邮箱已存在");
        }
        User user2=userService.selectUserByuserName(username);
        if(user2!= null){
            return SverResponse.createByErrorMessage("用户名已存在");
        }
        User user=new User();
        user.setCEmail(email);
        user.setCPassword(password);
        user.setCUsername(username);
        user.setCPhonenum(phone);
        user.setRole(1);//普通用户

        userService.insert(user);
        return SverResponse.createRespBySuccessMessage("用户注册成功");
    }

    /**
     * 后台用户列表
     * @return
     */
    @RequestMapping(value = "/showUserList", method = RequestMethod.GET)
    public SverResponse<List<User>> showUserList(){
        return userService.showUserList();
    }
}
