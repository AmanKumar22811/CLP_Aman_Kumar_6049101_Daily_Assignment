package com.cg.service;

import com.cg.entity.Movie;
import com.cg.enums.Genre;

import java.util.List;

public interface MovieService {

	Movie addMovie(Movie movie);

	void deleteMovie(Long id);
	
	Movie getMovieById(Long id);

	List<Movie> getAllMovies();

	List<Movie> getMoviesByGenre(Genre genre);

	Movie updateMovie(Long id, Movie movie);
}