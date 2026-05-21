package com.sts.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sts.demo.entity.MasterClient;

public interface MasterClientRepository extends JpaRepository<MasterClient, Integer> {

	public List<MasterClient> findByName(String name);
}
