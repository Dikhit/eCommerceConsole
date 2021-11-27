package eCommerce.Services.User;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import Models.User.User;
import Services.User.UserServices;

public class UserServiceTest {

	UserServices userServices = new UserServices();
	
	@Test
	public void logInTest() {
		userServices = mock(UserServices.class);
		User user = userServices.getUserById("c4714af3-39f2-4b6a-bebb-8c5fb439ee0e");
		
		when(userServices.logIn("dikhitbhuyan@gmail.com", "'kaku0001")).thenReturn(user);
		
		System.out.println(userServices.logIn("dikhitbhuyan@gmail.com", "'kaku0001"));
		
		assertEquals(userServices.logIn("dikhitbhuyan@gmail.com", "'kaku0001"), user);
	}

}
