package com.sts.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sts.demo.entity.MasterTransaction;

public interface MasterTransactionRepository extends JpaRepository<MasterTransaction, Integer> {

}