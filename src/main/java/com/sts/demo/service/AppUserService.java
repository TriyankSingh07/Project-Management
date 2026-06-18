package com.sts.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sts.demo.dto.SignupFormDto;
import com.sts.demo.entity.AppUser;
import com.sts.demo.repository.AppUserRepository;

@Service
public class AppUserService {

	@Autowired
	private AppUserRepository appUserRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public boolean existsByEmail(String email) {
		return appUserRepository.existsByEmail(email);
	}

	@Transactional
	public void register(SignupFormDto form) {
		AppUser user = new AppUser();
		user.setFullName(form.getFullName());
		user.setEmail(form.getEmail().trim().toLowerCase());
		user.setPassword(passwordEncoder.encode(form.getPassword()));
		user.setRole("ROLE_USER");
		user.setEnabled(true);
		appUserRepository.save(user);
	}
}
