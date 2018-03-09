package com.robustel.common.core.exception;

public class UnCheckedException extends RuntimeException
{
  private static final long serialVersionUID = 1L;
  private String code;

  public UnCheckedException()
  {
  }

  public UnCheckedException(String code)
  {
    this.code = code;
  }

  public UnCheckedException(String code, String message) {
    super(message);
    this.code = code;
  }

  public UnCheckedException(Throwable cause) {
    super(cause);
  }

  public UnCheckedException(String message, Throwable cause) {
    super(message, cause);
  }

  public UnCheckedException(String code, String message, Throwable cause) {
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