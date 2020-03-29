/**
 * 
 */
package com.niranzan.music.service;

import java.util.List;

import com.niranzan.music.model.UserProfile;
import com.niranzan.music.view.request.UserRequestView;
import com.niranzan.music.view.response.UserResponseView;

/**
 * @author Niranjan
 *
 */
public interface UserService {
	/**
	 * @param user
	 * @return
	 */
	public UserResponseView getResponseView(UserProfile user);

	/**
	 * @param request
	 * @return
	 */
	UserProfile save(UserRequestView request);

	/**
	 * @return
	 */
	List<UserResponseView> findAll();

	/**
	 * @param request
	 * @return
	 */
	UserProfile update(UserRequestView request);
}