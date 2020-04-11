/**
 * 
 */
package com.niranzan.music.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.niranzan.music.model.Rating;

/**
 * @author Niranjan
 *
 */
public interface RatingRepository extends JpaRepository<Rating, Long>{
	Optional<Rating> findByRatingType(String ratingType);
	Optional<Rating> findByParentId(long parentId);
}