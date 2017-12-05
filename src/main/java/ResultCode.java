
public enum ResultCode {
    /**
     * 成功通用码
     */
    Success(0, "执行成功"),

    /**
     * 失败错误码
     */
    Failure(1, "系统繁忙，请稍后再试"),

    /**
     * 异常错误码
     */
    ExceptionOccured(2, "系统繁忙，请稍后再试"),

    /**
     * 参数不存在错误码
     */
    ParamNonExist(3, "缺少必要的参数"),

    /**
     * 参数不合法错误码，常用于一些业务场景的参数精度、范围、前置条件的校验
     */
    ParamIllegal(4, "参数不正确"),

    /**
     * 参数重复或者数据重复
     */
    ParamDuplicated(5, "重复的参数"),

    /**
     * 必要的数据查询不到，常用于准备某些满足条件的数据却查询不到的场景
     */
    NoResult(6, "查询不到数据"),

    /**
     * 服务不可用
     */
    ServiceUnavailable(7, "服务不可用"),

    /**
     * 业务逻辑不满足的错误码，常用于处理某些业务逻辑，但数据不满足前置条件的场景
     */
    Uneligible(8, "条件不满足"),

    /**
     * 更新失败，用于数据写失败的场景
     */
    UpateFailure(9, "更新失败"),

    /**
     * 重复操作错误码，常用于接口是否被重复调用的场景判断
     */
    InvokeDuplicated(11, "重复的调用"),

    NoUserInfo(12, "用户不存在"),

    UriIllegal(13, "非法请求路径"),

    /**
     * 未授权
     */
    Unauthorized(401, "未授权"),

    /**
     * 用户未登录，常用于接口判断用户需要登录后才能操作的场景判断
     */
    UserNoLogin(403, "未登录"),


    OVERTIMES(999, "次数限制");

    private int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}

