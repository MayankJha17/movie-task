package org.movie.serviceImpl;

import org.movie.service.CancelTicketService;
import org.movie.service.InitService;

public class CancelTicketServiceImpl implements CancelTicketService {

	@Override
	public boolean cancelTicket(int x, int y, String showTimings, String movieName) {
		boolean isTicketCancelled = false;
		InitService initService = InitServiceFactory.getInstance();

		if (initService.isMovieAvailable(movieName)) {
			boolean[][] seatArrangement = initService.getSeatArrangement(showTimings);
			System.out.println(" seat " + seatArrangement[x][y]);
			if (seatArrangement[x][y] == true) {
				seatArrangement[x][y] = false;
				isTicketCancelled = true;

			}
		}

		return isTicketCancelled;

	}

}
