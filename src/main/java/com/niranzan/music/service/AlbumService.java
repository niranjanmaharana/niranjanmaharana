/**
 * 
 */
package com.niranzan.music.service;

import java.util.List;

import com.niranzan.music.model.Album;
import com.niranzan.music.view.response.AlbumResponseView;

/**
 * @author Niranjan
 *
 */
public interface AlbumService {
	public List<AlbumResponseView> findAll();
	public List<Album> getAll();
}