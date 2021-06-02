package com.bjfu.suyi.movie.service.impl;

import com.bjfu.suyi.movie.common.pojo.SverResponse;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.bjfu.suyi.movie.mapper.UserMapper;
import com.bjfu.suyi.movie.model.User;
import com.bjfu.suyi.movie.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public int deleteByPrimaryKey(Integer nId) {
        return userMapper.deleteByPrimaryKey(nId);
    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public User selectByPrimaryKey(Integer nId) {
        return userMapper.selectByPrimaryKey(nId);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    @Override
    public int  updateScore(int userId, int addScore) {

        return userMapper.updateScore(userId,addScore);
    }

    @Override
    public int updateRole(int userId) {
        return userMapper.updateRole(userId);
    }

    @Override
    public SverResponse<User> doLogin(String account, String password) {
        int result = userMapper.checkUserByAccount(account);
        if (result == 0) {
            return SverResponse.createByErrorMessage("用户不存在!");
        }

        User user = userMapper.findUserByAccountAndPwd(account, password);

        if (user == null) {
            return SverResponse.createByErrorMessage("密码错误！");
        }

        return SverResponse.createRespBySuccess("登录成功！", user);
    }

    @Override
    public SverResponse<User> getUserDetail(int id) {
        User user = userMapper.selectByPrimaryKey(id);
        if (user == null) {
            return SverResponse.createByErrorMessage("用户不存在");
        }
        return SverResponse.createRespBySuccess(user);
    }

    @Override
    public User selectUserByEmail(String email) {
        return userMapper.selectUserByEmail(email);
    }

    @Override
    public User selectUserByuserName(String name) {
        return userMapper.selectUserByuserName(name);
    }

    @Override
    public SverResponse<List<User>> showUserList() {
        return SverResponse.createRespBySuccess(userMapper.showUserList());
    }

    @Override
    public SverResponse<String> deleteUserById(int id) {
        userMapper.deleteByPrimaryKey(id);
        return SverResponse.createRespBySuccess("注销用户成功");
    }

    @Override
    public SverResponse<String> editUser(User user) {
        userMapper.updateByPrimaryKey(user);
        return SverResponse.createRespBySuccess("编辑用户成功");
    }


}


