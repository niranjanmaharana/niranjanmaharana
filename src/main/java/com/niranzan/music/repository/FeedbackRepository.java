/**
 * 
 */
package com.niranzan.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.niranzan.music.model.Feedback;

/**
 * @author Niranjan
 *
 */
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}