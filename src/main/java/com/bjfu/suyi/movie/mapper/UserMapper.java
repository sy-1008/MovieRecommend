package com.bjfu.suyi.movie.mapper;

import com.bjfu.suyi.movie.model.User;
import org.apache.ibatis.annotations.Mapper;import org.apache.ibatis.annotations.ResultMap;import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer nId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer nId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    @ResultMap("BaseResultMap")
    @Update("update user set n_score=n_score+#{addScore} where n_id=#{userId}")
    int updateScore(int userId,int addScore);
    @ResultMap("BaseResultMap")
    @Update("update user set role=2 where n_id=#{userId}")
    int updateRole(int userId);


    @Select("select count(1) from user where c_username=#{account}")
    int checkUserByAccount(String account);

    @ResultMap("BaseResultMap")
    @Select("select * from user where c_username=#{account} and c_password=#{password}")
    User findUserByAccountAndPwd(String account, String password);

    @Select("select * from user where c_email=#{email}")
    User selectUserByEmail(String email);

    @Select("select * from user where c_username=#{name}")
    User selectUserByuserName(String name);

    /**
     * 展示用户列表
     *
     * @return
     */
    @ResultMap("BaseResultMap")
    @Select("select * from user")
    List<User> showUserList();
}