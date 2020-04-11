/**
 * 
 */
package com.niranzan.music.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.niranzan.music.model.Album;
import com.niranzan.music.repository.AlbumRepository;
import com.niranzan.music.service.AlbumService;
import com.niranzan.music.view.response.AlbumResponseView;
import com.niranzan.music.view.response.LyricResponseView;

/**
 * @author Niranjan
 *
 */

@Service
public class AlbumServiceImpl implements AlbumService {
	private AlbumRepository albumRepository;

	@Override
	public List<Album> getAll() {
		return this.albumRepository.findAll();
	}

	@Override
	public List<AlbumResponseView> findAll() {
		List<AlbumResponseView> views = new ArrayList<>();
		this.getAll().forEach(album -> views.add(convertEntityToResponse(album)));
		return views;
	}

	private AlbumResponseView convertEntityToResponse(Album album) {
		AlbumResponseView view = new AlbumResponseView();
		view.setId(album.getId());
		view.setActive(album.isActive());
		view.setAlbumNm (album.getAlbumNm());
		view.setReleasedDtm(album.getReleasedDtm());
		if (album.getLyrics() != null && !album.getLyrics().isEmpty()) {
			List<LyricResponseView> lyrics = new ArrayList<>();
			album.getLyrics().forEach(lyric -> {
				LyricResponseView lyricResponse = new LyricResponseView();
				lyricResponse.setId(lyric.getId());
				lyricResponse.setActive(lyric.isActive());
				lyricResponse.setAlbum(null);
				lyricResponse.setAuthorNm(lyric.getAuthorNm());
				lyricResponse.setLyricNm(lyric.getLyricNm());
				lyricResponse.setLyricTxt(lyric.getLyricTxt());
				lyrics.add(lyricResponse);
			});
			view.setLyrics(lyrics);
		}
		return view;
	}
}