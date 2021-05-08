package com.bjfu.suyi.movie.mapper;

import com.bjfu.suyi.movie.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer nId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer nId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    @Select("select count(1) from user where c_username=#{account}")
    int checkUserByAccount(String account);

    @ResultMap("BaseResultMap")
    @Select("select * from user where c_username=#{account} and c_password=#{password}")
    User findUserByAccountAndPwd(String account, String password);

    @Select("select * from user where c_email=#{email}")
    User selectUserByEmail(String email);

    @Select("select * from user where c_username=#{name}")
    User selectUserByuserName(String name);

}