package com.sts.demo.service;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sts.demo.dto.AuthResponse;
import com.sts.demo.dto.LoginRequest;
import com.sts.demo.dto.SignupRequest;
import com.sts.demo.dto.UserResponse;
import com.sts.demo.entity.AppUser;
import com.sts.demo.exception.ApiException;
import com.sts.demo.security.JwtService;

@Service
public class AuthService {

	private final AppUserService appUserService;
	private final AuthenticationManager authenticationManager;
	private final JwtService jwtService;

	public AuthService(AppUserService appUserService, AuthenticationManager authenticationManager,
			JwtService jwtService) {
		this.appUserService = appUserService;
		this.authenticationManager = authenticationManager;
		this.jwtService = jwtService;
	}

	@Transactional
	public AuthResponse register(SignupRequest request) {
		AppUser user = appUserService.createUser(request.getFullName(), request.getEmail(), request.getPassword());
		return buildAuthResponse(user);
	}

	public AuthResponse login(LoginRequest request) {
		String email = request.getEmail().trim().toLowerCase();
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(email, request.getPassword()));
		} catch (DisabledException ex) {
			throw new ApiException(HttpStatus.FORBIDDEN, "Account is disabled");
		} catch (BadCredentialsException ex) {
			throw new ApiException(HttpStatus.UNAUTHORIZED, "Invalid email or password");
		}

		AppUser user = appUserService.findByEmail(email);
		return buildAuthResponse(user);
	}

	public UserResponse currentUser(String email) {
		return UserResponse.from(appUserService.findByEmail(email));
	}

	private AuthResponse buildAuthResponse(AppUser user) {
		String token = jwtService.generateToken(user);
		return new AuthResponse(token, "Bearer", jwtService.getJwtExpiration() / 1000, UserResponse.from(user));
	}
}
