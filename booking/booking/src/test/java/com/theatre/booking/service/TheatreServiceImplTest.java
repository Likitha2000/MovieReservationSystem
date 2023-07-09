package com.theatre.booking.service;


import static org.junit.Assert.assertEquals;
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

import com.theatre.booking.model.Theatre;
import com.theatre.booking.repo.BookingRepository;
import com.theatre.booking.repo.TheatreRepository;

@RunWith(MockitoJUnitRunner.class)
public class TheatreServiceImplTest {

	@InjectMocks
	TheatreServiceImpl theatreServiceImpl;
	
	@Mock
	BookingRepository bookingRepo;
	
	@Mock
	TheatreRepository theatreRepo;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetAllTheatreInformation() {
		Theatre newTheatre = new Theatre();
		newTheatre.setDate("25/07/2023");
		newTheatre.setCost(200);
		newTheatre.setId(100);
		newTheatre.setMoviename("new movie");
		List<Theatre> theatreList = new ArrayList<Theatre>();
		theatreList.add(newTheatre);
		when(theatreRepo.findAll()).thenReturn(theatreList);
		assertEquals(theatreServiceImpl.getAllTheatreInformation(),theatreList);
	}

	@Test
	public void testUpdateTheatreData() {
		Map<String,Object> theatre = new HashMap<String,Object>();
		theatre.put("date", "25/07/2023");
		theatre.put("moviename", "new movie");
		theatre.put("seatsavailable", "200");
		theatre.put("time", "10:00AM");
		theatre.put("cost","200");
		Theatre newTheatre = new Theatre();
		newTheatre.setDate("25/07/2023");
		newTheatre.setCost(200);
		newTheatre.setId(100);
		newTheatre.setMoviename("new movie");
		when(theatreRepo.save(any(Theatre.class))).thenReturn(newTheatre);
		assertEquals(theatreServiceImpl.updateTheatreData(theatre).getStatus(),"Success");
	}

}
