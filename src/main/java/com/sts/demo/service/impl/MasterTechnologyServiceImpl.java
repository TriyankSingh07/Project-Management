package com.sts.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.demo.entity.MasterTechnology;
import com.sts.demo.repository.MasterTechnologyRepository;
import com.sts.demo.search.MasterTechnologySearch;
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
	public List<MasterTechnology> search(MasterTechnologySearch search) {
		String technologyName = normalize(search.getTechnologyName());
		Integer status = search.getStatus();
		return repository.searchByFilters(technologyName, status);
	}

	@Override
	public MasterTechnology save(MasterTechnology technology) {
		return repository.save(technology);
	}

	@Override
	public MasterTechnology getById(Integer id) {
		return repository.findById(id).orElse(null);
	}

	/** Blank strings are treated as no filter (same as Yii2 empty search attributes). */
	private String normalize(String value) {
		if (value == null || value.trim().isEmpty()) {
			return null;
		}
		return value.trim();
	}
}
