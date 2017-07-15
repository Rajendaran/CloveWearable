package com.clovewearable.cove.junit;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.clovewearable.cove.exception.UserCustomException;
import com.clovewearable.cove.model.User;
import com.clovewearable.cove.service.impl.UserService;

/**
 * @author Rajendaran
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class UserTest {
	
	@Autowired
	private UserService userService;
	
	@Test
	public void createUser() throws UserCustomException {
		User user = new User();
		user.setName("Rajendaran");
		user.setEmail("rajendren@gmail.com");
		user.setPincode("123456");
		Integer count = userService.createUser(user);
		assertTrue(0 == count);
	}
}
