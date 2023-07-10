package com.example.user.Controller;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpHeaders;

import com.example.user.model.Users;
import com.example.user.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

	@InjectMocks
	UserController userController;
	
	@Mock
	UserService userService;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
	}

	@Test
	public void testGetAllUsers() {
		Users user = new Users();
		user.setId(100);
		user.setEmailId("abc.123@gmail.com");
		user.setAge(22);
		user.setPassword("password");
		user.setPhoneNumber("90909090");
		user.setUserName("username");
		ArrayList<Users> usersList = new ArrayList<Users>();
		usersList.add(user);
		when(userService.getAllUsers()).thenReturn(usersList);
		assertEquals(userController.getAllUsers().getBody(),usersList);
	}
	
	@Test
	public void testGetAllUsersErrorCase() {
		when(userService.getAllUsers()).thenThrow(NullPointerException.class);
		assertEquals(userController.getAllUsers().getBody(),null);
	}

//	@Test
//	public void testLoginUser() {
//		Users user = new Users();
//		user.setId(100);
//		user.setEmailId("abc.123@gmail.com");
//		user.setAge(22);
//		user.setPassword("password");
//		user.setPhoneNumber("90909090");
//		user.setUserName("username");
//        headers.add("User-ID", Integer.toString(user.getId()));
//		when(userService.checkUser(any(String.class),any(String.class))).thenReturn(user);
//		assertEquals(userController.loginUser(any(String.class), any(String.class)).getBody(),user);
//		
//	}

	@Test
	public void testLoginUserErrorCase() {
		Users user = new Users();
		user.setId(100);
		user.setEmailId("abc.123@gmail.com");
		user.setAge(22);
		user.setPassword("password");
		user.setPhoneNumber("90909090");
		user.setUserName("username");
		when(userService.checkUser(any(String.class),any(String.class))).thenReturn(user);
		assertEquals(userController.loginUser(any(String.class), any(String.class)).getBody(),null);
		
	}
	
	@Test
	public void testRegisterUser() {
		Map<String,Object> newUser = new HashMap<String,Object>();
		newUser.put("username", "mockuser");
		newUser.put("age", 22);
		newUser.put("email", "username.22@gmail.com");
		newUser.put("password", "passowrd");
		when(userService.registerUser(newUser)).thenReturn(true);
		assertEquals(userController.registerUser(newUser).getBody(),"Successful");
	}
	
	@Test
	public void testRegisterUserErrorCase() {
		Map<String,Object> newUser = new HashMap<String,Object>();
		newUser.put("username", "mockuser");
		newUser.put("age", 22);
		newUser.put("email", "username.22@gmail.com");
		newUser.put("password", "passowrd");
		when(userService.registerUser(newUser)).thenReturn(false);
		assertEquals(userController.registerUser(newUser).getBody(),"Unsuccessful");
	}

}
