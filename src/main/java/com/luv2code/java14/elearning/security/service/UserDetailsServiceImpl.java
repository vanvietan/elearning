package com.luv2code.java14.elearning.security.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.luv2code.java14.elearning.entity.user.Role;
import com.luv2code.java14.elearning.entity.user.User;
import com.luv2code.java14.elearning.repository.UserRepository;
import com.luv2code.java14.elearning.security.dto.CustomUserDetails;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> userOpt = repository.findByUsername(username);
		
		if (!userOpt.isPresent())
			throw new UsernameNotFoundException("Username is not existed.");
		
		User currentUser = userOpt.get();
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.addAll(getAuthorities(currentUser));
		
		return new CustomUserDetails(currentUser.getUsername()
				, currentUser.getPassword(), authorities);
	}

	private List<? extends GrantedAuthority> getAuthorities(final User currentUser) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		Role role = currentUser.getRole();
		
		authorities.add(new SimpleGrantedAuthority(role.getDescription()));

		return authorities;
	}
}
