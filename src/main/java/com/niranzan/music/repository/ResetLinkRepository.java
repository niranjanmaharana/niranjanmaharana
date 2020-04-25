/**
 * 
 */
package com.niranzan.music.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.niranzan.music.model.ResetLink;

/**
 * @author Niranjan
 *
 */

@Repository
public interface ResetLinkRepository extends JpaRepository<ResetLink, Long> {
	Optional<ResetLink> findByLink(String link);
	Optional<ResetLink> findByUserId(long userId);
}