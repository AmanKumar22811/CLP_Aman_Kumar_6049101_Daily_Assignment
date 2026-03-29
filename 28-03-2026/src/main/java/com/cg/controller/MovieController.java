package com.cg.controller;

import com.cg.entity.Movie;
import com.cg.enums.Genre;
import com.cg.service.MovieService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MovieController {

	@Autowired
	private MovieService service;

	// HOME "/"
	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		return mv;
	}

	// ADD MOVIE PAGE "/addMovie"
	@GetMapping("/addMovie")
	public ModelAndView showAddForm() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("movie", new Movie());
		mv.addObject("genres", Genre.values());
		mv.setViewName("add-movie");
		return mv;
	}

	// SAVE MOVIE
	@PostMapping("/saveMovie")
	public ModelAndView saveMovie(@Valid @ModelAttribute("movie") Movie movie, BindingResult result) {

		ModelAndView mv = new ModelAndView();

		if (result.hasErrors()) {
			mv.addObject("genres", Genre.values());
			mv.setViewName("add-movie");
			return mv;
		}

		service.addMovie(movie);
		mv.setViewName("redirect:/");
		return mv;
	}

	// SEARCH PAGE "/searchMovie"
	@GetMapping("/searchMovie")
	public ModelAndView searchPage() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("genres", Genre.values());
		mv.setViewName("search-movie");
		return mv;
	}

	// SEARCH RESULT
	@PostMapping("/searchMovie")
	public ModelAndView searchMovies(@RequestParam(value = "genre", required = false) String genre) {

		ModelAndView mv = new ModelAndView();

		if (genre == null || genre.isEmpty()) {
			mv.addObject("error", "Please select Genre!!!");
			mv.addObject("genres", Genre.values());
			mv.setViewName("search-movie");
			return mv;
		}

		Genre selectedGenre = Genre.valueOf(genre);

		List<Movie> movies = service.getMoviesByGenre(selectedGenre);

		mv.addObject("movies", movies);
		mv.addObject("genres", Genre.values());
		mv.setViewName("search-movie");

		return mv;
	}

	// DELETE MOVIE
	@GetMapping("/deleteMovie/{id}")
	public ModelAndView deleteMovie(@PathVariable Long id) {
		service.deleteMovie(id);
		return new ModelAndView("redirect:/searchMovie");
	}

	// SHOW UPDATE FORM
	@GetMapping("/editMovie/{id}")
	public ModelAndView showEditForm(@PathVariable Long id) {

		Movie movie = service.getMovieById(id);

		ModelAndView mv = new ModelAndView();
		mv.addObject("movie", movie);
		mv.addObject("genres", Genre.values());
		mv.setViewName("edit-movie");

		return mv;
	}

	// UPDATE MOVIE
	@PostMapping("/updateMovie/{id}")
	public ModelAndView updateMovie(@PathVariable Long id, @Valid @ModelAttribute("movie") Movie movie,
			BindingResult result) {

		ModelAndView mv = new ModelAndView();

		if (result.hasErrors()) {
			mv.addObject("genres", Genre.values());
			mv.setViewName("edit-movie");
			return mv;
		}

		service.updateMovie(id, movie);
		mv.setViewName("redirect:/searchMovie");

		return mv;
	}
}