package com.bjfu.suyi.movie.mapper;

import com.bjfu.suyi.movie.model.Movies;
import org.apache.ibatis.annotations.Mapper;import org.apache.ibatis.annotations.ResultMap;import org.apache.ibatis.annotations.Select;import java.util.List;

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

    @ResultMap("BaseResultMap")
    @Select("select * from movies where c_name LIKE '%${searchName}%' ")
    List<Movies> showMoviesBySearchName(String searchName);

    @ResultMap("BaseResultMap")
//    @Select("select * from movies " +
//            "where movies.c_movie_language LIKE '%${movieLanguage}%'and c_movie_type=#{movieType} and c_name LIKE '%${searchName}%'")

    @Select({"<script>",
            "SELECT * FROM movies",
            "WHERE 1=1",
            "<if test='movieLanguage!=null and movieLanguage!=\"\"'>",
            "AND movies.c_movie_language LIKE '%${movieLanguage}%'",
            "</if>",
            "<if test='movieType!=null and movieType!=\"\"'>",
            "AND c_movie_type=#{movieType} ",
            "</if>",
            "<if test='searchName!=null and searchName!=\"\"'>",
            "AND c_name LIKE '%${searchName}%'",
            "</if>",
            "</script>"})
    List<Movies> multiconditionalSearch(String searchName, String movieType, String movieLanguage);

    /**
     * 最新上线
     *
     * @return
     */
    @ResultMap("BaseResultMap")
    @Select("select * from movies where d_release_date>='2021-1-01' ")
    List<Movies> findNewMovies();

    /**
     * 分类查看
     *
     * @return
     */
    @ResultMap("BaseResultMap")
    @Select("select * from movies where c_movie_type=#{type} ")
    List<Movies> getMovieListByType(String type);
}