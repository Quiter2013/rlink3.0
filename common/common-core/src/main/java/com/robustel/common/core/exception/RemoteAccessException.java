package com.robustel.common.core.exception;

public class RemoteAccessException extends RuntimeException
{
  private static final long serialVersionUID = 1L;
  private String code;

  public RemoteAccessException()
  {
  }

  public RemoteAccessException(String code)
  {
    this.code = code;
  }

  public RemoteAccessException(String code, String message) {
    super(message);
    this.code = code;
  }

  public RemoteAccessException(Throwable cause) {
    super(cause);
  }

  public RemoteAccessException(String message, Throwable cause) {
    super(message, cause);
  }

  public RemoteAccessException(String code, String message, Throwable cause) {
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