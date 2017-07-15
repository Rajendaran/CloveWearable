package com.clovewearable.cove.service.impl;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clovewearable.cove.dao.IUserDao;
import com.clovewearable.cove.exception.UserCustomException;
import com.clovewearable.cove.model.User;
import com.clovewearable.cove.service.IUserService;

/**
 * @author Rajendaran
 *
 */

@Service
public class UserService implements IUserService {
	
	@Autowired
	private IUserDao userDao;

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Override
	public Integer createUser(User user) throws UserCustomException {
		logger.info("Begins UserService => createUser method");
		return userDao.createUser(user);
	}

}
