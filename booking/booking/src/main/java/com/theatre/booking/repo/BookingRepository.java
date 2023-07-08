package com.theatre.booking.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.theatre.booking.model.Booking;

public interface BookingRepository extends JpaRepository<Booking,Long>{

}
