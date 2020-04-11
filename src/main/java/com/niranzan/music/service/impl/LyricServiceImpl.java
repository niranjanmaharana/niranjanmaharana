/**
 * 
 */
package com.niranzan.music.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.niranzan.music.model.Album;
import com.niranzan.music.model.Lyric;
import com.niranzan.music.repository.LyricRepository;
import com.niranzan.music.service.LyricService;
import com.niranzan.music.view.response.AlbumResponseView;
import com.niranzan.music.view.response.LyricResponseView;

/**
 * @author Niranjan
 *
 */

@Service
public class LyricServiceImpl implements LyricService {
	private LyricRepository lyricRepository;

	@Override
	public List<Lyric> getAll() {
		return this.lyricRepository.findAll();
	}

	@Override
	public List<LyricResponseView> findAll() {
		List<LyricResponseView> views = new ArrayList<>();
		this.getAll().forEach(lyric -> views.add(convertEntityToResponse(lyric)));
		return views;
	}

	private LyricResponseView convertEntityToResponse(Lyric lyric) {
		LyricResponseView view = new LyricResponseView();
		view.setActive(lyric.isActive());
		if (lyric.getAlbum() != null) {
			Album album = lyric.getAlbum();
			AlbumResponseView albumResponse = new AlbumResponseView();
			albumResponse.setActive(album.isActive());
			albumResponse.setAlbumNm(album.getAlbumNm());
			albumResponse.setId(album.getId());
			albumResponse.setReleasedDtm(album.getReleasedDtm());
			view.setAlbum(albumResponse);
		}
		view.setAuthorNm(lyric.getAuthorNm());
		view.setLyricNm(lyric.getLyricNm());
		view.setLyricTxt(lyric.getLyricTxt());
		return view;
	}
}