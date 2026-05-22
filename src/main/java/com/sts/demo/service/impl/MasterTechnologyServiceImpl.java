package com.sts.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.demo.entity.MasterTechnology;
import com.sts.demo.repository.MasterTechnologyRepository;
import com.sts.demo.service.MasterTechnologyService;

@Service
public class MasterTechnologyServiceImpl implements MasterTechnologyService {

	@Autowired
	private MasterTechnologyRepository repository;

	@Override
	public List<MasterTechnology> getAll() {
		return repository.findAll();
	}

	@Override
	public MasterTechnology save(MasterTechnology technology) {
		return repository.save(technology);
	}

	@Override
	public MasterTechnology getById(Integer id) {
		return repository.findById(id).orElse(null);
	}
}
