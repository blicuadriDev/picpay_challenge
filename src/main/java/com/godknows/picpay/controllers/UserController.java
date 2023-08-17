package com.godknows.picpay.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.godknows.picpay.dtos.UserDTO;
import com.godknows.picpay.entities.User;
import com.godknows.picpay.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping(value="/new")
	public ResponseEntity<User> userDTO (@RequestBody UserDTO user){
		User newUser = userService.createUser(user);
		return new ResponseEntity<>(newUser, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getUsers(){
		List<User> users = userService.findUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

}
