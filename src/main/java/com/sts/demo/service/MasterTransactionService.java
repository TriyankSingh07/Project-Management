package com.sts.demo.service;

import java.util.List;

import com.sts.demo.entity.MasterTransaction;
import com.sts.demo.search.MasterTransactionSearch;

public interface MasterTransactionService {

	MasterTransaction save(MasterTransaction transaction);

	List<MasterTransaction> getAll();

	/**
	 * Returns transactions matching optional filters from the search model.
	 */
	List<MasterTransaction> search(MasterTransactionSearch search);

	MasterTransaction getById(Integer id);
}
