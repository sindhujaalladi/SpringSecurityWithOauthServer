package com.springsecuritywithoauthserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springsecuritywithoauthserver.Entity.EmployeeInfo;
import com.springsecuritywithoauthserver.Repository.EmployeeInfoRepository;



@Service
public class EmployeeInfoUserDetailsService implements UserDetailsService{
	
	@Autowired
	private EmployeeInfoRepository  employeeInfoRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		EmployeeInfo empentobj = employeeInfoRepository.findByUsername(username);
		if(empentobj == null) {
			throw new UsernameNotFoundException("User not found");
		}
		return new EmployeeInfoUserDetails(empentobj);
		

		}

}
