package com.sts.demo.dto;

import com.sts.demo.entity.AppUser;

public class UserResponse {

	private Long id;
	private String email;
	private String fullName;
	private String role;
	private boolean enabled;

	public UserResponse() {
	}

	public static UserResponse from(AppUser user) {
		UserResponse response = new UserResponse();
		response.setId(user.getId());
		response.setEmail(user.getEmail());
		response.setFullName(user.getFullName());
		response.setRole(user.getRole());
		response.setEnabled(user.isEnabled());
		return response;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
