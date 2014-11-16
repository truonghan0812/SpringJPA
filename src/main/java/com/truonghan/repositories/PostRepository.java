package com.truonghan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.truonghan.entities.Post;

public interface PostRepository extends JpaRepository<Post, java.lang.Integer> {

}
