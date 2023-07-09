package com.theatre.booking.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.theatre.booking.model.Theatre;
import com.theatre.booking.model.TheatreResponse;
import com.theatre.booking.repo.BookingRepository;
import com.theatre.booking.repo.TheatreRepository;

@Service
public class TheatreServiceImpl implements TheatreService{

	@Autowired
	BookingRepository bookingRepo;
	
	@Autowired
	TheatreRepository theatreRepo;
	

	@Override
	public List<Theatre> getAllTheatreInformation() {
		// TODO Auto-generated method stub
			return theatreRepo.findAll();
	}

	@Override
	public TheatreResponse updateTheatreData(Map<String, Object> theatre) {
		// TODO Auto-generated method stub
		try {
		Theatre newTheatre = new Theatre();
		newTheatre.setMoviename((String) theatre.get("moviename"));
		newTheatre.setCost(Integer.valueOf((String) theatre.get("cost")));
		newTheatre.setDate((String) theatre.get("date"));
		newTheatre.setSeatsavailable(Integer.valueOf((String) theatre.get("seatsavailable")));
		newTheatre.setTime((String) theatre.get("time"));
		Theatre savedTheatre = theatreRepo.save(newTheatre);
		TheatreResponse theatreResponse = new TheatreResponse();
		theatreResponse.setTheatreId(savedTheatre.getId());
		theatreResponse.setStatus("Success");
		return theatreResponse;
		}
		catch(Exception e) {
			return null;
		}
	}

}
