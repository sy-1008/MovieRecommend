package com.bjfu.suyi.movie.model;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Comments implements Serializable {
    private Integer nId;

    private Integer nPowerId;

    private Integer nMovieId;

    /**
    * 评论时间
    */
    private Date dCreateTime;

    /**
    * 评论内容
    */
    private String cContent;

    private static final long serialVersionUID = 1L;
}