package com.bjfu.suyi.movie.mapper;

import com.bjfu.suyi.movie.model.Poweruser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PoweruserMapper {
    int deleteByPrimaryKey(Integer nId);

    int insert(Poweruser record);

    int insertSelective(Poweruser record);

    Poweruser selectByPrimaryKey(Integer nId);

    int updateByPrimaryKeySelective(Poweruser record);

    int updateByPrimaryKey(Poweruser record);
}