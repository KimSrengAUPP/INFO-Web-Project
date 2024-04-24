package com.example.project;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
	// orders by the id column
	List<Contact> findAllByOrderByIdAsc();
}
