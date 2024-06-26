package com.example.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
	@Autowired
	private ContactRepository repo;
	
	public List<Contact> listAll() {		
		return repo.findAllByOrderByIdAsc();
	}
	
	public void save(Contact contact) {
		repo.save(contact);
	}
	
	public Contact get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
