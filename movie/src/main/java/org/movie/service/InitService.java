package org.movie.service;

import java.util.List;

import org.movie.model.Movie;

public interface InitService {

	boolean initMovieData();

	List<String> getMovieShowTimings(String movieName);

	List<Movie> getMovieList();

	boolean[][] getSeatArrangement(String showTimings);

	boolean isMovieAvailable(String movieName);

	Movie getMovieByName(String movieName);
}
