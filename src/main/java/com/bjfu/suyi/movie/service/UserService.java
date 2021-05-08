package com.bjfu.suyi.movie.service;

import com.bjfu.suyi.movie.common.pojo.SverResponse;
import com.bjfu.suyi.movie.model.User;

public interface UserService {


    int deleteByPrimaryKey(Integer nId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer nId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    SverResponse<User> doLogin(String account, String password);
   User selectUserByEmail(String email);
   User selectUserByuserName(String name);

}

