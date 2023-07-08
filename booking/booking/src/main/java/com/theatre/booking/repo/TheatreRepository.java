package com.theatre.booking.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.theatre.booking.model.Theatre;
 
public interface TheatreRepository extends JpaRepository<Theatre, Integer> {

}
