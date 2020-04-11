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
@Table(name = "RATING")
public class Rating extends BaseEntity {
	@Column(name = "RATING")
	private int rating;

	@Column(name = "COMMENT")
	private String comment;

	@Column(name = "RATING_TYPE")
	private String ratingType;

	@Column(name = "PARENT_ID")
	private long parentId;

	public Rating() {
		super();
	}

	/**
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * @param rating
	 *            the rating to set
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment
	 *            the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return the parentId
	 */
	public long getParentId() {
		return parentId;
	}

	/**
	 * @param parentId
	 *            the parentId to set
	 */
	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	/**
	 * @return the ratingType
	 */
	public String getRatingType() {
		return ratingType;
	}

	/**
	 * @param ratingType
	 *            the ratingType to set
	 */
	public void setRatingType(String ratingType) {
		this.ratingType = ratingType;
	}
}