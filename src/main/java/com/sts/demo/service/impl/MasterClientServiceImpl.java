package com.sts.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.demo.entity.MasterClient;
import com.sts.demo.repository.MasterClientRepository;
import com.sts.demo.service.MasterClientService;

@Service
public class MasterClientServiceImpl implements MasterClientService {

	@Autowired
	private MasterClientRepository repository;

	@Override
	public List<MasterClient> getAll() {
		return repository.findAll();
	}

	@Override
	public MasterClient save(MasterClient client) {
		return repository.save(client);
	}

//	@Override
//	public MasterClient getById(Integer id) {
//		return repository.findById(id).orElse(null);
//	}
//
//	@Override
//	public void delete(Integer id) {
//		repository.deleteById(id);
//	}
}
