package com.bjfu.suyi.movie.controller;

import com.bjfu.suyi.movie.common.pojo.SverResponse;
import com.bjfu.suyi.movie.model.Star;
import com.bjfu.suyi.movie.model.User;
import com.bjfu.suyi.movie.service.StarService;
import com.bjfu.suyi.movie.service.UserService;
import com.bjfu.suyi.movie.utils.ConstUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(produces = "application/json;charset=UTF-8")
public class UserController {
    @Resource
    UserService userService;
    @Resource
    StarService starService;

    /**
     * 前台用户登录
     *
     * @param account
     * @param password
     * @param session
     * @return
     */
    @RequestMapping(value = "do_login", method = RequestMethod.POST)
    @CrossOrigin
    public SverResponse<User> doLogin(String account, String password, HttpSession session) {
        SverResponse<User> response = userService.doLogin(account, password);

        if (response.getData() == null) {
//            System.out.print(response.getData().getNId());
            // user does not exit
            return SverResponse.createByErrorMessage("用户名或密码错误");
        } else {
            session.setAttribute("LoginUserId",response.getData().getNId()); // user

        }

        return response;
    }

    /**
     * 用户注册
     *
     * @param username
     * @param email
     * @param phone
     * @param password
     * @return
     */
    @RequestMapping(value = "do_register", method = RequestMethod.POST)
    @CrossOrigin
    public SverResponse<String> doRegister(String username, String email, String phone, String password) {

        User user1 = userService.selectUserByEmail(email);
        if (user1 != null) {
            return SverResponse.createByErrorMessage("邮箱已存在");
        }
        User user2 = userService.selectUserByuserName(username);
        if (user2 != null) {
            return SverResponse.createByErrorMessage("用户名已存在");
        }
        User user = new User();
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
     *
     * @return
     */
    @RequestMapping(value = "/showUserList", method = RequestMethod.GET)
    @CrossOrigin
    public SverResponse<List<User>> showUserList() {
        return userService.showUserList();
    }

    /**
     * 后台注销用户
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteUserById", method = RequestMethod.GET)
    @CrossOrigin
    public SverResponse<String> deleteUserById(@RequestParam("id") int id) {
        return userService.deleteUserById(id);
    }

    /**
     * 查看用户详情
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/getUserDetail", method = RequestMethod.GET)
    @CrossOrigin
    public SverResponse<User> getUserDetail(@RequestParam("id") int id) {
        return userService.getUserDetail(id);
    }

    /**
     * 后台编辑用户信息
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/editUser", method = RequestMethod.POST)
    @CrossOrigin
    public SverResponse<String> editUser(@RequestBody User user) {
        return userService.editUser(user);
    }

    /**
     * 前台个人中心
     * @param session
     * @return
     */
    @RequestMapping(value = "/showUserDetail", method = RequestMethod.GET)
    @CrossOrigin
    public SverResponse<User> showUserDetail(HttpSession session) {
        int LoginUserId= (int) session.getAttribute("LoginUserId");

        User u=userService.selectByPrimaryKey(LoginUserId);
        return SverResponse.createRespBySuccess(u);
    }

    /**
     * 高级用户评星
     * @param userId
     * @param movieId
     * @param rate
     * @return
     */
    @RequestMapping(value = "/doRate", method = RequestMethod.GET)
    @CrossOrigin
    public int doRate(@RequestParam("userId") int userId,
                                       @RequestParam("movieId") int movieId,
                                       @RequestParam("rate") double rate){
        Star s=new Star();
        s.setNPowerId(userId);
        s.setNMovieId(movieId);
        s.setNStar(rate);
        return starService.insert(s);
    }
}
