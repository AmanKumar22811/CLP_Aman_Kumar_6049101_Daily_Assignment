package com.cg.entity;

import com.cg.enums.Genre;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "movie")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Movie Name is required !!")
	@Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Movie Name should be only alphanumeric")
	private String name;

	@NotNull(message = "Rating is required !!")
	@DecimalMin(value = "1.0", message = "Rating needs to be a number: eg 2.5. Rating is on Scale 1-5")
	@DecimalMax(value = "5.0", message = "Rating needs to be a number: eg 2.5. Rating is on Scale 1-5")
	private Double rating;

	@NotNull(message = "Select Genre!!!")
	@Enumerated(EnumType.STRING)
	private Genre genre;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}
}