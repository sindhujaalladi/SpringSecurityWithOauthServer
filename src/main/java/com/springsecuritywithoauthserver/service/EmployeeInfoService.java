package com.springsecuritywithoauthserver.service;

import com.springsecuritywithoauthserver.pojo.EmployeeInfoDTO;

public interface EmployeeInfoService {
	
	void createEmployeeData(EmployeeInfoDTO employeeInfoDTO);
	
	EmployeeInfoDTO getEmployeeData(int empid);
	

}
