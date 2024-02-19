package org.movie.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.movie.model.Movie;
import org.movie.service.InitService;

public class InitServiceImpl implements InitService {

	List<Movie> movieList = new ArrayList<>();
	Map<String, List<String>> showTimings = new HashMap<String, List<String>>(); // Movie to show timings

	Map<String, boolean[][]> showSeatArrangement = new HashMap<String, boolean[][]>(); // show by seat arrangemant

	public InitServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean initMovieData() {

		try {

			Movie movie1 = new Movie();
			movie1.setName("Inception");
			movie1.setGeneres("Sci-Fi, Action");
			List<String> showTimingMovie1 = new ArrayList<>();
			showTimingMovie1.add("10:00 AM");
			showTimingMovie1.add("12:00 PM");
			showTimings.put(movie1.getName(), showTimingMovie1);
			showSeatArrangement.put("10:00 AM", new boolean[5][5]);
			showSeatArrangement.put("12:00 PM", new boolean[5][5]);

			// Movie 2
			Movie movie2 = new Movie();
			movie2.setName("The Shawshank Redemption");
			movie2.setGeneres("Drama");
			List<String> showTimingMovie2 = new ArrayList<>();
			showTimingMovie2.add("2:00 PM");
			showTimingMovie2.add("4:00 PM");
			showTimings.put(movie2.getName(), showTimingMovie2);
			showSeatArrangement.put("2:00 PM", new boolean[5][5]);
			showSeatArrangement.put("4:00 PM", new boolean[5][5]);

			// Movie 3

			Movie movie3 = new Movie();
			movie3.setName("The Dark Knight");
			movie3.setGeneres("Action, Crime");
			List<String> showTimingMovie3 = new ArrayList<>();

			showTimingMovie3.add("6:00 PM");
			showTimingMovie3.add("8:00 PM");
			showTimings.put(movie3.getName(), showTimingMovie3);
			showSeatArrangement.put("6:00 PM", new boolean[5][5]);
			showSeatArrangement.put("8:00 PM", new boolean[5][5]);

			// Movie 4
			Movie movie4 = new Movie();
			movie4.setName("Pulp Fiction");
			movie4.setGeneres("Crime, Drama");
			List<String> showTimingMovie4 = new ArrayList<>();

			showTimingMovie4.add("10:00 PM");
			showTimingMovie4.add("12:00 AM");
			showTimings.put(movie4.getName(), showTimingMovie4);
			showSeatArrangement.put("10:00 PM", new boolean[5][5]);
			showSeatArrangement.put("12:00 AM", new boolean[5][5]);

			// Add movies to the list
			movieList.add(movie1);
			movieList.add(movie2);
			movieList.add(movie3);
			movieList.add(movie4);
			System.out.println(" seat 10 am " + showSeatArrangement.get("10:00 AM").length);
			return true;

		} catch (Exception e) {

			System.err.println("Exception in loading movie data " + e.getMessage());
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public List<Movie> getMovieList() {
		return movieList;
	}

	@Override
	public List<String> getMovieShowTimings(String movieName) {

		return showTimings.get(movieName);
	}

	@Override
	public boolean[][] getSeatArrangement(String showTimings) {
		return showSeatArrangement.get(showTimings);
	}

	@Override
	public boolean isMovieAvailable(String movieName) {

		boolean isMovieAvailable = false;
		for (Movie movie : movieList) {
			if (movieName.equalsIgnoreCase(movie.getName())) {

				isMovieAvailable = true;
			}

		}

		return isMovieAvailable;
	}

	@Override
	public Movie getMovieByName(String movieName) {

		for (Movie movie : movieList) {

			if (movieName.equalsIgnoreCase(movie.getName())) {

				return movie;
			}
		}

		return null;
	}

}
