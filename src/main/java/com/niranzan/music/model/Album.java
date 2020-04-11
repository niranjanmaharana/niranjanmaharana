/**
 * 
 */
package com.niranzan.music.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Niranjan
 *
 */

@Entity
@Table(name = "ALBUM")
public class Album extends BaseEntity {
	@Column(name = "ALBUM_NM")
	private String albumNm;

	@Column(name = "RELEASE_DTM")
	private Date releasedDtm;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "album")
	private List<Lyric> lyrics;

	public Album() {
		super();
	}

	/**
	 * @param albumNm
	 * @param releasedDtm
	 */
	public Album(String albumNm, Date releasedDtm) {
		super();
		this.albumNm = albumNm;
		this.releasedDtm = releasedDtm;
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
	public List<Lyric> getLyrics() {
		return lyrics;
	}

	/**
	 * @param lyrics
	 *            the lyrics to set
	 */
	public void setLyrics(List<Lyric> lyrics) {
		this.lyrics = lyrics;
	}
}