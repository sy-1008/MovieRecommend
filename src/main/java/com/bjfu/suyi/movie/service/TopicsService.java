package com.bjfu.suyi.movie.service;

import com.bjfu.suyi.movie.model.Topics;
public interface TopicsService{


    int deleteByPrimaryKey(Integer nId);

    int insert(Topics record);

    int insertSelective(Topics record);

    Topics selectByPrimaryKey(Integer nId);

    int updateByPrimaryKeySelective(Topics record);

    int updateByPrimaryKey(Topics record);

}
