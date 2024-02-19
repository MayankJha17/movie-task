package org.movie.service;

import org.movie.model.Seat;

public interface UserBookingService {

	Seat bookTicket(boolean[][] seatArrangement);

	int NumberOfSeatsAvailableOnShow(String showTimimngs);

}
