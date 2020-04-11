/**
 * 
 */
package com.niranzan.music.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niranzan.music.exceptions.ResourceNotFoundException;
import com.niranzan.music.model.Feedback;
import com.niranzan.music.repository.FeedbackRepository;
import com.niranzan.music.service.FeedbackService;
import com.niranzan.music.view.request.FeedbackRequestView;
import com.niranzan.music.view.response.FeedbackResponseView;

/**
 * @author Niranjan
 *
 */

@Service
public class FeedbackServiceImpl implements FeedbackService {
	@Autowired
	private FeedbackRepository feedbackRepository;

	@Override
	public List<Feedback> getAll() {
		return this.feedbackRepository.findAll();
	}

	@Override
	public List<FeedbackResponseView> findAll() {
		List<FeedbackResponseView> views = new ArrayList<>();
		this.getAll().forEach(feedback -> views.add(convertEntityToResponse(feedback)));
		return views;
	}

	private FeedbackResponseView convertEntityToResponse(Feedback feedback) {
		FeedbackResponseView view = new FeedbackResponseView();
		view.setActive(feedback.isActive());
		view.setEmail(feedback.getEmail());
		view.setId(feedback.getId());
		view.setMessage(feedback.getMessage());
		view.setMobile(feedback.getMobile());
		return view;
	}
	
	@Override
	@Transactional
	public Feedback save(FeedbackRequestView request) {
		Feedback feedback = new Feedback();
		feedback.setUsername(request.getUsername());
		feedback.setEmail(request.getEmail());
		feedback.setMobile(request.getMobile());
		feedback.setMessage(request.getMessage());
		return feedbackRepository.save(feedback);
	}
	
	@Override
	@Transactional
	public Feedback update(FeedbackRequestView request) {
		Feedback feedback = feedbackRepository.findById(request.getId()).orElse(null);
		if (feedback == null) throw new ResourceNotFoundException("Feedback not found with id : " + request.getId());
		
		feedback.setUsername(request.getUsername());
		feedback.setEmail(request.getEmail());
		feedback.setMobile(request.getMobile());
		feedback.setMessage(request.getMessage());
		return feedbackRepository.save(feedback);
	}
}