package com.bjfu.suyi.movie.mapper;

import com.bjfu.suyi.movie.model.Comments;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CommentsMapper {
    int deleteByPrimaryKey(Integer nId);

    int insert(Comments record);

    int insertSelective(Comments record);

    Comments selectByPrimaryKey(Integer nId);

    int updateByPrimaryKeySelective(Comments record);

    int updateByPrimaryKey(Comments record);

    @ResultMap("BaseResultMap")
    @Delete("delete from comments where n_power_id=#{uid} and n_movie_id=#{mid}")
    int deleteComment(int uid, int mid);
}