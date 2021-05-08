package com.bjfu.suyi.movie.service;

import com.bjfu.suyi.movie.common.pojo.SverResponse;
import com.bjfu.suyi.movie.model.Movies;

import java.util.List;

public interface MoviesService {


    int deleteByPrimaryKey(Integer nId);

    int insert(Movies record);

    int insertSelective(Movies record);

    Movies selectByPrimaryKey(Integer nId);

    int updateByPrimaryKeySelective(Movies record);

    int updateByPrimaryKey(Movies record);

    SverResponse<List<Movies>> showMoviesList();

    SverResponse<List<Movies>> findHotMovies();

    SverResponse<List<Movies>> findNewMovies();

    SverResponse<Movies> getMovieDetail(int id);
}


