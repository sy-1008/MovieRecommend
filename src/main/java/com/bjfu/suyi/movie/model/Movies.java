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
public class Movies implements Serializable {
    private Integer nId;

    private String cName;

    /**
     * 电影时长
     */
    private Integer nFilmLength;

    /**
     * 上映时间
     */
    private Date dReleaseDate;

    /**
     * 影片简介
     */
    private String cInfo;

    /**
     * 影片类型
     */
    private String cMovieType;

    /**
     * 影片语言
     */
    private String cMovieLanguage;

    private String cMovieCover;

    /**
     * 电影评分
     */
    private Double fMovieScore;

    /**
     * 热门电影1
     */
    private Integer nIsHot;

    /**
     * 电影观看次数
     */
    private Integer nViews;

    private static final long serialVersionUID = 1L;

    public static MoviesBuilder builder() {
        return new MoviesBuilder();
    }
}