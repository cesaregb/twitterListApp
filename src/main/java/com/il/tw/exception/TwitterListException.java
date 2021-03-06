package com.il.tw.exception;

import org.apache.commons.lang3.StringUtils;

public class TwitterListException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private static final String DEFAULT_EXCEPTION_CODE = "99";
	
	private String exceptionCode;
	private String exceptionMessage;
	
	public TwitterListException(String aExceptionCode, Throwable cause){
		super(cause);
		exceptionCode = StringUtils.isNotBlank(aExceptionCode) ? aExceptionCode : DEFAULT_EXCEPTION_CODE;
		exceptionMessage = StringUtils.isNotBlank(aExceptionCode) ? aExceptionCode : DEFAULT_EXCEPTION_CODE;
	}
	
	public TwitterListException(Throwable throwable) {
		super(throwable);
		exceptionCode = DEFAULT_EXCEPTION_CODE;
		exceptionMessage = DEFAULT_EXCEPTION_CODE;
	}

	public String getExceptionCode() {
		return exceptionCode;
	}
	public void setExceptionCode(String aExceptionCode) {
		exceptionCode = aExceptionCode;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

}
