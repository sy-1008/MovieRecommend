package com.bjfu.suyi.movie.mapper;

import com.bjfu.suyi.movie.model.Test;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TestMapper {
    int deleteByPrimaryKey(Integer nId);

    int insert(Test record);

    int insertSelective(Test record);

    Test selectByPrimaryKey(Integer nId);

    int updateByPrimaryKeySelective(Test record);

    int updateByPrimaryKey(Test record);

    /**
     * 随机出题
     * @return
     */
    @ResultMap("BaseResultMap")
    @Select( "select * from test order by rand() limit 1")
    List<Test> showTestList();

    @ResultMap("BaseResultMap")
    @Select( "select * from test where movie.test.c_ques=#{cque}")
    Test selectByCque(String cque);
}