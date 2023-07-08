package com.theatre.booking.service;

import java.util.List;
import java.util.Map;

import com.theatre.booking.model.Theatre;
import com.theatre.booking.model.TheatreResponse;

public interface TheatreService {

	List<Theatre> getAllTheatreInformation();

	TheatreResponse updateTheatreData(Map<String, Object> theatre);
	
}
