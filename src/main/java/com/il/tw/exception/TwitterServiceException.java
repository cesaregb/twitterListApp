package com.il.tw.exception;

public class TwitterServiceException extends TwitterListException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public static final String CAUSE_ONE = "01";
	public static final String CAUSE_TOWE = "02";
	
	public TwitterServiceException(String exceptionCode, Throwable cause){
		super(exceptionCode, cause);
	}
}
