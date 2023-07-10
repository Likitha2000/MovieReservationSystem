package com.example.user.service;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.user.model.Users;
import com.example.user.repo.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

	@InjectMocks
	UserServiceImpl userServiceImpl;
	
	@Mock
	UserRepository userRepo;
	
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
		when(userRepo.findAll()).thenReturn(usersList);
		assertEquals(userServiceImpl.getAllUsers(),usersList);
		
	}


	@Test
	public void testRegisterUser() {
		Map<String,Object> newUser = new HashMap<String,Object>();
		newUser.put("username", "mockuser");
		newUser.put("age", 22);
		newUser.put("email", "username.22@gmail.com");
		newUser.put("password", "passowrd");
		Users user = new Users();
		user.setId(100);
		user.setEmailId("username.22@gmail.com");
		user.setAge(22);
		user.setPassword("password");
		user.setPhoneNumber("90909090");
		user.setUserName("mockuser");
		when(userRepo.save(any(Users.class))).thenReturn(user);
		assertEquals(userServiceImpl.registerUser(newUser),true);
		
	}
	

}
