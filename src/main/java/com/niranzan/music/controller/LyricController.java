/**
 * 
 */
package com.niranzan.music.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niranzan.music.constant.AppConstants;
import com.niranzan.music.service.LyricService;
import com.niranzan.music.view.response.LyricResponseView;
import com.niranzan.music.view.response.SimpleResponseEntity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Niranjan
 *
 */

@RestController
@RequestMapping("/lyric")
@Api(value = "User", description = "Operations pertaining to user in CMS application", consumes = "application/json", produces = "application/json")
public class LyricController {
	private LyricService lyricService;
	private static final Logger LOGGER = LoggerFactory.getLogger(LyricController.class);

	@ApiOperation(value = "Get all lyrics in this application")
	@GetMapping
	public ResponseEntity<SimpleResponseEntity> findAll() {
		List<LyricResponseView> lyrics = null;
		try {
			lyrics = this.lyricService.findAll();
			return new ResponseEntity<SimpleResponseEntity>(
					new SimpleResponseEntity(HttpStatus.OK.value(), AppConstants.SUCCESS_RESPONSE_MSG, lyrics),
					HttpStatus.OK);
		} catch (Exception exception) {
			LOGGER.error("Exception occured during fetching the list of lyrics, {}", exception.getMessage());
			return new ResponseEntity<SimpleResponseEntity>(
					new SimpleResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR.value(), AppConstants.FAILURE_RESPONSE_MSG, AppConstants.FAILURE_RESPONSE_DATA),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}