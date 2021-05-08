package com.bjfu.suyi.movie.utils;

public class ConstUtil {
    public static final String CUR_USER = "curUser";
    public static final String TYPE_ACCOUNT = "account";
    public static final String TYPE_EMAIL = "email";
    //public static final String TYPE_PHONE = "phone";
    public static final Boolean ADDR_IS_DEFAULT = true;
    public static final Boolean ADDR_NOT_DEFAULT = false;

    public enum Role {
        // 管理员是0，普通用户是1
        ROLE_Admin(0), ROLE_CUSTOMER(1);
        int code;

        Role(int n) {
            this.code = n;
        }

        public int getCode() {
            return code;
        }
    }


    /**
     * 用户状态
     */
    public enum UserStatus {
        // true是有效，false是已删除
        DELETED(false), EXISTED(true);
        boolean status;

        UserStatus(boolean status) {
            this.status = status;
        }

        public boolean getStatus() {
            return status;
        }
    }
}
