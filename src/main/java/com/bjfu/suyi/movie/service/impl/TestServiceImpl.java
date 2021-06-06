package com.bjfu.suyi.movie.service.impl;

import com.bjfu.suyi.movie.common.pojo.SverResponse;
import com.bjfu.suyi.movie.mapper.PowertestMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.bjfu.suyi.movie.mapper.TestMapper;
import com.bjfu.suyi.movie.model.Test;
import com.bjfu.suyi.movie.service.TestService;

import java.util.List;

@Service
public class TestServiceImpl implements TestService{

    @Resource
    private TestMapper testMapper;

    @Resource
    private PowertestMapper powertestMapper;

    @Override
    public int deleteByPrimaryKey(Integer nId) {
        return testMapper.deleteByPrimaryKey(nId);
    }

    @Override
    public int insert(Test record) {
        return testMapper.insert(record);
    }

    @Override
    public int insertSelective(Test record) {
        return testMapper.insertSelective(record);
    }

    @Override
    public Test selectByPrimaryKey(Integer nId) {
        return testMapper.selectByPrimaryKey(nId);
    }

    @Override
    public int updateByPrimaryKeySelective(Test record) {
        return testMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Test record) {
        return testMapper.updateByPrimaryKey(record);
    }

    @Override
    public SverResponse<List<Test>> showTestList() {
        return SverResponse.createRespBySuccess(testMapper.showTestList());
    }



    @Override
    public int checkanswer(int testId, String userAnswer) {
        Test test=testMapper.selectByPrimaryKey(testId);
        if(test.getCAnswer().equals(userAnswer)){
            return 1;
        }
        else
            return 0;
    }

    @Override
    public Test selectByCque(String cque) {
        return testMapper.selectByCque(cque);
    }

}
