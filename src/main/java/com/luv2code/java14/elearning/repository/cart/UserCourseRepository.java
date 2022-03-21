package com.luv2code.java14.elearning.repository.cart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luv2code.java14.elearning.entity.cart.Cart;
import com.luv2code.java14.elearning.entity.cart.CartKey;

@Repository
public interface UserCourseRepository extends JpaRepository<Cart, CartKey> {
}
