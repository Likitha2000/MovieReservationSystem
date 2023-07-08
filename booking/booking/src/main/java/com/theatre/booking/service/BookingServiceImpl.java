package com.theatre.booking.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theatre.booking.model.Booking;
import com.theatre.booking.model.Theatre;
import com.theatre.booking.model.BookedResponse;
import com.theatre.booking.repo.BookingRepository;
import com.theatre.booking.repo.TheatreRepository;

@Service
public class BookingServiceImpl implements BookingService{

	@Autowired
	BookingRepository bookingRepo;
	
	@Autowired
	TheatreRepository theatreRepo;
	
	
	@Override
	public List<Booking> getAllBookingInformation() {
		// TODO Auto-generated method stub
		return bookingRepo.findAll();
	}

	@Override
	public BookedResponse bookTicket(Map<String, Object> ticket) {
		BookedResponse bookingResponse = new BookedResponse();
		List<Theatre> availablities = theatreRepo.findAll(); 
		List<Theatre> matchedTheatre = availablities.stream()
		.filter(x -> x.getMoviename().equalsIgnoreCase((String) ticket.get("moviename")) && x.getSeatsavailable() >= (int)ticket.get("seats") && x.getDate().equals(ticket.get("date")) &&  x.getTime().equals(ticket.get("time")))
		.collect(Collectors.toList());
		Booking newBooking = new Booking();
		newBooking.setMoviename((String) ticket.get("moviename"));
		newBooking.setSeats((int) ticket.get("seats"));
		newBooking.setDate( (String) ticket.get("date"));
		newBooking.setTotalcost((int) ticket.get("seats") * matchedTheatre.get(0).getCost());
			if(bookingRepo.save(newBooking).getClass() == Booking.class) {
				bookingResponse.setTotalCost(newBooking.getTotalcost());
				bookingResponse.setBookingId(1);
				return bookingResponse;
			}
			else {
				return null;
			}
			
	}

}
