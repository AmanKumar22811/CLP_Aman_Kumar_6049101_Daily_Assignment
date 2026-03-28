package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.entity.Movie;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

	List<Movie> findByGenre(String genre);
}
