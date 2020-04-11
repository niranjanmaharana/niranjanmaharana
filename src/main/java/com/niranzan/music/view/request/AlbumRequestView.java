/**
 * 
 */
package com.niranzan.music.view.request;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author Niranjan
 *
 */
public class AlbumRequestView {
	private Long id;
	@NotBlank
	@Size(min = 3, max = 255)
	private String albumNm;

	@NotBlank
	private Date releasedDtm;

	public AlbumRequestView() {
		super();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the albumNm
	 */
	public String getAlbumNm() {
		return albumNm;
	}

	/**
	 * @param albumNm
	 *            the albumNm to set
	 */
	public void setAlbumNm(String albumNm) {
		this.albumNm = albumNm;
	}

	/**
	 * @return the releasedDtm
	 */
	public Date getReleasedDtm() {
		return releasedDtm;
	}

	/**
	 * @param releasedDtm
	 *            the releasedDtm to set
	 */
	public void setReleasedDtm(Date releasedDtm) {
		this.releasedDtm = releasedDtm;
	}
}