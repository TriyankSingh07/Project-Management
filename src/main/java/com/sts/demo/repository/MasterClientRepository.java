package com.sts.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sts.demo.entity.MasterClient;

public interface MasterClientRepository extends JpaRepository<MasterClient, Integer> {

}
