/**
 * 
 */
package com.niranzan.music.service;

import java.util.List;

import com.niranzan.music.model.UserSession;
import com.niranzan.music.view.response.UserSessionResponseView;

/**
 * @author Niranjan
 *
 */
public interface UserSessionService {
	public UserSession saveSession(UserSession session);
	public List<UserSession> findAllSession();
	public List<UserSessionResponseView> getSessionByUsername(String username);
	public UserSession findLastSessionByUsername(String username);
	public void saveSessionAsync(String values);
	public UserSessionResponseView getResponseView(UserSession session);
}