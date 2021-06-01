package com.bjfu.suyi.movie.service;

import com.bjfu.suyi.movie.common.pojo.SverResponse;
import com.bjfu.suyi.movie.model.Movies;

import java.util.Date;
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

    SverResponse<List<Movies>> showMoviesBySearchName(String searchName);

    SverResponse<List<Movies>> multiconditionalSearch(String searchName, String movieType, String movieLanguage);

    SverResponse<List<Movies>> getMovieListByType(String type);

    SverResponse<String> addMovie(Movies movies);

    SverResponse<String> editMovie(Movies movies);

    SverResponse<String> deleteMovieById(int id);
}



