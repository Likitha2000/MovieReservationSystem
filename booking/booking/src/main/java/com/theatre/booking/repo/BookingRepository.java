package com.theatre.booking.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.theatre.booking.model.Booking;

public interface BookingRepository extends JpaRepository<Booking,Integer>{

}
