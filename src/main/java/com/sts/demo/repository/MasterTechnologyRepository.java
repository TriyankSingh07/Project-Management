package com.sts.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sts.demo.entity.MasterTechnology;

public interface MasterTechnologyRepository extends JpaRepository<MasterTechnology, Integer> {

	/**
	 * Dynamic search: each filter is optional. Pass {@code null} for
	 * technologyName or status to skip that condition.
	 */
	@Query("""
			SELECT m FROM MasterTechnology m
			WHERE (:technologyName IS NULL OR LOWER(m.name) LIKE LOWER(CONCAT('%', :technologyName, '%')))
			  AND (:status IS NULL OR m.status = :status)
			ORDER BY m.id ASC
			""")
	List<MasterTechnology> searchByFilters(@Param("technologyName") String technologyName,
			@Param("status") Integer status);
}
