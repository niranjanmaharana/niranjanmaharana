package com.niranzan.music.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.niranzan.music.enums.UserRoleEnum;
import com.niranzan.music.model.Authority;


@Repository
public interface RoleRepository extends JpaRepository<Authority, Long> {
    Optional<Authority> findByName(UserRoleEnum roleNm);
}