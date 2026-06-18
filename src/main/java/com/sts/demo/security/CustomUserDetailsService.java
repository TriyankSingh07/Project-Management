package com.sts.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sts.demo.entity.AppUser;
import com.sts.demo.repository.AppUserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private AppUserRepository appUserRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		AppUser user = appUserRepository.findByEmail(email.trim().toLowerCase())
				.orElseThrow(() -> new UsernameNotFoundException("Invalid email or password"));

		return User.builder()
				.username(user.getEmail())
				.password(user.getPassword())
				.disabled(!user.isEnabled())
				.roles(user.getRole().replace("ROLE_", ""))
				.build();
	}
}
