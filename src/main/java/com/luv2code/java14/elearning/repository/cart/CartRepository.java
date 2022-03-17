package com.luv2code.java14.elearning.repository.cart;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.luv2code.java14.elearning.entity.cart.CartCourse;

@Repository
public interface CartRepository extends JpaRepository<CartCourse, Integer>{
	
	@Query(value="SELECT c FROM CartCourse c WHERE c.cartId=?1", nativeQuery = true )
	List<CartCourse> getAllCourseByCartId(int cartId);

	@Query(value="SELECT b FROM CartCourse b WHERE b.courseId =:courseId and b.cartId =:cartId", nativeQuery = true)
	Optional<CartCourse> findByCourseIdCartId(@Param("courseId")int courseId, @Param("cartId") int cartId);

//	List<CartCourse> findTickedCourse(int cartId, boolean b);

	


}
