package com.luv2code.java14.elearning.repository.cart;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.java14.elearning.entity.cart.UserCourse;
import com.luv2code.java14.elearning.entity.cart.UserCourseKey;

@Repository
public interface UserCourseRepository extends JpaRepository<UserCourse, UserCourseKey> {
}
