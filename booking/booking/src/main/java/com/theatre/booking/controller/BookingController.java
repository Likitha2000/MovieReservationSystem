package com.theatre.booking.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.theatre.booking.model.BookedResponse;
import com.theatre.booking.model.Booking;
import com.theatre.booking.service.BookingService;
import com.theatre.booking.service.TheatreService;

@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	TheatreService theatreService;
	
	@Autowired
	BookingService bookingService;

	@GetMapping("/displayBookings")
	public ResponseEntity<List<Booking>> displayBookings(){
		try {
	        return ResponseEntity.status(HttpStatus.OK).body(bookingService.getAllBookingInformation());
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
	}
	
	@PostMapping("/bookTicket")
	public ResponseEntity<BookedResponse> bookTicket(@RequestHeader("User-ID") String userId, @RequestBody Map<String,Object> ticket) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(bookingService.bookTicket(userId, ticket));
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
	}
	
}