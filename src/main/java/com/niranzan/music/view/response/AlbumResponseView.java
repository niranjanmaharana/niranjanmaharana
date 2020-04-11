/**
 * 
 */
package com.niranzan.music.view.response;

import java.util.Date;
import java.util.List;

/**
 * @author Niranjan
 *
 */

public class AlbumResponseView extends BaseResponseView {
	private String albumNm;
	private Date releasedDtm;
	private List<LyricResponseView> lyrics;

	public AlbumResponseView() {
		super();
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

	/**
	 * @return the lyrics
	 */
	public List<LyricResponseView> getLyrics() {
		return lyrics;
	}

	/**
	 * @param lyrics
	 *            the lyrics to set
	 */
	public void setLyrics(List<LyricResponseView> lyrics) {
		this.lyrics = lyrics;
	}
}