package com.auth.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.auth.entity.Users;
import com.auth.repo.UsersRepository;

public class CustomUserDetailService implements UserDetailsService {

	
	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Users> user=usersRepository.findByEmail(username);
		return user.map(CustomUserDetail::new).orElseThrow(()->new UsernameNotFoundException("User Does Not Exist"));
	}

}
