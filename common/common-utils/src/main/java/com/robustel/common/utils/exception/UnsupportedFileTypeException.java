package com.robustel.common.utils.exception;

/**
 * @Author: gaolinlou
 * Description:
 * Date: Created in 17:40 2018/3/28
 * Modified By:
 */
public class UnsupportedFileTypeException extends RuntimeException {

    public UnsupportedFileTypeException() {
    }

    public UnsupportedFileTypeException(String message) {
        super(message);
    }

    public UnsupportedFileTypeException(Throwable cause) {
        super(cause);
    }

    public UnsupportedFileTypeException(String message, Throwable cause) {
        super(message, cause);
    }
}
