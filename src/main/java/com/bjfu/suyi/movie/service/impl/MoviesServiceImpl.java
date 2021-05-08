package com.bjfu.suyi.movie.service.impl;

import com.bjfu.suyi.movie.common.pojo.SverResponse;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.bjfu.suyi.movie.mapper.MoviesMapper;
import com.bjfu.suyi.movie.model.Movies;
import com.bjfu.suyi.movie.service.MoviesService;

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
    public SverResponse<List<Movies>>  showMoviesList() {
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
}



