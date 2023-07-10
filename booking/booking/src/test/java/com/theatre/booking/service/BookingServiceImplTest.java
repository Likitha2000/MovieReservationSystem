package com.theatre.booking.service;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.theatre.booking.model.Booking;
import com.theatre.booking.model.Theatre;
import com.theatre.booking.repo.BookingRepository;
import com.theatre.booking.repo.TheatreRepository;

@RunWith(MockitoJUnitRunner.class)
public class BookingServiceImplTest {

	@InjectMocks
	BookingServiceImpl bookingServiceImpl;
	
	@Mock
	BookingRepository bookingRepo;
	
	@Mock
	TheatreRepository theatreRepo;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetAllBookingInformation() {
		Booking mockedBooking = new Booking();
		mockedBooking.setId(101);
		mockedBooking.setDate("20/09/2023");
		mockedBooking.setMoviename("mocked Movie name");
		ArrayList<Booking> bookingList = new ArrayList<Booking>();
		bookingList.add(mockedBooking);
		when(bookingRepo.findAll()).thenReturn(bookingList);
		assertEquals(bookingServiceImpl.getAllBookingInformation(),bookingList);
	}

	@Test
	public void testBookTicket() {
		Theatre newTheatre = new Theatre();
		newTheatre.setDate("25/07/2023");
		newTheatre.setCost(200);
		newTheatre.setId(100);
		newTheatre.setMoviename("new movie");
		newTheatre.setSeatsavailable(100);
		newTheatre.setTime("10:00AM");
		List<Theatre> theatreList = new ArrayList<Theatre>();
		theatreList.add(newTheatre);
		when(theatreRepo.findAll()).thenReturn(theatreList);
		Booking booking = new Booking();
		booking.setDate("25/07/2023");
		booking.setTotalcost(400);
		booking.setSeats(2);
		booking.setId(2);
		booking.setMoviename("new movie");
		booking.setUserid(101);
		when(bookingRepo.save(any(Booking.class))).thenReturn(booking);
		Map<String,Object> ticket = new HashMap<String,Object>();
		ticket.put("date", "25/07/2023");
		ticket.put("moviename", "new movie");
		ticket.put("seats", "2");
		ticket.put("time", "10:00AM");
		assertEquals(bookingServiceImpl.bookTicket("101", ticket).getTotalCost(),400);
		
	}

}
