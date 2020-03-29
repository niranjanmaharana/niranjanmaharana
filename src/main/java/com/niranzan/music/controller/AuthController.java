package com.niranzan.music.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niranzan.music.exceptions.DuplicateFieldException;
import com.niranzan.music.exceptions.InvalidFormatException;
import com.niranzan.music.model.UserProfile;
import com.niranzan.music.security.jwt.JwtProvider;
import com.niranzan.music.service.UserService;
import com.niranzan.music.view.request.AuthRequest;
import com.niranzan.music.view.request.UserRequestView;
import com.niranzan.music.view.response.JwtResponse;
import com.niranzan.music.view.response.SimpleResponseEntity;

import io.swagger.annotations.Api;

@Api(value = "Authentication", description = "Operations pertaining to login and logout.")
@RestController
@RequestMapping("/noauth")
public class AuthController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserService userService;
	@Autowired
	private JwtProvider jwtProvider;
	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody AuthRequest loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtProvider.generateJwtToken(authentication);
		logger.info("Token generated : " + jwt);
		return ResponseEntity.ok(new JwtResponse(jwt));
	}
	
	@PostMapping("/signup")
	public ResponseEntity<SimpleResponseEntity> registerUser(@Valid @RequestBody UserRequestView request) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		logger.info(username + " trying to register user.");
		try {
			UserProfile user = userService.save(request);
			request.setId(user.getId());
			logger.info(username + " registered user successfully.");
			return ResponseEntity.ok()
					.body(new SimpleResponseEntity(HttpStatus.OK.value(), "User registered successfully!", request));
		} catch (DuplicateFieldException exception) {
			return ResponseEntity.ok()
					.body(new SimpleResponseEntity(HttpStatus.BAD_REQUEST.value(), exception.getMessage(), ""));
		} catch (InvalidFormatException exception) {
			return ResponseEntity.ok()
					.body(new SimpleResponseEntity(HttpStatus.BAD_REQUEST.value(), exception.getMessage(), ""));
		} catch (Exception exception) {
			return ResponseEntity.ok().body(
					new SimpleResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal server error !", ""));
		}
	}
}