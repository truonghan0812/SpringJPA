package com.truonghan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.truonghan.entities.Author;

public interface AuthorRepository extends JpaRepository<Author,Integer> {

	
}
