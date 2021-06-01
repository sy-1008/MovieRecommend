package com.bjfu.suyi.movie;

import com.bjfu.suyi.movie.mapper.MoviesMapper;
import com.bjfu.suyi.movie.model.Movies;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.InitBinder;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class MovieSelectByIdTest {
    @Resource
    MoviesMapper moviesMapper;
    @Test
    void getMoviesById(){
        Movies movies=moviesMapper.selectByPrimaryKey(1);
        List<Movies> hotmovies=moviesMapper.findHotMovies();
        List<Movies> moviesList=moviesMapper.showMoviesList();
        System.out.println( movies.getCName());
        System.out.println( hotmovies.size());
        System.out.println( moviesList.get(1).getCName());
    }
    @Test
 void Search(){
        List<Movies> moviesList=moviesMapper.multiconditionalSearch("","","英语");
        System.out.print(moviesList.size());
 }

}
