package com.bjfu.suyi.movie.controller;

import com.bjfu.suyi.movie.common.pojo.SverResponse;
import com.bjfu.suyi.movie.model.Comments;
import com.bjfu.suyi.movie.model.MoviesUserComments;
import com.bjfu.suyi.movie.model.User;
import com.bjfu.suyi.movie.service.CommentsService;
import com.bjfu.suyi.movie.service.MoviesUserCommentsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;


@RestController
@RequestMapping(produces = "application/json;charset=UTF-8")
public class CommentsController {
    @Resource
    private MoviesUserCommentsService moviesUserCommentsService;

    @Resource CommentsService commentsService;
    /**
     * 后台用户评论管理
     *
     * @return
     */
    @RequestMapping(value = "/showCommentsListBack", method = RequestMethod.GET)
    @CrossOrigin
    public SverResponse<List<MoviesUserComments>> showCommentsListBack() {
        return moviesUserCommentsService.showCommentsListBack();
    }

    /**
     * 后台用户评论管理--模糊搜素显示
     *
     * @return
     */
    @RequestMapping(value = "/showCommentsListBackByMovieName", method = RequestMethod.GET)
    @CrossOrigin
    public SverResponse<List<MoviesUserComments>> showCommentsListBackByMovieName(@RequestParam("searchName") String searchName) {
        return moviesUserCommentsService.showCommentsListBackByMovieName(searchName);
    }

    /**
     * 后台删除评论
     * @param uid
     * @param mid
     * @return
     */
    @RequestMapping(value = "/deleteComment", method = RequestMethod.GET)
    @CrossOrigin
    public SverResponse<String> deleteComment(@RequestParam("UserId") int uid,@RequestParam("MovieId") int mid){
        return commentsService.deleteComment(uid,mid);
    }
}
