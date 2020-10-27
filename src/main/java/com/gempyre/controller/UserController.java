package com.gempyre.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gempyre.model.User;
import com.gempyre.repository.UserRepository;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/users")
	public List<User> getUser() {
		return (List<User>) userRepository.findAll();
	}

	@PostMapping("/users")
	void addUser(@RequestBody User user) {
		userRepository.save(user);
	}

	@RequestMapping("/hello")
	@ResponseBody
	String home() {
		return "Hello World!";
	}

}
