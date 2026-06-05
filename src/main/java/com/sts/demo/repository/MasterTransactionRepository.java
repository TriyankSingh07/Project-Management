package com.sts.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sts.demo.entity.MasterTransaction;

public interface MasterTransactionRepository extends JpaRepository<MasterTransaction, Integer> {

	/**
	 * Dynamic search: each filter is optional. Pass {@code null} for
	 * transactionName or status to skip that condition.
	 */
	@Query("""
			SELECT m FROM MasterTransaction m
			WHERE (:transactionName IS NULL OR LOWER(m.name) LIKE LOWER(CONCAT('%', :transactionName, '%')))
			  AND (:status IS NULL OR m.status = :status)
			ORDER BY m.id ASC
			""")
	List<MasterTransaction> searchByFilters(@Param("transactionName") String transactionName,
			@Param("status") Integer status);
}
