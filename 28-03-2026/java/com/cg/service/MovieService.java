package com.cg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Movie;
import com.cg.repository.MovieRepository;

import java.util.List;

@Service
public class MovieService {

	@Autowired
	private MovieRepository repo;

	public Movie addMovie(Movie movie) {
		return repo.save(movie);
	}

	public List<Movie> getAllMovies() {
		return repo.findAll();
	}

	public List<Movie> getMoviesByGenre(String genre) {
		return repo.findByGenre(genre);
	}

	public void deleteMovie(Long id) {
		repo.deleteById(id);
	}

	public Movie updateMovie(Long id, Movie updated) {
		Movie movie = repo.findById(id).orElseThrow();
		movie.setTitle(updated.getTitle());
		movie.setGenre(updated.getGenre());
		movie.setDirector(updated.getDirector());
		movie.setYear(updated.getYear());
		return repo.save(movie);
	}

	public Movie getMovieById(Long id) {
		return repo.findById(id).orElseThrow();
	}
}
