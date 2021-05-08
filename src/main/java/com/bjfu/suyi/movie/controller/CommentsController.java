package com.bjfu.suyi.movie.controller;

import com.bjfu.suyi.movie.common.pojo.SverResponse;
import com.bjfu.suyi.movie.model.Comments;
import com.bjfu.suyi.movie.model.User;
import com.bjfu.suyi.movie.service.CommentsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class CommentsController {
    @Resource
    private CommentsService commentsService;
  //  @RequestMapping(value = "/createComments",method = RequestMethod.POST)
  //  public SverResponse<String> createComments(@RequestBody Comments comments, HttpSession session){
        //login?
//        User user=session.getAttribute("user");
//        return commentsService.createComments(user.getId(),movies.getNMovieId(),comments);
  //  }
}
