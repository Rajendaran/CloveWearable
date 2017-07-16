package com.clovewearable.cove.dao;

import java.util.List;

import com.clovewearable.cove.exception.UserCustomException;
import com.clovewearable.cove.model.User;

/**
 * @author Rajendaran
 *
 */
public interface IUserDao {
	
	public Integer createUser(User user) throws UserCustomException;
	
	public List<User> loginUser(Integer userId) throws UserCustomException;

}
