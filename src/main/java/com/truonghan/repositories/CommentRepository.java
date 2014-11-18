package com.truonghan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.truonghan.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
