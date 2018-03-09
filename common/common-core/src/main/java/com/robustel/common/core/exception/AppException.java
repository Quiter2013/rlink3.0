package com.robustel.common.core.exception;

import java.io.InputStreamReader;
import java.util.Properties;

public class AppException extends RuntimeException
{
  private static final long serialVersionUID = 1L;
  private static Properties config = new Properties();
  private String code;

  public AppException()
  {
  }

  public AppException(String code)
  {
    this.code = code;
  }

  public AppException(String code, String message) {
    super(message);
    this.code = code;
  }

  public AppException(Throwable cause) {
    super(cause);
  }

  public AppException(String message, Throwable cause) {
    super(message, cause);
  }

  public AppException(String code, String message, Throwable cause) {
    super(message, cause);
    this.code = code;
  }

  public String getCode() {
    return this.code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public static String getExceptMsg(String msgCode) {
    return config.getProperty(msgCode);
  }

  static
  {
    try
    {
      config.load(new InputStreamReader(AppException.class.getClassLoader().getResourceAsStream("errorCode.properties"), "UTF-8"));
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
}