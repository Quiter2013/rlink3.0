package com.robustel.common.web.exception.auth;

import com.robustel.common.web.constant.CommonConstants;
import com.robustel.common.web.exception.BaseException;

/**
 *
 */
public class ClientForbiddenException extends BaseException {
    public ClientForbiddenException(String message) {
        super(message, CommonConstants.EX_CLIENT_FORBIDDEN_CODE);
    }

}