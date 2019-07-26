package com.example.shiro.bean;

public class ResultCode {
    private ResultCode() {
    }

    public static final int UNBIND_EXCEPTION = 10011;
    /**
     * 2开头表示处理成功
     */
    public static final int SUCCESS = 200;
    public static final String SUCCESS_STR = "操作成功";
    /**
     * 3开头表示参数错误
     */
    //参数错误
    public static final int PARAMETER_ERROR = 300;
    public static final String PARAMETER_ERROR_STR = "参数错误";
    /**
     * 4开头表示服务端处理错误
     */
    //业务异常
    public static final int BIZ_ERROR = 400;
    /**
     * token失效
     */
    public static final int TOKEN_INVALID = 10010;
    //没有捕获的异常，如空指针异常等
    public static final int UNCHECK_EXCEPTION = 401;

    /**
     * 5开头表示会话异常
     */
    //用户未登录
    public static final int NO_SESSION = 500;
    //用户会话过期
    public static final int SESSION_TIMEOUT = 501;

    /**
     * 6开头表示权限异常
     */
    //权限不足
    public static final int NO_PERMISSION = 600;
}
