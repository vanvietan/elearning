package com.luv2code.java14.elearning.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.luv2code.java14.elearning.entity.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	@Query(value="SELECT * FROM user WHERE username = ?1", nativeQuery = true)
	Optional<User> findByUsername(String username);

	Optional<User> findByEmail(String email);
}
