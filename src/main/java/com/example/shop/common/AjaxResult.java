package com.example.shop.common;

import lombok.Data;

import java.util.Map;

@Data
public class AjaxResult {

    /** 狀態碼 */
    public static final String CODE_TAG = "code";
    /** 返回訊息 */
    public static final String MSG_TAG = "msg";
    /** 資料物件 */
    public static final String DATA_TAG = "data";

    /** 成功 */
    public static final int SUCCESS = 200;
    /** 失敗 */
    public static final int ERROR = 500;

    private int code;
    private String msg;
    private Map<String, Object> data; // 錯誤訊息Object data;

    public AjaxResult(int code, String msg,  Map<String, Object> data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static AjaxResult success(String msg,  Map<String, Object> data) {
        return new AjaxResult(SUCCESS, msg, data);
    }

    public static AjaxResult error(String msg,  Map<String, Object> data) {
        return new AjaxResult(ERROR, msg, data);
    }
}
