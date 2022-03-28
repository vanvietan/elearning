package com.luv2code.java14.elearning.service.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.java14.elearning.entity.user.Role;
import com.luv2code.java14.elearning.repository.RoleRepository;
import com.luv2code.java14.elearning.util.user.RoleConst;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepository repository;
	
	
	@Override
	public Role findRoleUser() {
		
		Role role = repository.getById(RoleConst.ROLE_USER_ID);
		
		return role;
	}


	@Override
	public Role findRoleInstructor() {
		
		Role role = repository.getById(RoleConst.ROLE_INSTRUCTOR_ID);
		
		return role;
	}

}
