/**
 * 
 */
package com.niranzan.music.service;

import java.util.List;

import com.niranzan.music.model.Lyric;
import com.niranzan.music.view.response.LyricResponseView;

/**
 * @author Niranjan
 *
 */
public interface LyricService {
	public List<LyricResponseView> findAll();
	public List<Lyric> getAll();
}