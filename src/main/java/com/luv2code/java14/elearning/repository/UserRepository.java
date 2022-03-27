package com.luv2code.java14.elearning.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luv2code.java14.elearning.entity.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	Optional<User> findByUsername(String username);

	Optional<User> findByEmail(String email);

//	@Override
//	@EntityGraph(attributePaths = {"cartCourse","cartCourse.course"})
//	Optional<User> findById(Integer id);
}
