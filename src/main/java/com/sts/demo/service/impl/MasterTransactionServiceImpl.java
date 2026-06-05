package com.sts.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.demo.entity.MasterTransaction;
import com.sts.demo.repository.MasterTransactionRepository;
import com.sts.demo.search.MasterTransactionSearch;
import com.sts.demo.service.MasterTransactionService;

@Service
public class MasterTransactionServiceImpl implements MasterTransactionService {

	@Autowired
	private MasterTransactionRepository repository;

	@Override
	public List<MasterTransaction> getAll() {
		return repository.findAll();
	}

	@Override
	public List<MasterTransaction> search(MasterTransactionSearch search) {
		String transactionName = normalize(search.getTransactionName());
		Integer status = search.getStatus();
		return repository.searchByFilters(transactionName, status);
	}

	@Override
	public MasterTransaction save(MasterTransaction transaction) {
		return repository.save(transaction);
	}

	@Override
	public MasterTransaction getById(Integer id) {
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
