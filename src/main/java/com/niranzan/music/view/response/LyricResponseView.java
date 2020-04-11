/**
 * 
 */
package com.niranzan.music.view.response;

/**
 * @author Niranjan
 *
 */
public class LyricResponseView extends BaseResponseView {
	private String lyricNm;
	private String authorNm;
	private String lyricTxt;
	private AlbumResponseView album;

	public LyricResponseView() {
		super();
	}

	/**
	 * @return the lyricNm
	 */
	public String getLyricNm() {
		return lyricNm;
	}

	/**
	 * @param lyricNm
	 *            the lyricNm to set
	 */
	public void setLyricNm(String lyricNm) {
		this.lyricNm = lyricNm;
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
	 * @return the lyricTxt
	 */
	public String getLyricTxt() {
		return lyricTxt;
	}

	/**
	 * @param lyricTxt
	 *            the lyricTxt to set
	 */
	public void setLyricTxt(String lyricTxt) {
		this.lyricTxt = lyricTxt;
	}

	/**
	 * @return the album
	 */
	public AlbumResponseView getAlbum() {
		return album;
	}

	/**
	 * @param album
	 *            the album to set
	 */
	public void setAlbum(AlbumResponseView album) {
		this.album = album;
	}
}