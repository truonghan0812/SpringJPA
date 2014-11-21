package com.truonghan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.truonghan.entities.ContentPost;

public interface ContentRepository extends JpaRepository<ContentPost, Integer> {

}
