package com.truonghan.repositories;

import java.util.List;

import org.omg.CosNaming.IstringHelper;
import org.springframework.data.jpa.repository.JpaRepository;

import com.truonghan.entities.Post;

public interface PostRepository extends JpaRepository<Post, java.lang.Integer> {
	
	//public  List<Post> findByTitleContaining (String title);

}
