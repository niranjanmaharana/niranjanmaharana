package com.niranzan.music.view.response;

import java.util.Date;

public class SimpleResponseEntity {
	private Date date;
	private int statusCode;
	private String statusMessage;
	private Object data;

	public SimpleResponseEntity() {
		this.date = new Date();
		this.statusCode = 200;
		this.statusMessage = "Success";
	}

	public SimpleResponseEntity(int statusCode, String statusMessage, Object data) {
		this();
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
		this.data = data;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the statusCode
	 */
	public int getStatusCode() {
		return statusCode;
	}

	/**
	 * @param statusCode
	 *            the statusCode to set
	 */
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * @return the statusMessage
	 */
	public String getStatusMessage() {
		return statusMessage;
	}

	/**
	 * @param statusMessage
	 *            the statusMessage to set
	 */
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}
}