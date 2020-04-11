/**
 * 
 */
package com.niranzan.music.view.request;

/**
 * @author Niranjan
 *
 */
public class LyricRequestView {
	private long id;
	private String lyricNm;
	private String authorNm;
	private String lyricTxt;
	private AlbumRequestView album;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
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
	public AlbumRequestView getAlbum() {
		return album;
	}

	/**
	 * @param album
	 *            the album to set
	 */
	public void setAlbum(AlbumRequestView album) {
		this.album = album;
	}

	public LyricRequestView() {
		super();
	}
}