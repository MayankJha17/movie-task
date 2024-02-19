package org.movie.serviceImpl;

import java.util.Iterator;

import org.movie.model.Seat;
import org.movie.service.InitService;
import org.movie.service.UserBookingService;

public class UserBookingImpl implements UserBookingService {

	@Override
	public Seat bookTicket(boolean[][] seatArrangement) {

		Seat seat = new Seat();
		for (int i = 0; i < seatArrangement.length; i++) {

			for (int j = 0; j < seatArrangement.length; j++) {

				if (seatArrangement[i][j] == false) {

					seatArrangement[i][j] = true;
					seat.setX(i);
					seat.setY(j);
					seat.setConfirmed(true);

					return seat;
				}
			}
		}

		seat.setConfirmed(false);
		return seat;
	}

	@Override
	public int NumberOfSeatsAvailableOnShow(String showTimimngs) {

		int count = 0;

		InitService initService = InitServiceFactory.getInstance();

		boolean[][] seatArranagement = initService.getSeatArrangement(showTimimngs);

		for (int i = 0; i < seatArranagement.length; i++) {

			for (int j = 0; j < seatArranagement.length; j++) {

				if (seatArranagement[i][j] == false) {

					count++;
				}
			}
		}
		return count;
	}

}
