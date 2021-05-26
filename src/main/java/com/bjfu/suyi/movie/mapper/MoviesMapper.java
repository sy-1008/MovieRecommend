package com.bjfu.suyi.movie.mapper;

import com.bjfu.suyi.movie.model.Movies;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;import java.util.List;

@Mapper
public interface MoviesMapper {
    int deleteByPrimaryKey(Integer nId);

    int insert(Movies record);

    int insertSelective(Movies record);

    Movies selectByPrimaryKey(Integer nId);

    int updateByPrimaryKeySelective(Movies record);

    int updateByPrimaryKey(Movies record);

    /**
     * 展示电影列表
     *
     * @return
     */
    @ResultMap("BaseResultMap")
    @Select("select * from movies")
    List<Movies> showMoviesList();

    /**
     * 展示热门电影
     *
     * @return
     */
    @ResultMap("BaseResultMap")
    @Select("select * from movies where n_is_hot=1")
    List<Movies> findHotMovies();

    /**
     * 最新上线
     * @return
     */
    @ResultMap("BaseResultMap")
    @Select("select * from movies where d_release_date>='2021-1-01' ")
    List<Movies> findNewMovies();
    /**
     * 分类查看
     * @return
     */
    @ResultMap("BaseResultMap")
    @Select("select * from movies where c_movie_type=#{type} ")
    List<Movies> getMovieListByType(String type);



}