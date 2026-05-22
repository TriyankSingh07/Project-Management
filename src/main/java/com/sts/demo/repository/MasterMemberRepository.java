package com.sts.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sts.demo.entity.MasterMember;

public interface MasterMemberRepository extends JpaRepository<MasterMember, Integer> {

	public List<MasterMember> findByName(String name);
}
