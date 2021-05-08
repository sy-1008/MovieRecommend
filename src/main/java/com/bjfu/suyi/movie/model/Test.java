package com.bjfu.suyi.movie.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Test implements Serializable {
    private Integer nId;

    /**
    * 问题题目
    */
    private String cQues;

    private String cAnswer1;

    private String cAnswer3;

    /**
    * 正确答案
    */
    private String cAnswer;

    private String cAnswer2;

    /**
    * 题目分值
    */
    private Integer nScore;

    private static final long serialVersionUID = 1L;
}