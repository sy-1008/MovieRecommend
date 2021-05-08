package com.bjfu.suyi.movie.controller;

import com.bjfu.suyi.movie.common.pojo.SverResponse;
import com.bjfu.suyi.movie.model.Movies;
import com.bjfu.suyi.movie.service.MoviesService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
@RestController
@RequestMapping(produces = "application/json;charset=UTF-8")
public class MovieController {
    @Resource
    private MoviesService moviesService;

    /**
     * 电影列表展示
     * @return
     */
    @RequestMapping(value = "/showMoviesList",method = RequestMethod.GET)
    public SverResponse<List<Movies>>showMoviesList(){
        return moviesService.showMoviesList();
    }

    /**
     * 热门电影展示
     * @return
     */
     @RequestMapping(value = "/findHotMovies",method = RequestMethod.GET)
    public SverResponse<List<Movies>>findHotMovies(){return moviesService.findHotMovies();}
    /**
     * 最新上线电影
     * @return
     */
    @RequestMapping(value = "/findNewMovies",method = RequestMethod.GET)
    public SverResponse<List<Movies>>findNewMovies(){return moviesService.findNewMovies();}
    /**
     * 查看电影详情
     * @param id
     * @return
     */
    @RequestMapping(value = "/getMovieDetail",method = RequestMethod.GET)
    public SverResponse<Movies>getMovieDetail(@RequestParam("id") int id){
         return moviesService.getMovieDetail(id);
    }
}
