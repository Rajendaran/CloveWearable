package com.clovewearable.cove.constants;

/**
 * @author Rajendaran
 *
 */
public interface ICoveConstant {
	
	//HQL Queries
	public static final String USER_EXIST_CHECK_QUERY = "FROM User as user WHERE user.email = ?";
	
	//Error/common messages
	public static final String USER_REGISTRATION_SUCCESS = "User created successfully";
	public static final String USER_ALREADY_EXIST = "User alrady exist";

}
