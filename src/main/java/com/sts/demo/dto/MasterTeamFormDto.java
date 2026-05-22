package com.sts.demo.dto;

import com.sts.demo.entity.MasterTeam;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class MasterTeamFormDto {

	private Integer id;

	@NotBlank(message = "Team name is required")
	@Size(max = 255, message = "Team name must be at most 255 characters")
	private String teamName;

	private Integer status;

	public MasterTeamFormDto() {
	}

	public static MasterTeamFormDto from(MasterTeam team) {
		MasterTeamFormDto dto = new MasterTeamFormDto();
		dto.setId(team.getId());
		dto.setTeamName(team.getTeamName());
		dto.setStatus(team.getStatus());
		return dto;
	}

	public MasterTeam toEntity() {
		MasterTeam team = new MasterTeam();
		team.setId(id);
		team.setTeamName(teamName);
		team.setStatus(status);
		return team;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
