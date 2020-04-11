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
@Table(name = "AUTHOR")
public class Author extends BaseEntity {
	@Column(name = "AUTHOR_NM")
	private String authorNm;
	@Column(name = "EMAIL_ID")
	private String emailId;
	@Column(name = "MOBILE")
	private String mobile;
	
	public Author() {
		super();
	}

	/**
	 * @return the authorNm
	 */
	public String getAuthorNm() {
		return authorNm;
	}

	/**
	 * @param authorNm
	 *            the authorNm to set
	 */
	public void setAuthorNm(String authorNm) {
		this.authorNm = authorNm;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId
	 *            the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile
	 *            the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}