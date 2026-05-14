package com.sts.demo.service;

import java.util.List;

import com.sts.demo.entity.MasterTransaction;

public interface MasterTransactionService {

	MasterTransaction save(MasterTransaction transaction);

	List<MasterTransaction> getAll();

	MasterTransaction getById(Integer id);

	void delete(Integer id);
}