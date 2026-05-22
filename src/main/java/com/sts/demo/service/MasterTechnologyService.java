package com.sts.demo.service;

import java.util.List;

import com.sts.demo.entity.MasterTechnology;

public interface MasterTechnologyService {

	MasterTechnology save(MasterTechnology technology);

	List<MasterTechnology> getAll();

	MasterTechnology getById(Integer id);
}
