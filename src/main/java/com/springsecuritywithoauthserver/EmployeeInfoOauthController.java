package com.springsecuritywithoauthserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springsecuritywithoauthserver.pojo.EmployeeInfoDTO;
import com.springsecuritywithoauthserver.service.EmployeeInfoService;

@RestController
@RequestMapping("/employee/rest/oauth")
public class EmployeeInfoOauthController {
	
	
	@Autowired
	private EmployeeInfoService employeeInfoService;
	
	@PostMapping("/postEmpData")
	public ResponseEntity<EmployeeInfoDTO> createEmployeeData(@RequestBody EmployeeInfoDTO employeeInfoDTO){
		this.employeeInfoService.createEmployeeData(employeeInfoDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
		
	}
	
	@GetMapping("/{empid}")
	public ResponseEntity<EmployeeInfoDTO> getEmployeeData(@PathVariable int empid){
		EmployeeInfoDTO employeeInfoDTO = this.employeeInfoService.getEmployeeData(empid);
		return new ResponseEntity<>(employeeInfoDTO,HttpStatus.OK);
	}

}
