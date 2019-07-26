package com.example.shiro.bean;

public class BaseResponse<T> {
    /**
     * 错误信息
     */
    private String resultMsg;
    /**
     * 结果代码
     */
    private int resultCode = 200;
    /**
     * 响应数据
     */
    private T resultContent;

    public String getResultMsg() {
        return resultMsg;
    }

    public BaseResponse setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
        return this;
    }

    public int getResultCode() {
        return resultCode;
    }

    public BaseResponse setResultCode(int resultCode) {
        this.resultCode = resultCode;
        return this;
    }

    public T getResultContent() {
        return resultContent;
    }

    public BaseResponse setResultContent(T resultContent) {
        this.resultContent = resultContent;
        return this;
    }
}
