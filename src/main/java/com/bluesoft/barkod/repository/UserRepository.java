package com.bluesoft.barkod.repository;

import java.util.Optional;

import com.bluesoft.barkod.entity.UserEntity;


public interface UserRepository {

    Optional<UserEntity> findByUsername(String username);

    Boolean existsByUsername(String username);

	Optional<UserEntity> findById(Long id);
	
	Optional<UserEntity> findByNameAndPassword(String username,String password);

}
