package com.sts.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.demo.entity.MasterTransaction;
import com.sts.demo.repository.MasterTransactionRepository;
import com.sts.demo.service.MasterTransactionService;

@Service
public class MasterTransactionServiceImpl implements MasterTransactionService {

	@Autowired
	private MasterTransactionRepository repository;

	@Override
	public MasterTransaction save(MasterTransaction transaction) {
		return repository.save(transaction);
	}

	@Override
	public List<MasterTransaction> getAll() {
		return repository.findAll();
	}

	@Override
	public MasterTransaction getById(Integer id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
	}
}