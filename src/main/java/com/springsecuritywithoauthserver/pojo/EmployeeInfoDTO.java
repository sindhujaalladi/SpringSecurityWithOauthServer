package com.springsecuritywithoauthserver.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeInfoDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int empid;
	private String username;
	private String empLocation;
	private String empTechnology;
	private String empProjectName;
	private String empPassword;

	

}
