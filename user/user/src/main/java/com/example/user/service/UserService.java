package com.example.user.service;

import java.util.List;
import java.util.Map;

import com.example.user.model.Users;

public interface UserService {

	List<Users> getAllUsers();
	Users checkUser(String username, String password);
	boolean registerUser(Map<String,Object> user);

	
}
