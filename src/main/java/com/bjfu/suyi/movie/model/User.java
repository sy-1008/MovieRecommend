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
public class User implements Serializable {
    private Integer nId;

    private String cUsername;

    private String cPhonenum;

    private String cEmail;

    private String cPassword;

    /**
     * 用户类型 0管理员 1普通用户 2高级用户
     */
    private Integer role;

    private String cUserImage;

    /**
     * 用户积分
     */
    private Integer nScore;

    private static final long serialVersionUID = 1L;

    public static UserBuilder builder() {
        return new UserBuilder();
    }
}