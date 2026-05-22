package com.sts.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.demo.entity.MasterTeam;
import com.sts.demo.repository.MasterTeamRepository;
import com.sts.demo.service.MasterTeamService;

@Service
public class MasterTeamServiceImpl implements MasterTeamService {

	@Autowired
	private MasterTeamRepository repository;

	@Override
	public List<MasterTeam> getAll() {
		return repository.findAll();
	}

	@Override
	public MasterTeam save(MasterTeam team) {
		return repository.save(team);
	}

	@Override
	public MasterTeam getById(Integer id) {
		return repository.findById(id).orElse(null);
	}
}
