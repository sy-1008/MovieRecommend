package com.bjfu.suyi.movie.service.impl;

import com.bjfu.suyi.movie.common.pojo.SverResponse;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.bjfu.suyi.movie.mapper.UserMapper;
import com.bjfu.suyi.movie.model.User;
import com.bjfu.suyi.movie.service.UserService;

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
    public SverResponse<User> doLogin(String account, String password) {
        int result = userMapper.checkUserByAccount(account);
        if (result == 0) {
            // user does not exist, return info
            return SverResponse.createByErrorMessage("用户不存在!");
        }

        User user = userMapper.findUserByAccountAndPwd(account, password);

        if (user == null) {
            return SverResponse.createByErrorMessage("密码错误！");
        }

        return SverResponse.createRespBySuccess("登录成功！", user);
    }

    @Override
    public User selectUserByEmail(String email) {
        return userMapper.selectUserByEmail(email);
    }

    @Override
    public User selectUserByuserName(String name) {
        return userMapper.selectUserByuserName(name);
    }


}

