package com.bjfu.suyi.movie.common.pojo;
import com.google.gson.annotations.Expose;
import java.io.Serializable;

public class SverResponse<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 服务端响应到客户端的数据状态
     */
    @Expose
    private int status;
    /**
     * 状态对应的具体数据
     */
    @Expose
    private String msg;
    /**
     * 响应到客户端的具体数据
     */
    @Expose
    private T data;

    public int getStatus() {
        return this.status;
    }

    public T getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }

    //    @JsonIgnore
    public boolean isSuccess() {
        return this.status == ResponseCode.SUCCESS.getCode();
    }

    private SverResponse(int status) {
        this.status = status;
    }

    private SverResponse(int status, T data) {
        this.status = status;
        this.data = data;
    }

    private SverResponse(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    private SverResponse(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public SverResponse(Throwable e) {
        this.status = ResponseCode.ERROR.getCode();
        this.msg = e.getMessage();
    }

    public static <T> SverResponse<T> createRespBySuccess() {
        return new SverResponse<>(ResponseCode.SUCCESS.getCode());
    }

    public static <T> SverResponse<T> createRespBySuccess(T data) {
        return new SverResponse<>(ResponseCode.SUCCESS.getCode(), data);
    }

    public static <T> SverResponse<T> createRespBySuccess(String msg, T data) {
        return new SverResponse<>(ResponseCode.SUCCESS.getCode(), msg, data);
    }

    public static <T> SverResponse<T> createRespBySuccessMessage(String msg) {
        return new SverResponse<>(ResponseCode.SUCCESS.getCode(), msg);
    }

    public static <T> SverResponse<T> createRespByError() {
        return new SverResponse<>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getDesc());
    }

    public static <T> SverResponse<T> createByErrorMessage(String errorMessage) {
        return new SverResponse<T>(ResponseCode.ERROR.getCode(), errorMessage);
    }

    public static <T> SverResponse<T> createByErrorCodeMessage(int errorCode, String errorMessage) {
        return new SverResponse<T>(errorCode, errorMessage);
    }
}