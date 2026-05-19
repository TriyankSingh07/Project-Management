package com.sts.demo.service;

import java.util.List;

import com.sts.demo.entity.MasterClient;

public interface MasterClientService {

	MasterClient save(MasterClient client);

	List<MasterClient> getAll();

//	MasterClient getById(Integer id);
//
//	void delete(Integer id);
}
