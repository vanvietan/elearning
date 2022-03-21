package com.luv2code.java14.elearning.repository.cart;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.java14.elearning.entity.cart.CartCourse;
import com.luv2code.java14.elearning.entity.course.Course;

@Repository
public interface CartRepository extends JpaRepository<CartCourse, Integer> {

	@Query(value="SELECT * FROM cart_course WHERE user_id=?1", nativeQuery = true )
	List<CartCourse> getAllCourseByUserId(int userId);

	@Query(value="SELECT * FROM cart_course WHERE course_id =:courseId and user_id =:userId", nativeQuery = true)
	Optional<CartCourse> findByCourseIdCartId(@Param("courseId")int courseId, @Param("userId") int userId);

	@Modifying
	@Query(value="INSERT INTO cart_course (user_id, course_id) VALUES (:userId, :courseId)", nativeQuery = true)
	@Transactional
	void addCourseToCart(int userId, int courseId);

	@Query(value="SELECT * FROM cart_course u WHERE u.user_id=?1", nativeQuery = true)
	CartCourse getCartByUserId(int userId);
}
