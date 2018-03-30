package com.robustel.common.utils.exception;

/**
 * @Author: gaolinlou
 * Description:
 * Date: Created in 17:40 2018/3/28
 * Modified By:
 */
public class JsonConvertException extends RuntimeException {

    public JsonConvertException() {
    }

    public JsonConvertException(String message) {
        super(message);
    }

    public JsonConvertException(Throwable cause) {
        super(cause);
    }

    public JsonConvertException(String message, Throwable cause) {
        super(message, cause);
    }
}
