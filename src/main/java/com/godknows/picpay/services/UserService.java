package com.godknows.picpay.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.godknows.picpay.entities.User;
import com.godknows.picpay.entities.UserType;
import com.godknows.picpay.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	public void validateTransaction(User sender, BigDecimal amount) throws Exception {
		if(sender.getUserType() == UserType.MERCHANT) {
			throw new Exception("Merchant user not allowed for sender transaction.");
		}
		
		if(sender.getBalance().compareTo(amount) < 0) {
			throw new Exception("Insufficient fund available for this transaction.");
		}
	}
	
	@Transactional(readOnly = true)
	public User findUserById(Long id) throws Exception {
		return this.userRepository.findById(id).orElseThrow( () -> new Exception("User not found"));
	}
	
	@Transactional
	public void saveUser(User user) {
		this.userRepository.save(user);
	}

}
