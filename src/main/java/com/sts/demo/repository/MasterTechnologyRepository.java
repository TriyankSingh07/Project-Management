package com.sts.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sts.demo.entity.MasterTechnology;

public interface MasterTechnologyRepository extends JpaRepository<MasterTechnology, Integer> {

	public List<MasterTechnology> findByName(String name);
}
