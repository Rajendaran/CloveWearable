package com.clovewearable.cove.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clovewearable.cove.constants.ICoveConstant;
import com.clovewearable.cove.exception.UserCustomException;
import com.clovewearable.cove.model.User;
import com.clovewearable.cove.service.IUserService;

/**
 * @author Rajendaran
 *
 */

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value = "/createuser")
	public ResponseEntity<String> createUser() {
		logger.info("Begins UserController => createUser method");
		User user = new User();
		user.setName("Rajendaransss");
		user.setEmail("rajendrena@gmail.com");
		user.setPincode("123456");
		Integer count = 0;
		try {
			count = userService.createUser(user);
			
		} catch (UserCustomException e) {
			logger.error(e.getMessage());
		}
		if (0 == count) {
			return new ResponseEntity<String>(ICoveConstant.USER_REGISTRATION_SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(ICoveConstant.USER_ALREADY_EXIST, HttpStatus.CONFLICT);
		
	}

}
