package com.robustel.common.web.handler;

import com.robustel.common.web.constant.CommonConstants;
import com.robustel.common.web.exception.BaseException;
import com.robustel.common.web.exception.auth.ClientTokenException;
import com.robustel.common.web.exception.auth.UserTokenException;
import com.robustel.common.web.vo.RtResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(BaseException.class)
    public RtResponse baseExceptionHandler(HttpServletResponse response, BaseException ex) {
        logger.error(ex.getMessage(),ex);
        response.setStatus(500);
        return new RtResponse(ex.getStatus(),ex.getMessage(),null);
    }

    @ExceptionHandler(Exception.class)
    public RtResponse otherExceptionHandler(HttpServletResponse response, Exception ex) {
        response.setStatus(500);
        logger.error(ex.getMessage(),ex);
        return new RtResponse(CommonConstants.EX_OTHER_CODE, ex.getMessage(),null);
    }

    @ExceptionHandler(ClientTokenException.class)
    public RtResponse clientTokenExceptionHandler(HttpServletResponse response, ClientTokenException ex) {
        response.setStatus(403);
        logger.error(ex.getMessage(),ex);
        return new RtResponse(ex.getStatus(), ex.getMessage(),null);
    }

    @ExceptionHandler(UserTokenException.class)
    public RtResponse userTokenExceptionHandler(HttpServletResponse response, UserTokenException ex) {
        response.setStatus(401);
        logger.error(ex.getMessage(),ex);
        return new RtResponse(ex.getStatus(), ex.getMessage(),null);
    }
}