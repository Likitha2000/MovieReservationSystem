package com.theatre.booking.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.theatre.booking.model.Theatre;
import com.theatre.booking.model.TheatreResponse;
import com.theatre.booking.service.TheatreService;

@RestController
@RequestMapping("/theatre")
public class TheatreController {
	
	@Autowired
	TheatreService theatreService;

	@GetMapping("/displayTheatreInformation")
	public ResponseEntity<List<Theatre>> getTheatreInformation(){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(theatreService.getAllTheatreInformation());
		}
		catch(Exception e){
			return null;
		}
	}
	
	@PostMapping("/updateTheatreInformation")
	public ResponseEntity<TheatreResponse> updateTheatreInfo(@RequestBody Map<String,Object> theatre) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(theatreService.updateTheatreData(theatre));
		}
		catch(Exception e) {
			return null;
		}
	}
}
