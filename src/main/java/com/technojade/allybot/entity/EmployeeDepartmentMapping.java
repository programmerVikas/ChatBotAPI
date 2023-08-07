package com.technojade.allybot.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDepartmentMapping {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long deptMappingId;
	private Long empId;
	private LocalDateTime createdDate;
	private LocalDateTime updatedOn;
	
}
