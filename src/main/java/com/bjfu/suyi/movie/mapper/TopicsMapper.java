package com.bjfu.suyi.movie.mapper;

import com.bjfu.suyi.movie.model.Topics;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TopicsMapper {
    int deleteByPrimaryKey(Integer nId);

    int insert(Topics record);

    int insertSelective(Topics record);

    Topics selectByPrimaryKey(Integer nId);

    int updateByPrimaryKeySelective(Topics record);

    int updateByPrimaryKey(Topics record);
}