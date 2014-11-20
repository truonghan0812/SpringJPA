package com.truonghan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.truonghan.entities.Tag;

public interface TagRepository extends JpaRepository<Tag, Integer> {

}
