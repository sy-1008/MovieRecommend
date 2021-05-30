package com.bjfu.suyi.movie.service.impl;

import com.bjfu.suyi.movie.common.pojo.SverResponse;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.bjfu.suyi.movie.mapper.CommentsMapper;
import com.bjfu.suyi.movie.model.Comments;
import com.bjfu.suyi.movie.service.CommentsService;

import java.util.Date;

@Service
public class CommentsServiceImpl implements CommentsService{

    @Resource
    private CommentsMapper commentsMapper;

    @Override
    public int deleteByPrimaryKey(Integer nId) {
        return commentsMapper.deleteByPrimaryKey(nId);
    }

    @Override
    public int insert(Comments record) {
        return commentsMapper.insert(record);
    }

    @Override
    public int insertSelective(Comments record) {
        return commentsMapper.insertSelective(record);
    }

    @Override
    public Comments selectByPrimaryKey(Integer nId) {
        return commentsMapper.selectByPrimaryKey(nId);
    }

    @Override
    public int updateByPrimaryKeySelective(Comments record) {
        return commentsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Comments record) {
        return commentsMapper.updateByPrimaryKey(record);
    }

    @Override
    public SverResponse<String> createComments(Integer userId,Integer movieId, Comments comments) {
        comments.setNPowerId(userId);
        comments.setNMovieId(movieId);
        Date date = new Date();
        comments.setDCreateTime(date);
        int rs = commentsMapper.insert(comments);
        if (rs > 0) {
            return SverResponse.createRespBySuccess("评论发布成功");
        }
        return SverResponse.createByErrorMessage("评论发布失败");
    }

    @Override
    public SverResponse<String> deleteComment(int uid, int mid) {
        commentsMapper.deleteComment(uid,mid);
        return SverResponse.createRespBySuccess("评论删除成功");
    }
}
