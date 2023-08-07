package com.technojade.allybot.dtos;

import java.util.List;

import com.technojade.allybot.entity.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeProfileUpdate {

	
	private Long empId;
	private String fname;
	private String mname;
	private String lname;
	private String email;
	private String contactNo;
	private Long age;
	private List<Long> departmentIds;
	private Long departmentId;
	private Long designationId;
	private Long roleId;
	private String address;
	private Long addressId;
	private Address addressObj;
	private Long cityId;
	private Long stateId;
	private String alternateContactNo;
	
	
}
