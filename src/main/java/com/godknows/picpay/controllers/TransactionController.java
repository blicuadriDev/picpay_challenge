package com.godknows.picpay.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.godknows.picpay.dtos.TransactionDTO;
import com.godknows.picpay.entities.Transaction;
import com.godknows.picpay.services.TransactionService;

@RestController
@RequestMapping(value="/transactions")
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping
	public ResponseEntity<Transaction> createTransaction (@RequestBody TransactionDTO transaction) throws Exception{
		Transaction newTransaction = transactionService.createTransaction(transaction);
		return new ResponseEntity<>(newTransaction, HttpStatus.OK);
	}

}
