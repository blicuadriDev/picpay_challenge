package com.godknows.picpay.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.godknows.picpay.dtos.TransactionDTO;
import com.godknows.picpay.entities.Transaction;
import com.godknows.picpay.entities.User;
import com.godknows.picpay.repositories.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	private UserService userService;

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private NotificationService notificationService;

	public Transaction createTransaction(TransactionDTO transaction) throws Exception {
		User sender = userService.findUserById(transaction.getSenderId());
		User receiver = userService.findUserById(transaction.getReceiverId());

		userService.validateTransaction(sender, transaction.getValue());
		
		boolean isAuthorized = authorizeTransaction(sender, transaction.getValue());
		if(!isAuthorized) {
			throw new Exception("Transação não autorizada");
		}
		
		Transaction newTransaction = new Transaction();
		newTransaction.setAmount(transaction.getValue());
		newTransaction.setSender(sender);
		newTransaction.setReceiver(receiver);
		newTransaction.setTimestamp(LocalDateTime.now());
		
		sender.setBalance(sender.getBalance().subtract(transaction.getValue()));
		receiver.setBalance(receiver.getBalance().add(transaction.getValue()));
		
		transactionRepository.save(newTransaction);
		userService.saveUser(receiver);
		userService.saveUser(sender);
		
		notificationService.sendNotification(sender, "Transaction sent succesfully");
		notificationService.sendNotification(receiver, "Transaction received succesfully");
		
		return newTransaction;
	}

	public boolean authorizeTransaction(User sender, BigDecimal value) {
		ResponseEntity<Map> authorizationResponse = restTemplate.getForEntity("https://run.mocky.io/v3/8fafdd68-a090-496f-8c9a-3442cf30dae6", Map.class);
		if (authorizationResponse.getStatusCode() == HttpStatus.OK) {
			String message = (String) authorizationResponse.getBody().get("message");
			return "Autorizado".equalsIgnoreCase(message);
		}else return false;
	}
}
