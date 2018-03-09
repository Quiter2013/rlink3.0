package com.robustel.common.core.exception;


public class BizException extends AppException
{
  private static final long serialVersionUID = 1L;
  private String code;
  private Object object;

  public BizException()
  {
  }

  public BizException(String code)
  {
    this.code = code;

  }

  public BizException(String code, String message) {
    super(code, message);
    this.code = code;
  }

  @Deprecated
  public BizException(Throwable cause) {
    super(cause);
  }

  @Deprecated
  public BizException(String message, Throwable cause) {
    super(message, cause);
  }

  public BizException(String code, String message, Throwable cause) {
    super(message, cause);
    this.code = code;
  }

  public String getCode() {
    return this.code;
  }

  public void setCode(String code) {
    this.code = code;
  }


	@Override
	public String getMessage() {
      return super.getMessage();
    }

	/**
	 * object
	 *
	 * @return  the object
	 * @since   1.0.0
	*/
	
	public Object getObject() {
		return object;
	}

	/**
	 * @param object the object to set
	 */
	public void setObject(Object object) {
		this.object = object;
	}
	
	
}