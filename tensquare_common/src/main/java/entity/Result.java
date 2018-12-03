package entity;

/**
 * Created by jzy on 2018/12/3.
 */
public class Result {
    private boolean flag;
    private Integer code;
    private String msg;
    private Object data;


    public Result() {
    }

    public Result(boolean flag, Integer code, String msg) {
        this.flag = flag;
        this.code = code;
        this.msg = msg;
    }

    public Result(boolean flag, Object data, String msg, Integer code) {
        this.flag = flag;
        this.data = data;
        this.msg = msg;
        this.code = code;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
