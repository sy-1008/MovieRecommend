package com.bjfu.suyi.movie.service.impl;

import com.bjfu.suyi.movie.common.pojo.SverResponse;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.bjfu.suyi.movie.mapper.MoviesMapper;
import com.bjfu.suyi.movie.model.Movies;
import com.bjfu.suyi.movie.service.MoviesService;

import java.util.Date;
import java.util.List;

@Service
public class MoviesServiceImpl implements MoviesService {

    @Resource
    private MoviesMapper moviesMapper;

    @Override
    public int deleteByPrimaryKey(Integer nId) {
        return moviesMapper.deleteByPrimaryKey(nId);
    }

    @Override
    public int insert(Movies record) {
        return moviesMapper.insert(record);
    }

    @Override
    public int insertSelective(Movies record) {
        return moviesMapper.insertSelective(record);
    }

    @Override
    public Movies selectByPrimaryKey(Integer nId) {
        return moviesMapper.selectByPrimaryKey(nId);
    }

    @Override
    public int updateByPrimaryKeySelective(Movies record) {
        return moviesMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Movies record) {
        return moviesMapper.updateByPrimaryKey(record);
    }

    @Override
    public SverResponse<List<Movies>> showMoviesList() {
        return SverResponse.createRespBySuccess(moviesMapper.showMoviesList());
    }

    @Override
    public SverResponse<List<Movies>> findHotMovies() {
        return SverResponse.createRespBySuccess(moviesMapper.findHotMovies());
    }

    @Override
    public SverResponse<List<Movies>> findNewMovies() {
        return SverResponse.createRespBySuccess(moviesMapper.findNewMovies());
    }

    @Override
    public SverResponse<Movies> getMovieDetail(int id) {
        Movies movies = moviesMapper.selectByPrimaryKey(id);
        if (movies == null) {
            return SverResponse.createByErrorMessage("电影不存在");
        }
        return SverResponse.createRespBySuccess(movies);
    }

    @Override
    public SverResponse<List<Movies>> showMoviesBySearchName(String searchName) {
        List<Movies> movies = moviesMapper.showMoviesBySearchName(searchName);
        if (movies == null) {
            return SverResponse.createByErrorMessage("电影不存在");
        }
        return SverResponse.createRespBySuccess(movies);
    }

    @Override
    public SverResponse<List<Movies>> multiconditionalSearch(String searchName, String movieType, String movieLanguage) {
        return SverResponse.createRespBySuccess(moviesMapper.multiconditionalSearch(searchName, movieType, movieLanguage));
    }

    @Override
    public SverResponse<List<Movies>> getMovieListByType(String type) {
        return SverResponse.createRespBySuccess(moviesMapper.getMovieListByType(type));
    }

    @Override
    public SverResponse<String> addMovie(Movies movies) {
        moviesMapper.insert(movies);
        return SverResponse.createRespBySuccess("增加电影成功");
    }

    @Override
    public SverResponse<String> editMovie(Movies movies) {
        moviesMapper.updateByPrimaryKey(movies);
        return SverResponse.createRespBySuccess("编辑电影成功");
    }

    @Override
    public SverResponse<String> deleteMovieById(int id) {
        moviesMapper.deleteByPrimaryKey(id);
        return SverResponse.createRespBySuccess("删除电影成功");
    }


}




