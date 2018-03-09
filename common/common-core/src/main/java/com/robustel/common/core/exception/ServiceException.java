package com.robustel.common.core.exception;

public class ServiceException extends AppException
{
  private static final long serialVersionUID = 1L;
  private String code;

  public ServiceException()
  {
  }

  public ServiceException(String code)
  {
    this.code = code;
  }

  public ServiceException(String code, String message) {
    super(message);
    this.code = code;
  }

  public ServiceException(Throwable cause) {
    super(cause);
  }

  public ServiceException(String message, Throwable cause) {
    super(message, cause);
  }

  public ServiceException(String code, String message, Throwable cause) {
    super(message, cause);
    this.code = code;
  }

  public String getCode() {
    return this.code;
  }

  public void setCode(String code) {
    this.code = code;
  }
}