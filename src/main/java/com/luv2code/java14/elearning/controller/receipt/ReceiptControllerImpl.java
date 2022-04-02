package com.luv2code.java14.elearning.controller.receipt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.java14.elearning.common.ResponseHandler;
import com.luv2code.java14.elearning.dto.ReceiptDTO;
import com.luv2code.java14.elearning.entity.receipt.Receipt;
import com.luv2code.java14.elearning.service.receipt.ReceiptService;

@RestController
@RequestMapping("/api")
public class ReceiptControllerImpl implements ReceiptController {

	@Autowired
	private ReceiptService service;

	@Override
	public ResponseEntity<Object> createReceipt(int userId, int[] courseId) {

		ReceiptDTO receipt = service.createReceipt(userId, courseId);
		
		return ResponseHandler.getResponse(receipt, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> findReceiptByUserId(int userId) {
		
		List<ReceiptDTO> receipts = service.findReceiptByUserId(userId);
		
		return ResponseHandler.getResponse(receipts, HttpStatus.OK);
	}
}
