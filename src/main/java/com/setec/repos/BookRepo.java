package com.setec.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.setec.entities.Booked;

public interface BookRepo extends JpaRepository<Booked, Integer>{

	
}
