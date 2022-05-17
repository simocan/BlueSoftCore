package com.bluesoft.barkod.service;

import java.util.Optional;

import com.bluesoft.barkod.entity.UserEntity;

public interface UserService {

    Optional<UserEntity> findByUsername(String username);

    Boolean existsByUsername(String username);

	Optional<UserEntity> findById(Long id);
	
	Optional<UserEntity> findByNameAndPassword(String username,String password);

}