package com.example.user.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.model.Users;
import com.example.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/allUsers")
	public ResponseEntity<List<Users>> getAllUsers(){
		try{
			return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
		}
		catch(Exception e) {
			System.out.println("Error retrieving al users");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<Users> loginUser(@RequestParam String username, @RequestParam String password){
		try {
			Users user = userService.checkUser(username,password);
			HttpHeaders headers = new HttpHeaders();
			headers.add("User-ID", ((Integer)user.getId()).toString());
			return ResponseEntity.ok().headers(headers).body(user);
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
	}
	
	@PostMapping("/registration")
	public ResponseEntity<String> registerUser(@RequestBody Map<String,Object> user){
		try {
			if(userService.registerUser(user))
				return ResponseEntity.status(HttpStatus.OK).body("Successful");
			else	
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Unsuccessful");
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unsuccessful");
		}
	}
}
