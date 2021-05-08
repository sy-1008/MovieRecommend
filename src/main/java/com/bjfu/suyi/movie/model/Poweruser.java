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
public class Poweruser implements Serializable {
    private Integer nId;

    private String cName;

    /**
    * 积分
    */
    private Integer nScore;

    private static final long serialVersionUID = 1L;
}