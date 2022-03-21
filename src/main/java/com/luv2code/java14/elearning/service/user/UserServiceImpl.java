package com.luv2code.java14.elearning.service.user;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.java14.elearning.common.exception.InvalidUserException;
import com.luv2code.java14.elearning.common.exception.NotFoundException;
import com.luv2code.java14.elearning.dto.user.UpdateUserDTO;
import com.luv2code.java14.elearning.dto.user.UserDTO;
import com.luv2code.java14.elearning.entity.user.User;
import com.luv2code.java14.elearning.repository.user.UserRepository;
import com.luv2code.java14.elearning.util.user.EmailValidation;
import com.luv2code.java14.elearning.util.user.UserConverter;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private EmailValidation emailValidation;
	
	@Autowired
	private UserRepository repository;
	
	@Override
	public List<UserDTO> findAll() {
		List<User> users = repository.findAll();
		
		if(users.isEmpty()) {
			throw new NotFoundException("This is for test only!!!");
		}
		
		return UserConverter.toUserDTOs(users);
	}
	
	@Override
	public UserDTO getUser(int id) {
		
		//Tìm một user và trả về userDTo
		Optional<User> userOpt = repository.findById(id);
		if(!userOpt.isPresent()) {
			throw new InvalidUserException("User id is not valid");
		}
		User user = userOpt.get();
		
		return UserConverter.toUserDTO(user);
	}

	@Override
	public UserDTO createUser(UserDTO userDTO) {
		
		//đầu tiên chuyển userDTO thành user
		//save user vào database
		//trả createdUser về lại userDTO
		
		User user = UserConverter.toUser(userDTO);
		
		//check email
		if(!emailValidation.isValidEmailAddress(user.getEmail())) {
			throw new InvalidUserException("Email is not valid");
		}
		//check password và retype password
		if(!user.getPassword().equals(user.getRetypePassword())) {
			throw new InvalidUserException("Password mismatch!!!");
		}
		
		User createdUser = repository.save(user);
		
		
		return UserConverter.toUserDTO(createdUser);
	}
	
	@Override
	public UserDTO updateUser(int id, UpdateUserDTO updateUserDTO) {
		Optional<User> userOpt = repository.findById(id);
		
		if(!userOpt.isPresent()) {
			throw new InvalidUserException("User id is not valid");
		}
		User user = userOpt.get();
		
		//xét các attribute mới thỏa mãn với database, nếu ko thì throw exception
		
		//nếu username từ database ko giống với username dto (chung id) 
		// vả username dto cũng ko giống với phần còn lại database thì ta update 
		if(!user.getUsername().equals(updateUserDTO.getUsername())) {
			if(repository.findByUsername(updateUserDTO.getUsername()).isPresent()) {
				throw new InvalidUserException("User name has been used.");
			}
			
			user.setUsername(updateUserDTO.getUsername());
			
		}
		if(!user.getEmail().equals(updateUserDTO.getEmail())){
			if(repository.findByEmail(updateUserDTO.getEmail()).isPresent()) {
				throw new InvalidUserException("Email has been used.");
			}
			else if(!emailValidation.isValidEmailAddress(updateUserDTO.getEmail())) {
				throw new InvalidUserException("Email is not valid");
			}
			user.setEmail(updateUserDTO.getEmail());
		}
		//đổi password ko cần xét giống phần còn lại của database
		if(!user.getPassword().equals(updateUserDTO.getPassword())) {
			user.setPassword(updateUserDTO.getPassword());
		}
		
		user.setName(updateUserDTO.getName());
		
		//save user update vào database và return update user thành dto
		User updatedUser = repository.save(user);
	
		return UserConverter.toUserDTO(updatedUser);
	}

	@Override
	public void deleteUser(int id) {
		//check database có userId không
		// nếu không có thì throw exception
		// nếu có thì delete user
		Optional <User> userOpt = repository.findById(id);
		
		if(!userOpt.isPresent()) {
			throw new InvalidUserException("User id is not existed!");
		}
		repository.delete(userOpt.get());
	}

	@Override
	public Optional<User> findByUsername(String username) {
		
		return  repository.findByUsername(username);
	}

	@Override
	public Optional<User> findByEmail(String email) {
		
		return repository.findByEmail(email);
	}


}
