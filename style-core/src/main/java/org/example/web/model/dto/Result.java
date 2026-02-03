package org.example.web.model.dto;

import lombok.Data;
import pascal.taie.analysis.pta.core.heap.Obj;

@Data
public class Result {
    private boolean success;
    private String code;
    private String msg;
    private Object data;

    public Result(boolean success, ResultCode code, String msg, Object data) {
        this.success = success;
        this.code = code.name();
        this.msg = msg;
        this.data = data;
    }

    public static Result ok(Object data) {
        return new Result(true, ResultCode.SUCCESS, "Operation successful", data);
    }

    public static Result fail(ResultCode code, String msg) {
        return new Result(false, code, msg, null);
    }
}
