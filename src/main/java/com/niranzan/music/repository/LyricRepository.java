/**
 * 
 */
package com.niranzan.music.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.niranzan.music.model.Lyric;

/**
 * @author Niranjan
 *
 */
public interface LyricRepository extends JpaRepository<Lyric, Long> {
    Optional<Lyric> findByLyricNm(String lyricNm);
}