package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import com.cg.entity.Movie;
import com.cg.repository.MovieRepository;

@Controller
@RequestMapping("/movies")
public class MovieController {

	@Autowired
	private MovieRepository movieRepository;

	// Home Page
	@GetMapping("/home")
	public ModelAndView greet() {
		ModelAndView mv = new ModelAndView("welcome");
		mv.addObject("modelName", "Movie App");
		return mv;
	}

	// Get All Movies
	@GetMapping
	public ModelAndView getAllMovies() {
		List<Movie> movieList = movieRepository.findAll();
		ModelAndView mv = new ModelAndView("view-movies");
		mv.addObject("listOfMovies", movieList);
		return mv;
	}

	// Open Add Movie Page
	@GetMapping("/addMovie")
	public ModelAndView showAddMoviePage() {
		ModelAndView mv = new ModelAndView("add-movie");
		mv.addObject("movie", new Movie());
		return mv;
	}

	// Save Movie
	@PostMapping("/saveMovie")
	public ModelAndView saveMovie(@ModelAttribute Movie movie) {
		movieRepository.save(movie);
		return new ModelAndView("redirect:/movies");
	}

	// Delete Movie
	@GetMapping("/deleteMovie")
	public ModelAndView deleteMovie(@RequestParam("id") Long id) {
		movieRepository.deleteById(id);
		return new ModelAndView("redirect:/movies");
	}

	// Search Movie by Genre
	@GetMapping("/searchByGenre")
	public ModelAndView searchByGenre(@RequestParam("genre") String genre) {
		List<Movie> movieList = movieRepository.findByGenre(genre);
		ModelAndView mv = new ModelAndView("movies");
		mv.addObject("listOfMovies", movieList);
		return mv;
	}

	// Open Update Page
	@GetMapping("/editMovie")
	public ModelAndView editMovie(@RequestParam("id") Long id) {
		Movie movie = movieRepository.findById(id).orElse(null);
		ModelAndView mv = new ModelAndView("update-movie");
		mv.addObject("movie", movie);
		return mv;
	}

	// Update Movie
	@PostMapping("/updateMovie")
	public ModelAndView updateMovie(@ModelAttribute Movie movie) {
		movieRepository.save(movie);
		return new ModelAndView("redirect:/movies");
	}
}