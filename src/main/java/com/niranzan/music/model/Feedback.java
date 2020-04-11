/**
 * 
 */
package com.niranzan.music.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Niranjan
 *
 */

@Entity
@Table(name = "FEEDBACK")
public class Feedback extends BaseEntity {
	@Column(name = "USERNAME", length = 100)
	private String username;
	@Column(name = "EMAIL", length = 100)
	private String email;
	@Column(name = "MOBILE", length = 10)
	private String mobile;
	@Column(name = "MESSAGE", length = 200)
	private String message;
	
	public Feedback() {
		super();
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}