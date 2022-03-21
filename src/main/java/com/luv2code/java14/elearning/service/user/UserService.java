package com.luv2code.java14.elearning.service.user;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.luv2code.java14.elearning.dto.user.UpdateUserDTO;
import com.luv2code.java14.elearning.dto.user.UserDTO;
import com.luv2code.java14.elearning.entity.user.User;

public interface UserService {

	List<UserDTO> findAll();
	
	UserDTO getUser(int id);

	UserDTO createUser(@Valid UserDTO userDTO);

	UserDTO updateUser(int id, @Valid UpdateUserDTO updateUserDTO);

	void deleteUser(int id);
	
	Optional<User> findByUsername(String username);
	
	Optional<User> findByEmail(String email);
}
