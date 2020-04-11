/**
 * 
 */
package com.niranzan.music.service;

import java.util.List;

import com.niranzan.music.model.Feedback;
import com.niranzan.music.view.request.FeedbackRequestView;
import com.niranzan.music.view.response.FeedbackResponseView;

/**
 * @author Niranjan
 *
 */
public interface FeedbackService {
	public List<FeedbackResponseView> findAll();
	public List<Feedback> getAll();
	public Feedback save(FeedbackRequestView request);
	public Feedback update(FeedbackRequestView request);
}