package com.bjfu.suyi.movie.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.bjfu.suyi.movie.model.Poweruser;
import com.bjfu.suyi.movie.mapper.PoweruserMapper;
import com.bjfu.suyi.movie.service.PoweruserService;
@Service
public class PoweruserServiceImpl implements PoweruserService{

    @Resource
    private PoweruserMapper poweruserMapper;

    @Override
    public int deleteByPrimaryKey(Integer nId) {
        return poweruserMapper.deleteByPrimaryKey(nId);
    }

    @Override
    public int insert(Poweruser record) {
        return poweruserMapper.insert(record);
    }

    @Override
    public int insertSelective(Poweruser record) {
        return poweruserMapper.insertSelective(record);
    }

    @Override
    public Poweruser selectByPrimaryKey(Integer nId) {
        return poweruserMapper.selectByPrimaryKey(nId);
    }

    @Override
    public int updateByPrimaryKeySelective(Poweruser record) {
        return poweruserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Poweruser record) {
        return poweruserMapper.updateByPrimaryKey(record);
    }

}
