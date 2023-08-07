package com.technojade.allybot.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technojade.allybot.entity.EmployeeDepartmentMapping;
import com.technojade.allybot.repository.EmployeeDepartmentMappingRepository;

@Service
public class EmployeeDepartmentMappingServiceImpl implements EmployeeDepartmentMappingService {

	@Autowired
	public EmployeeDepartmentMappingRepository empRepo;

	@Override
	@Transactional
	public List<EmployeeDepartmentMapping> saveEmployeeDepartmentMapping(List<EmployeeDepartmentMapping> emp) {
		// TODO Auto-generated method stub
		List<EmployeeDepartmentMapping> saveAll = empRepo.saveAll(emp);
		return saveAll;
	}

	@Override
	@Transactional
	public void deleteAllEmpByEmpId(Long empId) {
		// TODO Auto-generated method stub
		empRepo.deleteAllByEmpId(empId);
	}

	@Override
	public List<EmployeeDepartmentMapping> listOfEmpDept(Long empId) {
		// TODO Auto-generated method stub
		List<EmployeeDepartmentMapping> byEmpId = empRepo.findAllByEmpId(empId);
		return byEmpId;
	}

}
