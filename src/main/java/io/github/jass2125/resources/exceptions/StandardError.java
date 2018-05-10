package io.github.jass2125.resources.exceptions;

import java.io.Serializable;

public class StandardError implements Serializable{

	private static final long serialVersionUID = 1L;
	private int status;
	private String message;
	private long timeStamp;

	public StandardError() {
	}

	public StandardError(int value, String message, long currentTimeMillis) {
		this.status = value;
		this.message = message;
		this.timeStamp = currentTimeMillis;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

}
