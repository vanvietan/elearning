package com.luv2code.java14.elearning.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.luv2code.java14.elearning.entity.receipt.Receipt;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Integer> {

	@Query(value="SELECT * FROM receipt WHERE user_id = ?1 AND created_at = ?2", nativeQuery = true)
	Receipt findReceiptCreatedByUserId(int userId, LocalDateTime createdAt);
}
