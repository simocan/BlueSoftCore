package com.bluesoft.barkod.service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluesoft.barkod.entity.UserEntity;
import com.bluesoft.barkod.repository.UserRepository;
import com.bluesoft.barkod.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public Optional<UserEntity> findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public Boolean existsByUsername(String username) {
		return userRepository.existsByUsername(username);
	}

	@Override
	public Optional<UserEntity> findById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public Optional<UserEntity> findByNameAndPassword(String username, String password) {
		return userRepository.findByNameAndPassword(username, password);
	}

}
