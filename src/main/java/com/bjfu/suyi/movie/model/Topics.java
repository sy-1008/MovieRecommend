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
public class Topics implements Serializable {
    private Integer nId;

    private Integer nMovieId;

    /**
    * 电影类型名
    */
    private String cName;

    private static final long serialVersionUID = 1L;
}