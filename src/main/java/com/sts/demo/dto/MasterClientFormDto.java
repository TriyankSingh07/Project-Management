package com.sts.demo.dto;

import com.sts.demo.entity.MasterClient;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class MasterClientFormDto {

	private Integer id;

	@NotBlank(message = "Name is required")
	@Size(max = 100, message = "Name must be at most 100 characters")
	private String name;

	@NotBlank(message = "Email is required")
	@Email(message = "Enter a valid email address")
	@Size(max = 150, message = "Email must be at most 150 characters")
	private String email;

	@NotBlank(message = "Phone number is required")
	@Pattern(regexp = "^[0-9+\\-\\s]{7,20}$", message = "Enter a valid phone number")
	private String phone;

	@NotBlank(message = "Contact person is required")
	@Size(max = 100, message = "Contact person must be at most 100 characters")
	private String contact;

	@NotNull(message = "Status is required")
	private Integer status;

	public MasterClientFormDto() {
	}

	public static MasterClientFormDto from(MasterClient client) {
		MasterClientFormDto dto = new MasterClientFormDto();
		dto.setId(client.getId());
		dto.setName(client.getName());
		dto.setEmail(client.getEmail());
		dto.setPhone(client.getPhone());
		dto.setContact(client.getContact());
		dto.setStatus(client.getStatus());
		return dto;
	}

	public MasterClient toEntity() {
		MasterClient client = new MasterClient();
		client.setId(id);
		client.setName(name);
		client.setEmail(email);
		client.setPhone(phone);
		client.setContact(contact);
		client.setStatus(status);
		return client;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
