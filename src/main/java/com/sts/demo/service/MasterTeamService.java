package com.sts.demo.service;

import java.util.List;

import com.sts.demo.entity.MasterTeam;

public interface MasterTeamService {

	MasterTeam save(MasterTeam team);

	List<MasterTeam> getAll();

	MasterTeam getById(Integer id);
}
