/**
 * 
 */
package com.niranzan.music.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.niranzan.music.model.Album;

/**
 * @author Niranjan
 *
 */
public interface AlbumRepository extends JpaRepository<Album, Long> {
    Optional<Album> findByAlbumNm(String albumNm);
}