package com.example.user.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.user.model.*;

public interface UserRepository  extends JpaRepository<Users, Integer>{
	
	Users findByUsernameAndPassword(String username, String password);
}
