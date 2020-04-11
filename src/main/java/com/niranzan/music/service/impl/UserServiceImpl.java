/**
 * 
 */
package com.niranzan.music.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niranzan.music.enums.UserRoleEnum;
import com.niranzan.music.exceptions.DuplicateFieldException;
import com.niranzan.music.exceptions.InvalidFormatException;
import com.niranzan.music.exceptions.ResourceNotFoundException;
import com.niranzan.music.model.Authority;
import com.niranzan.music.model.UserProfile;
import com.niranzan.music.repository.RoleRepository;
import com.niranzan.music.repository.UserRepository;
import com.niranzan.music.service.PasswordValidator;
import com.niranzan.music.service.UserService;
import com.niranzan.music.view.request.UserRequestView;
import com.niranzan.music.view.response.UserResponseView;

/**
 * @author Niranjan
 *
 */

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordValidator passwordValidator;
	
	@Value("${password.invalid.message}")
	private String invalidPasswordMessage;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	@Transactional
	public List<UserResponseView> findAll(){
		List<UserProfile> users = userRepository.findAll();
		List<UserResponseView> userViews = new ArrayList<>();
		users.forEach(user -> userViews.add(getResponseView(user)));
		return userViews;
	}
	
	@Override
	@Transactional
	public UserProfile save(UserRequestView request) {
		if (userRepository.existsByUsername(request.getUsername())) {
			LOGGER.error("Duplicate username found !");
			throw new DuplicateFieldException("Username already exists !");
		}
		if (userRepository.existsByEmail(request.getEmail())) {
			LOGGER.error("Duplicate email found !");
			throw new DuplicateFieldException("Email already exists !");
		}
		
		if (userRepository.existsByMobile(request.getMobile())) {
			LOGGER.error("Duplicate mobile number found !");
			throw new DuplicateFieldException("Mobile number already registered !");
		}
		
		if (!passwordValidator.isValid(request.getPassword())) {
			LOGGER.error("Invalid password format !");
			throw new InvalidFormatException(invalidPasswordMessage);
		}

		UserProfile user = new UserProfile(request.getFirstNm(), request.getLastNm(), request.getUsername(),
				request.getEmail(), request.getMobile(), request.getPassword(), request.getProfilePic());

		Set<String> strRoles = new HashSet<>();
		if(request.getRole() == null) strRoles.add(UserRoleEnum.ROLE_USER.getName());
		else strRoles = request.getRole();
		List<Authority> roles = new ArrayList<>();

		strRoles.forEach(role -> {
			Authority adminRole = roleRepository.findByName(UserRoleEnum.getById(Integer.parseInt(role) - 1))
					.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
			roles.add(adminRole);
		});

		user.setAuthorities(roles);
		return userRepository.save(user);
	}
	
	@Override
	@Transactional
	public UserProfile update(UserRequestView request) {
		UserProfile user = userRepository.findById(request.getId()).orElse(null);
		
		if (user == null) throw new ResourceNotFoundException("User not found with id : " + request.getId());
		
		if (userRepository.existsByEmailExceptUser(request.getId(), request.getEmail())) {
			LOGGER.error("Duplicate email found !");
			throw new DuplicateFieldException("Email already registered !");
		}
		
		if (userRepository.existsByMobileExceptUser(request.getId(), request.getMobile())) {
			LOGGER.error("Duplicate mobile number found !");
			throw new DuplicateFieldException("Mobile number already registered !");
		}
		user.setFirstNm(request.getFirstNm());
		user.setLastNm(request.getLastNm());
		user.setEmail(request.getEmail());
		user.setMobile(request.getMobile());
		Set<String> strRoles = request.getRole();
		List<Authority> roles = new ArrayList<>();
		
		strRoles.forEach(role -> {
			Authority adminRole = roleRepository.findByName(UserRoleEnum.getById(Integer.parseInt(role) - 1))
					.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
			roles.add(adminRole);
		});
		user.setAuthorities(roles);
		return userRepository.save(user);
	}
	
	@Override
	public UserResponseView getResponseView(UserProfile user) {
		UserResponseView userResponse = new UserResponseView();
		userResponse.setId(user.getId());
		userResponse.setCreatedDate(user.getCreatedDtm());
		userResponse.setCreatedBy(user.getCreatedBy());
		userResponse.setLastModifiedDate(user.getUpdatedDtm());
		userResponse.setLastModifiedBy(user.getUpdatedBy());
		userResponse.setEmail(user.getEmail());
		userResponse.setMobile(user.getMobile());
		userResponse.setRoles(user.getAuthorities());
		userResponse.setUsername(user.getUsername());
		userResponse.setActive(user.isActive());
		userResponse.setProfilePic(user.getPrflPic());
		return userResponse;
	}
}