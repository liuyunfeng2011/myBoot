package com.action.myboot.util;

public class APIException extends Exception{
		/**
	      * 错误编码号
	      */
	     private String errorCode;
		public APIException(String message) {
			super(message);
		}
		public APIException(String message,String errorCode) {
			super(message);
			this.errorCode=errorCode;
		}
		public String getErrorCode() {
			return errorCode;
		}
		public void setErrorCode(String errorCode) {
			this.errorCode = errorCode;
		}
	 
}
