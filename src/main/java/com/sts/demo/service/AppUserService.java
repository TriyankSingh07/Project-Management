package com.sts.demo.service;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sts.demo.dto.SignupFormDto;
import com.sts.demo.entity.AppUser;
import com.sts.demo.exception.ApiException;
import com.sts.demo.repository.AppUserRepository;

@Service
public class AppUserService {

	private final AppUserRepository appUserRepository;
	private final PasswordEncoder passwordEncoder;

	public AppUserService(AppUserRepository appUserRepository, PasswordEncoder passwordEncoder) {
		this.appUserRepository = appUserRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public boolean existsByEmail(String email) {
		return appUserRepository.existsByEmail(email);
	}

	public AppUser findByEmail(String email) {
		return appUserRepository.findByEmail(email.trim().toLowerCase())
				.orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "User not found"));
	}

	@Transactional
	public void register(SignupFormDto form) {
		if (!form.getPassword().equals(form.getConfirmPassword())) {
			throw new ApiException(HttpStatus.BAD_REQUEST, "Passwords do not match");
		}
		createUser(form.getFullName(), form.getEmail(), form.getPassword());
	}

	@Transactional
	public AppUser createUser(String fullName, String email, String password) {
		String normalizedEmail = email.trim().toLowerCase();
		if (appUserRepository.existsByEmail(normalizedEmail)) {
			throw new ApiException(HttpStatus.CONFLICT, "Email is already registered");
		}

		AppUser user = new AppUser();
		user.setFullName(fullName.trim());
		user.setEmail(normalizedEmail);
		user.setPassword(passwordEncoder.encode(password));
		user.setRole("ROLE_USER");
		user.setEnabled(true);
		return appUserRepository.save(user);
	}
}
