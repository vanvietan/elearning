package com.luv2code.java14.elearning.service.receipt;

import java.util.List;

import com.luv2code.java14.elearning.entity.receipt.Receipt;

public interface ReceiptService {
	
	Receipt createReceipt(int userId, int[] courseId);

	List<Receipt> findAll();

}
