package com.sts.demo.dto;

import com.sts.demo.entity.MasterTransaction;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class MasterTransactionFormDto {

	private Integer id;

	@NotBlank(message = "Name is required")
	@Size(max = 255, message = "Name must be at most 255 characters")
	private String name;

	private Integer status;

	public MasterTransactionFormDto() {
	}

	public static MasterTransactionFormDto from(MasterTransaction transaction) {
		MasterTransactionFormDto dto = new MasterTransactionFormDto();
		dto.setId(transaction.getId());
		dto.setName(transaction.getName());
		dto.setStatus(transaction.getStatus());
		return dto;
	}

	public MasterTransaction toEntity() {
		MasterTransaction transaction = new MasterTransaction();
		transaction.setId(id);
		transaction.setName(name);
		transaction.setStatus(status);
		return transaction;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
