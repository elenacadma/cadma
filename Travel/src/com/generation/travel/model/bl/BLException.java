package com.generation.travel.model.bl;

/**
 * una eccezione generica di Business Logic
 * @author Ferdinando
 *
 */
public class BLException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errCode;
	
	
	public String getErrCode() 
	{
		return errCode;
	}

	public void setErrCode(String errCode) 
	{
		this.errCode = errCode;
	}




	public BLException(String msg, String errCode)
	{
		super(msg);
		this.errCode = errCode;
	}
	
}
