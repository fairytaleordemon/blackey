package com.blackey.bys.common;

import java.io.Serializable;

/**
 * 统一返回值格式.
 *
 * @author SUYUANBO268.
 * @author CUIAIWEN118.
 * @param <T>
 */
public class Result<T> implements Serializable{
	
	private static final long serialVersionUID = 617719137957422232L;
	private int code;
	private String message;
	private T data;

	public Result(int code) {
		this.code = code;
	}

	public Result(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public Result(int code, T data) {
		this.code = code;
		this.data = data;
	}

	public Result(int code, String message, T data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}
	
	public Result(ResultCode resultCode) {
		this(resultCode, null);
	}
	
	public Result(ResultCode resultCode, T data){
		this.code = resultCode.getCode();
		this.message = resultCode.getMsg();
		this.data = data;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public T getData() {
		return this.data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
