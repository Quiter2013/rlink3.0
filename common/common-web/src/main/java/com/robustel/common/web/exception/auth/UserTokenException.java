package com.robustel.common.web.exception.auth;

import com.robustel.common.web.constant.CommonConstants;
import com.robustel.common.web.exception.BaseException;

public class UserTokenException extends BaseException {
    public UserTokenException(String message) {
        super(message, CommonConstants.EX_USER_INVALID_CODE);
    }
}