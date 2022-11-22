package com.springsecuritywithoauthserver.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.springsecuritywithoauthserver.pojo.EmployeeInfoDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "EmployeeInformation")
public class EmployeeInfo {

	
	@Id
	private int empid;
		
	@Column(name = "UserName")
	private String username;
	
	@Column(name = "empPassword")
	private String empPassword;
	
	@Column(name = "EmpLocation")
	private String empLocation;
	
	@Column(name = "EmpTechnology")
	private String empTechnology;
	
	@Column(name = "EmpProjectName")
	private String empProjectName; 

}
