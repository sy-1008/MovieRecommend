package com.bjfu.suyi.movie.service;

import com.bjfu.suyi.movie.common.pojo.SverResponse;
import com.bjfu.suyi.movie.model.Test;

import java.util.List;

public interface TestService{


    int deleteByPrimaryKey(Integer nId);

    int insert(Test record);

    int insertSelective(Test record);

    Test selectByPrimaryKey(Integer nId);

    int updateByPrimaryKeySelective(Test record);

    int updateByPrimaryKey(Test record);

    SverResponse<List<Test>> showTestList();
    int checkanswer(int testId,String userAnswer);
}
