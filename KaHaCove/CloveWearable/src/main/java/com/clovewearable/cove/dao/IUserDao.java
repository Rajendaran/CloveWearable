package com.clovewearable.cove.dao;

import com.clovewearable.cove.exception.UserCustomException;
import com.clovewearable.cove.model.User;

/**
 * @author Rajendaran
 *
 */
public interface IUserDao {
	
	public Integer createUser(User user) throws UserCustomException;

}
