package com.bjfu.suyi.movie.service;

import com.bjfu.suyi.movie.model.Poweruser;
public interface PoweruserService{


    int deleteByPrimaryKey(Integer nId);

    int insert(Poweruser record);

    int insertSelective(Poweruser record);

    Poweruser selectByPrimaryKey(Integer nId);

    int updateByPrimaryKeySelective(Poweruser record);

    int updateByPrimaryKey(Poweruser record);

}
