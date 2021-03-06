package com.bjfu.suyi.movie.controller;

import com.bjfu.suyi.movie.common.pojo.SverResponse;
import com.bjfu.suyi.movie.model.Movies;
import com.bjfu.suyi.movie.model.User;
import com.bjfu.suyi.movie.service.MoviesService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(produces = "application/json;charset=UTF-8")
public class MovieController {
    @Resource
    private MoviesService moviesService;

    /**
     * 电影列表展示
     *
     * @return
     */
    @RequestMapping(value = "/showMoviesList", method = RequestMethod.GET)
    public SverResponse<List<Movies>> showMoviesList() {
        return moviesService.showMoviesList();
    }

    /**
     * 热门电影展示
     *
     * @return
     */
    @RequestMapping(value = "/findHotMovies", method = RequestMethod.GET)
    public SverResponse<List<Movies>> findHotMovies() {
        return moviesService.findHotMovies();
    }

    /**
     * 最新上线电影
     *
     * @return
     */
    @RequestMapping(value = "/findNewMovies", method = RequestMethod.GET)
    public SverResponse<List<Movies>> findNewMovies() {
        return moviesService.findNewMovies();
    }

    /**
     * 查看电影详情
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/getMovieDetail", method = RequestMethod.GET)
    public SverResponse<Movies> getMovieDetail(@RequestParam("id") int id) {
        return moviesService.getMovieDetail(id);
    }


    /**
     * 电影分类查看
     *
     * @return
     */
    @RequestMapping(value = "/getMovieListByType", method = RequestMethod.GET)
    public SverResponse<List<Movies>> getMovieListByType(@RequestParam("type") String mType) {

        return moviesService.getMovieListByType(mType);
    }

    /**
     * 后台新增电影
     *
     * @param movies
     * @return
     */

    @RequestMapping(value = "/addMovie", method = RequestMethod.POST)
    @CrossOrigin
    public SverResponse<String> addMovie(@RequestBody Movies movies) {

        return moviesService.addMovie(movies);
    }

    /**
     * 后台编辑电影信息
     *
     * @param movies
     * @return
     */
    @RequestMapping(value = "/editMovie", method = RequestMethod.POST)
    @CrossOrigin
    public SverResponse<String> editMovie(@RequestBody Movies movies) {

        return moviesService.editMovie(movies);
    }


    /**
     * 后台删除电影
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteMovieById", method = RequestMethod.GET)
    @CrossOrigin
    public SverResponse<String> deleteMovieById(@RequestParam("id") int id) {
        return moviesService.deleteMovieById(id);
    }

    /**
     * 后台搜索电影
     *
     * @param searchName
     * @return
     */
    @RequestMapping(value = "/showMoviesBySearchName", method = RequestMethod.GET)
    @CrossOrigin
    public SverResponse<List<Movies>> showMoviesBySearchName(@RequestParam("searchName") String searchName) {
        return moviesService.showMoviesBySearchName(searchName);
    }
    /**
     * 前台分类多条件搜索电影
     *
     * @param searchName
     * @return
     */
    @RequestMapping(value = "/multiconditionalSearch", method = RequestMethod.GET)
    @CrossOrigin
    public SverResponse<List<Movies>> multiconditionalSearch(@RequestParam("searchName") String searchName,
                                                             @RequestParam("movieType") String movieType,
                                                             @RequestParam("movieLanguage") String movieLanguage) throws ParseException {


        return moviesService.multiconditionalSearch(searchName,movieType,movieLanguage);
    }
}
