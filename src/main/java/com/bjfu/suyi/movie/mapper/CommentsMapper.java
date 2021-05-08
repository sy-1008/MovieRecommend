package com.bjfu.suyi.movie.mapper;

import com.bjfu.suyi.movie.model.Comments;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentsMapper {
    int deleteByPrimaryKey(Integer nId);

    int insert(Comments record);

    int insertSelective(Comments record);

    Comments selectByPrimaryKey(Integer nId);

    int updateByPrimaryKeySelective(Comments record);

    int updateByPrimaryKey(Comments record);
}