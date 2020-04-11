/**
 * 
 */
package com.niranzan.music.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Niranjan
 *
 */

@Entity
@Table(name = "LYRIC")
public class Lyric extends BaseEntity {
	@Column(name = "LYRIC_NM")
	private String lyricNm;

	@Column(name = "AUTHOR_NM")
	private String authorNm;

	@Column(name = "LYRIC_TXT")
	private String lyricTxt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ALBUM_ID", nullable = false)
	private Album album;

	public Lyric() {
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
	public Album getAlbum() {
		return album;
	}

	/**
	 * @param album
	 *            the album to set
	 */
	public void setAlbum(Album album) {
		this.album = album;
	}
}