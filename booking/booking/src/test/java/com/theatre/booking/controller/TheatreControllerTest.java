package com.theatre.booking.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.*;

import com.theatre.booking.model.Theatre;
import com.theatre.booking.model.TheatreResponse;
import com.theatre.booking.service.TheatreService;

@RunWith(MockitoJUnitRunner.class)
public class TheatreControllerTest {
	
	@InjectMocks
	TheatreController theatreController;
	
	@Mock
	TheatreService theatreService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetTheatreInformation() {
		Theatre newTheatre = new Theatre();
		newTheatre.setDate("25/07/2023");
		newTheatre.setCost(200);
		newTheatre.setId(100);
		newTheatre.setMoviename("new movie");
		List<Theatre> theatreList = new ArrayList<Theatre>();
		theatreList.add(newTheatre);
		when(theatreService.getAllTheatreInformation()).thenReturn(theatreList);
		ResponseEntity<List<Theatre>> responseData = theatreController.getTheatreInformation();
		assertEquals(HttpStatus.OK,responseData.getStatusCode());
		assertEquals(newTheatre,responseData.getBody().get(0));
	}

	
	@Test
	public void testGetTheatreInformationErrorResponse() {
		when(theatreService.getAllTheatreInformation()).thenThrow(NullPointerException.class);
		ResponseEntity<List<Theatre>> responseData = theatreController.getTheatreInformation();
		assertEquals(null,responseData);
	}
	
	@Test
	public void testUpdateTheatreInfoErrorResponse() {
		Map<String,Object> theatre = new HashMap<String,Object>();
		when(theatreService.updateTheatreData(theatre)).thenThrow(NullPointerException.class);
		ResponseEntity<TheatreResponse> responseData = theatreController.updateTheatreInfo(theatre);
		assertEquals(null,responseData);
	}
	
	@Test
	public void testUpdateTheatreInfo() {
		Map<String,Object> theatre = new HashMap<String,Object>();
		theatre.put("seatsavailable", 200);
		theatre.put("date","20/09/2023");
		theatre.put("time","10:00PM");
		TheatreResponse response = new TheatreResponse();
		response.setStatus("Successfull");
		response.setTheatreId(100);
		when(theatreService.updateTheatreData(theatre)).thenReturn(response);
		ResponseEntity<TheatreResponse> responseData = theatreController.updateTheatreInfo(theatre);
		assertEquals(HttpStatus.OK,responseData.getStatusCode());
		assertEquals(responseData.getBody().getTheatreId(),response.getTheatreId());
	}


}
