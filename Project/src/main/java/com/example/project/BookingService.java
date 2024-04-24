package com.example.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
	@Autowired
	private BookingRepository repo;
	
	public List<Booking> listAll(){
		return repo.findAllByOrderByIdAsc();
	}
	
	public void save(Booking booking) {
		repo.save(booking);
	}
	
	public Booking get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
