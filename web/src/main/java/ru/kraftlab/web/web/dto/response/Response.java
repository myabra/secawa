package ru.kraftlab.web.web.dto.response;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * Created by Мария on 28.06.2017.
 */
public class Response {
    @JsonView
    private RESULT result = RESULT.OK;

    @JsonView
    private String errMsg;

    public RESULT getResult() {
        return result;
    }

    public void setResult(RESULT result) {
        this.result = result;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public enum RESULT {
        OK,
        ERROR;
    }
}
