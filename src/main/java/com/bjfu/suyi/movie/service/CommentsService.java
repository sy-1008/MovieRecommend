package com.bjfu.suyi.movie.service;

import com.bjfu.suyi.movie.common.pojo.SverResponse;
import com.bjfu.suyi.movie.model.Comments;
public interface CommentsService{


    int deleteByPrimaryKey(Integer nId);

    int insert(Comments record);

    int insertSelective(Comments record);

    Comments selectByPrimaryKey(Integer nId);

    int updateByPrimaryKeySelective(Comments record);

    int updateByPrimaryKey(Comments record);

    SverResponse<String>createComments(Integer userId,Integer movieId,Comments comments);

    SverResponse<String> deleteComment(int uid,int mid);

}
