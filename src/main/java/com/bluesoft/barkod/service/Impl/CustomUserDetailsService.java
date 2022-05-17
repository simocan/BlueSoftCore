package com.bluesoft.barkod.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluesoft.barkod.entity.UserEntity;
import com.bluesoft.barkod.repository.UserRepository;
import com.bluesoft.barkod.security.UserPrincipal;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	
	@Transactional
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        // Let people login with either username or email
		UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> 
                        new UsernameNotFoundException("User not found with username or email : " + username)
        );

		
        return UserPrincipal.create(user);
    }
	
	
	// This method is used by JWTAuthenticationFilter
    @Transactional
    public UserDetails loadUserById(Long id) {
    	UserEntity user = userRepository.findById(id).orElseThrow(
            () -> new UsernameNotFoundException("User not found with id : " + id)
        );

        return UserPrincipal.create(user);
    }


}
