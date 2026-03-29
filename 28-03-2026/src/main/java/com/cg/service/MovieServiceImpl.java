package com.cg.service;

import com.cg.entity.Movie;
import com.cg.enums.Genre;
import com.cg.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository repo;

	@Override
	public Movie addMovie(Movie movie) {
		return repo.save(movie);
	}

	@Override
	public void deleteMovie(Long id) {
		repo.deleteById(id);
	}

	@Override
	public List<Movie> getAllMovies() {
		return repo.findAll();
	}

	@Override
	public Movie getMovieById(Long id) {
		return repo.findById(id).orElseThrow(() -> new RuntimeException("Movie not found"));
	}

	@Override
	public List<Movie> getMoviesByGenre(Genre genre) {
		return repo.findByGenre(genre);
	}

	@Override
	public Movie updateMovie(Long id, Movie movie) {
		Movie existing = repo.findById(id).orElseThrow();

		existing.setName(movie.getName());
		existing.setGenre(movie.getGenre());
		existing.setRating(movie.getRating());

		return repo.save(existing);
	}
}
