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
	public BookedResponse bookTicket(String userId, Map<String, Object> ticket) {
		BookedResponse bookingResponse = new BookedResponse();
		List<Theatre> availablities = theatreRepo.findAll(); 
		List<Theatre> matchedTheatre = availablities.stream()
		.filter(x -> x.getMoviename().equalsIgnoreCase((String) ticket.get("moviename")) 
				&& x.getSeatsavailable() >= Integer.valueOf((String)ticket.get("seats")) 
				&& x.getDate().equals(ticket.get("date"))
				&&  x.getTime().equals(ticket.get("time")))
		.collect(Collectors.toList());
		Booking newBooking = new Booking();
		newBooking.setMoviename((String) ticket.get("moviename"));
		newBooking.setSeats(Integer.valueOf((String)ticket.get("seats")));
		newBooking.setDate( (String) ticket.get("date"));
		newBooking.setTotalcost(Integer.valueOf((String)ticket.get("seats")) * matchedTheatre.get(0).getCost());
		newBooking.setUserid(Integer.valueOf(userId));
		Booking returnedBooking = bookingRepo.save(newBooking);
			if(returnedBooking!=null) {
				bookingResponse.setTotalCost(newBooking.getTotalcost());
				bookingResponse.setBookingId(returnedBooking.getId());
				return bookingResponse;
			}
			else {
				return null;
			}
			
	}

}
