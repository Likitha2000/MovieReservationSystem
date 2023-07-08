package com.example.user.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.user.model.Users;
import com.example.user.repo.UserRepository;
import com.example.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepo;
	
	@Override
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}
	
	@Override
	public Users checkUser(String username,String password) {
		return userRepo.findByUsernameAndPassword(username,password);
	}
	
	@Override
	public boolean registerUser(Map<String,Object> user) {
		Users newUser = new Users();
		newUser.setUserName((String) user.get("username"));
		newUser.setPassword((String) user.get("password"));
		newUser.setPhoneNumber((String) user.get("phonenumber"));
		newUser.setAge((int) user.get("age"));
		newUser.setEmailId((String) user.get("emailid"));
		if(userRepo.save(newUser).getClass() == Users.class) {
			return true;
		}
		else {
			return false;
		}
	}

}
