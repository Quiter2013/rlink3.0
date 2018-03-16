package com.robustel.common.web.exception.auth;

import com.robustel.common.web.constant.CommonConstants;
import com.robustel.common.web.exception.BaseException;

/**
 * Created by ace on 2017/9/10.
 */
public class ClientInvalidException extends BaseException {
    public ClientInvalidException(String message) {
        super(message, CommonConstants.EX_CLIENT_INVALID_CODE);
    }
}