package com.truonghan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.truonghan.entities.AbstractPost;

public interface AbstractRepository extends
		JpaRepository<AbstractPost, Integer> {

}
