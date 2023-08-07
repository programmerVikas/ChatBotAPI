package com.technojade.allybot.service;

import java.util.List;

import com.technojade.allybot.entity.EmployeeDepartmentMapping;

public interface EmployeeDepartmentMappingService {

	
	public List<EmployeeDepartmentMapping> saveEmployeeDepartmentMapping(List<EmployeeDepartmentMapping> emp);
	
	public void deleteAllEmpByEmpId(Long empId);
	
	public List<EmployeeDepartmentMapping> listOfEmpDept(Long empId);
	
}
