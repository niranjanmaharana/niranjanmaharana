/**
 * 
 */
package com.niranzan.music.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niranzan.music.constant.AppConstants;
import com.niranzan.music.exceptions.DuplicateFieldException;
import com.niranzan.music.exceptions.InvalidFormatException;
import com.niranzan.music.model.Feedback;
import com.niranzan.music.service.FeedbackService;
import com.niranzan.music.view.request.FeedbackRequestView;
import com.niranzan.music.view.response.FeedbackResponseView;
import com.niranzan.music.view.response.SimpleResponseEntity;

import io.swagger.annotations.ApiOperation;

/**
 * @author Niranjan
 *
 */

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
	@Autowired
	private FeedbackService feedbackService;
	private static final Logger LOGGER = LoggerFactory.getLogger(FeedbackController.class);

	@ApiOperation(value = "Get all feedbacks in this application")
	@GetMapping
	public ResponseEntity<SimpleResponseEntity> findAll() {
		List<FeedbackResponseView> views = feedbackService.findAll();
		return new ResponseEntity<SimpleResponseEntity>(
				new SimpleResponseEntity(AppConstants.SUCCESS_RSPNS_STTS.value(), AppConstants.SUCCESS_RESPONSE_MSG,
						views),
				AppConstants.SUCCESS_RSPNS_STTS);
	}

	@ApiOperation(value = "Add a new feedback")
	@PostMapping
	public ResponseEntity<SimpleResponseEntity> registerUser(@Valid @RequestBody FeedbackRequestView request) {
		try {
			Feedback feedback = feedbackService.save(request);
			request.setId(feedback.getId());
			return ResponseEntity.ok().body(new SimpleResponseEntity(AppConstants.SUCCESS_RSPNS_STTS.value(),
					AppConstants.SUCCESS_RESPONSE_MSG, request));
		} catch (DuplicateFieldException exception) {
			LOGGER.info("Exception occurred while saving feedback: {}", exception.getMessage());
			return ResponseEntity.ok().body(new SimpleResponseEntity(HttpStatus.CONFLICT.value(),
					HttpStatus.CONFLICT.getReasonPhrase(), exception.getMessage()));
		} catch (InvalidFormatException exception) {
			LOGGER.info("Exception occurred while saving feedback: {}", exception.getMessage());
			return ResponseEntity.ok().body(new SimpleResponseEntity(HttpStatus.BAD_REQUEST.value(),
					HttpStatus.BAD_REQUEST.getReasonPhrase(), exception.getMessage()));
		} catch (Exception exception) {
			LOGGER.info("Exception occurred while saving feedback: {}", exception.getMessage());
			return ResponseEntity.ok().body(new SimpleResponseEntity(AppConstants.FAILURE_RSPNS_STTS.value(),
					AppConstants.FAILURE_RESPONSE_MSG, exception.getMessage()));
		}
	}
}