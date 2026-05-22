package com.sts.demo.dto;

import com.sts.demo.entity.MasterMember;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class MasterMemberFormDto {

	private Integer id;

	@NotBlank(message = "Name is required")
	@Size(max = 255, message = "Name must be at most 255 characters")
	private String name;

	@NotBlank(message = "Designation is required")
	@Size(max = 255, message = "Designation must be at most 255 characters")
	private String designation;

	@NotBlank(message = "Team is required")
	@Size(max = 255, message = "Team must be at most 255 characters")
	private String team;

	private Integer status;

	public MasterMemberFormDto() {
	}

	public static MasterMemberFormDto from(MasterMember member) {
		MasterMemberFormDto dto = new MasterMemberFormDto();
		dto.setId(member.getId());
		dto.setName(member.getName());
		dto.setDesignation(member.getDesignation());
		dto.setTeam(member.getTeam());
		dto.setStatus(member.getStatus());
		return dto;
	}

	public MasterMember toEntity() {
		MasterMember member = new MasterMember();
		member.setId(id);
		member.setName(name);
		member.setDesignation(designation);
		member.setTeam(team);
		member.setStatus(status);
		return member;
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

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
