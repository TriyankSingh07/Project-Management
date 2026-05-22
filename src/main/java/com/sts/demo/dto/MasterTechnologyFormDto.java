package com.sts.demo.dto;

import com.sts.demo.entity.MasterTechnology;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class MasterTechnologyFormDto {

	private Integer id;

	@NotBlank(message = "Name is required")
	@Size(max = 255, message = "Name must be at most 255 characters")
	private String name;

	private Integer status;

	public MasterTechnologyFormDto() {
	}

	public static MasterTechnologyFormDto from(MasterTechnology technology) {
		MasterTechnologyFormDto dto = new MasterTechnologyFormDto();
		dto.setId(technology.getId());
		dto.setName(technology.getName());
		dto.setStatus(technology.getStatus());
		return dto;
	}

	public MasterTechnology toEntity() {
		MasterTechnology technology = new MasterTechnology();
		technology.setId(id);
		technology.setName(name);
		technology.setStatus(status);
		return technology;
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
