package com.sts.demo.service;

import java.util.List;

import com.sts.demo.entity.MasterTechnology;
import com.sts.demo.search.MasterTechnologySearch;

public interface MasterTechnologyService {

	MasterTechnology save(MasterTechnology technology);

	List<MasterTechnology> getAll();

	/**
	 * Returns technologies matching optional filters from the search model.
	 */
	List<MasterTechnology> search(MasterTechnologySearch search);

	MasterTechnology getById(Integer id);
}
