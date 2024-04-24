package com.example.project;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
	// orders by the id column
	List<Booking> findAllByOrderByIdAsc();
}
