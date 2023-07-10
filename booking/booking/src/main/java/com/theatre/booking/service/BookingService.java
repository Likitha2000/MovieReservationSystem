package com.theatre.booking.service;

import java.util.List;
import java.util.Map;

import com.theatre.booking.model.BookedResponse;
import com.theatre.booking.model.Booking;

public interface BookingService {
	
	List<Booking> getAllBookingInformation();

	BookedResponse bookTicket(String userId, Map<String, Object> ticket);
}
