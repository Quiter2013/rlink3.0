package com.robustel.common.core.exception;

public class DataAccessException extends AppException
{
  private static final long serialVersionUID = 1L;
  private String code;

  public DataAccessException()
  {
  }

  public DataAccessException(String code)
  {
    this.code = code;
  }

  public DataAccessException(String code, String message) {
    super(message);
    this.code = code;
  }

  public DataAccessException(Throwable cause) {
    super(cause);
  }

  public DataAccessException(String message, Throwable cause) {
    super(message, cause);
  }

  public DataAccessException(String code, String message, Throwable cause) {
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