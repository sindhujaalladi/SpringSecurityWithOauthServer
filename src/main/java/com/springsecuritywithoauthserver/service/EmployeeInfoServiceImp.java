package com.springsecuritywithoauthserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springsecuritywithoauthserver.Entity.EmployeeInfo;
import com.springsecuritywithoauthserver.Repository.EmployeeInfoRepository;
import com.springsecuritywithoauthserver.pojo.EmployeeInfoDTO;


@Service
public class EmployeeInfoServiceImp implements EmployeeInfoService{
	
	@Autowired
	private EmployeeInfoRepository employeeInfoRepository;

	@Override
	public void createEmployeeData(EmployeeInfoDTO employeeInfoDTO) {
		// TODO Auto-generated method stub
		
		EmployeeInfo empenobj = new EmployeeInfo();
		
		empenobj.setEmpid(employeeInfoDTO.getEmpid());
		empenobj.setEmpLocation(employeeInfoDTO.getEmpLocation());
		empenobj.setUsername(employeeInfoDTO.getUsername());
		empenobj.setEmpProjectName(employeeInfoDTO.getEmpProjectName());
		empenobj.setEmpTechnology(employeeInfoDTO.getEmpTechnology());
		empenobj.setEmpPassword(employeeInfoDTO.getEmpPassword());
		employeeInfoRepository.save(empenobj);
		
	}

	@Override
	public EmployeeInfoDTO getEmployeeData(int empid) {
		// TODO Auto-generated method stub
		
		EmployeeInfo empentobj = employeeInfoRepository.findByempid(empid);
		EmployeeInfoDTO dtoobj = new EmployeeInfoDTO();
		
		dtoobj.setEmpid(empentobj.getEmpid());
		dtoobj.setEmpLocation(empentobj.getEmpLocation());
		dtoobj.setUsername(empentobj.getUsername());
		dtoobj.setEmpProjectName(empentobj.getEmpProjectName());
		dtoobj.setEmpTechnology(empentobj.getEmpTechnology());
		dtoobj.setEmpPassword(empentobj.getEmpPassword());
		return dtoobj;
	}

}
