package com.luv2code.java14.elearning.util.user;

import java.util.ArrayList;
import java.util.List;

import com.luv2code.java14.elearning.dto.UserDTO;
import com.luv2code.java14.elearning.entity.user.User;

public class UserConverter {
	
	public static UserDTO toUserDTO(User user) {
		
		return UserDTO.builder()
				.id(user.getId())
				.name(user.getName())
				.username(user.getUsername())
				.password(user.getPassword())
				.retypePassword(user.getRetypePassword())
				.email(user.getEmail())
				.build();
	}
	
	public static List<UserDTO> toUserDTOs(List<User> users){
		List<UserDTO> userDTOs = new ArrayList<>();
		
		for(User user : users) {
			userDTOs.add(UserConverter.toUserDTO(user));
		}
		
		return userDTOs;
	}
	
	public static User toUser(UserDTO userDTO) {
		return User.builder()
				.id(userDTO.getId())
				.name(userDTO.getName())
				.username(userDTO.getUsername())
				.password(userDTO.getPassword())
				.retypePassword(userDTO.getRetypePassword())
				.email(userDTO.getEmail())
				.build();
	}
}
