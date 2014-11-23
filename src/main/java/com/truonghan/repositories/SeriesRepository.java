package com.truonghan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.truonghan.entities.Series;

public interface SeriesRepository extends JpaRepository<Series,Integer> {

}
