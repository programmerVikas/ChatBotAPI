package com.technojade.allybot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.technojade.allybot.entity.EmployeeDepartmentMapping;

@Repository
public interface EmployeeDepartmentMappingRepository extends JpaRepository<EmployeeDepartmentMapping, Long> {
	
	public void deleteAllByEmpId(Long empId);
	public List<EmployeeDepartmentMapping> findAllByEmpId(long id);

}
