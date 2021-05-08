package com.bjfu.suyi.movie.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.bjfu.suyi.movie.model.Topics;
import com.bjfu.suyi.movie.mapper.TopicsMapper;
import com.bjfu.suyi.movie.service.TopicsService;
@Service
public class TopicsServiceImpl implements TopicsService{

    @Resource
    private TopicsMapper topicsMapper;

    @Override
    public int deleteByPrimaryKey(Integer nId) {
        return topicsMapper.deleteByPrimaryKey(nId);
    }

    @Override
    public int insert(Topics record) {
        return topicsMapper.insert(record);
    }

    @Override
    public int insertSelective(Topics record) {
        return topicsMapper.insertSelective(record);
    }

    @Override
    public Topics selectByPrimaryKey(Integer nId) {
        return topicsMapper.selectByPrimaryKey(nId);
    }

    @Override
    public int updateByPrimaryKeySelective(Topics record) {
        return topicsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Topics record) {
        return topicsMapper.updateByPrimaryKey(record);
    }

}
