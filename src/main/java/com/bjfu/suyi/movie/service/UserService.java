package com.bjfu.suyi.movie.service;

import com.bjfu.suyi.movie.common.pojo.SverResponse;
import com.bjfu.suyi.movie.model.User;

import java.util.List;

public interface UserService {


    int deleteByPrimaryKey(Integer nId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer nId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int updateScore(int userId, int addScore);

    int updateRole(int userId);

    SverResponse<User> doLogin(String account, String password);

    SverResponse<User> getUserDetail(int id);

    User selectUserByEmail(String email);

    User selectUserByuserName(String name);

    SverResponse<List<User>> showUserList();

    SverResponse<String> deleteUserById(int id);

    SverResponse<String> editUser(User user);
}


