package com.springsecuritywithoauthserver.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springsecuritywithoauthserver.Entity.EmployeeInfo;

@Repository
public interface EmployeeInfoRepository  extends JpaRepository<EmployeeInfo,Integer>{
	
	EmployeeInfo findByempid(int empid);
	
	EmployeeInfo findByUsername(String username);

}
