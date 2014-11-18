package com.truonghan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.truonghan.entities.PostPart;

public interface PostPartRepository extends	JpaRepository<PostPart,Integer> {
	
}
