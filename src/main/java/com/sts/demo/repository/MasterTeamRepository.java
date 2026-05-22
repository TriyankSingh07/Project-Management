package com.sts.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sts.demo.entity.MasterTeam;

public interface MasterTeamRepository extends JpaRepository<MasterTeam, Integer> {
}
