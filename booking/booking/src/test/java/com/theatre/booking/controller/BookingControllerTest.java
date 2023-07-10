package com.theatre.booking.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.theatre.booking.service.BookingService;
import com.theatre.booking.service.TheatreService;
import com.theatre.booking.model.BookedResponse;
import com.theatre.booking.model.Booking;

@RunWith(MockitoJUnitRunner.class)
public class BookingControllerTest {

	@InjectMocks
	BookingController bookingController;
	
	@Mock
	TheatreService theatreService;
	
	@Mock
	BookingService bookingService;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testDisplayBookings() {
		Booking mockedBooking = new Booking();
		mockedBooking.setId(101);
		mockedBooking.setDate("20/09/2023");
		mockedBooking.setMoviename("mocked Movie name");
		ArrayList<Booking> bookingList = new ArrayList<Booking>();
		bookingList.add(mockedBooking);
		when(bookingService.getAllBookingInformation()).thenReturn(bookingList);
		ResponseEntity<List<Booking>> response = bookingController.displayBookings();
		assertEquals(response.getStatusCode(),HttpStatus.OK);
		assertEquals(response.getBody().get(0),mockedBooking);
	}
	
	@Test
	public void testDisplayBookingsErrorScenario() {
		when(bookingService.getAllBookingInformation()).thenThrow(NullPointerException.class);
		ResponseEntity<List<Booking>> response = bookingController.displayBookings();
		assertEquals(response.getStatusCode(),HttpStatus.NO_CONTENT);
	}

	@Test
	public void testBookTicket() {
		Map<String,Object> ticket = new HashMap<String,Object>();
		ticket.put("date", "29/09/2023");
		ticket.put("moviename", "mocked Movie name");
		BookedResponse bookedResponse = new BookedResponse();
		bookedResponse.setBookingId(1);
		bookedResponse.setTotalCost(1000);
		when(bookingService.bookTicket("101", ticket)).thenReturn(bookedResponse);
		ResponseEntity<BookedResponse> response = bookingController.bookTicket("101",ticket);
		assertEquals(response.getStatusCode(),HttpStatus.OK);
		assertEquals(response.getBody(),bookedResponse);
	}
	
	@Test
	public void testBookTicketErrorScenario() {
		Map<String,Object> ticket = new HashMap<String,Object>();
		ticket.put("date", "29/09/2023");
		ticket.put("moviename", "mocked Movie name");
		when(bookingService.bookTicket("101", ticket)).thenThrow(NullPointerException.class);
		ResponseEntity<BookedResponse> response = bookingController.bookTicket("101",ticket);
		assertEquals(response.getStatusCode(),HttpStatus.NO_CONTENT);
	}


}
