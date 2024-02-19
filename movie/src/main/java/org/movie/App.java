package org.movie;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.movie.model.Movie;
import org.movie.model.Seat;
import org.movie.service.CancelTicketService;
import org.movie.service.InitService;
import org.movie.service.UserBookingService;
import org.movie.serviceImpl.CancelTicketServiceImpl;
import org.movie.serviceImpl.InitServiceFactory;
import org.movie.serviceImpl.UserBookingImpl;

public class App {

	public static void main(String[] args) {

		System.out.println("Welcome to the ticket booking");

		InitService initService = InitServiceFactory.getInstance();
		boolean initResult = initService.initMovieData();

		if (!initResult) {
			System.err.println(" Err in loading movie data , re run the application");
			return;
		}

		try (BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in))) {

			while (true) {
				System.out.println("=======================================================");
				System.out.println("=======================================================");

				System.out.println("Press 1 for book tickets");

				System.out.println("Press 2 for cancel tickets");
				System.out.println("Press 3 for Exit");

				int input = Integer.parseInt(stdin.readLine());
				if (input == 1) {

					processBookTickets(initService, stdin);
				}

				else if (input == 2) {

					processCancelTickets(initService, stdin);
				} else if (input == 3) {
					break;
				}
			}
			System.out.println("System exit");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	private static void processBookTickets(InitService initService, BufferedReader scan) {

		try {

			List<Movie> movieList = initService.getMovieList();
			for (Movie movie : movieList) {

				System.out.println(movie.getName());
				System.out.println(movie.getGeneres());
				System.out.println("=======================================");
			}

			System.out.println("============== ENTER THE MOVIE NAME =========================");

			String movieName = scan.readLine();

			movieName = movieName.trim();

			if (initService.isMovieAvailable(movieName)) {

				Movie movie = initService.getMovieByName(movieName);

				for (String showTimings : initService.getMovieShowTimings(movieName)) {

					System.out.println("Show timings " + showTimings);

				}

				System.out.println("============== ENTER THE SHOW TIMINGS TO BE BOOKED FOR MOVIE "
						+ movieName.toUpperCase() + " =========================");

				String showTimeToBeBooked = scan.readLine();
				showTimeToBeBooked = showTimeToBeBooked.trim();
				System.out.println(" seat arrangement show timings " + showTimeToBeBooked);
				boolean[][] seatArranagement = initService.getSeatArrangement(showTimeToBeBooked);

				UserBookingService userBookingService = new UserBookingImpl();

				Seat seat = userBookingService.bookTicket(seatArranagement);

				if (seat.isConfirmed()) {

					System.out.println("Congralutions for seat is confirmed for movie " + movie.getName().toUpperCase()
							+ " genere " + movie.getGeneres());
					System.out.println(" Seat Number is H" + seat.getX() + "V" + seat.getY());
					System.out
							.println(" Seat Avalaiable for show " + movie.getName() + " show time " + showTimeToBeBooked
									+ " is " + userBookingService.NumberOfSeatsAvailableOnShow(showTimeToBeBooked));

				}

			} else {

				System.out.println(" You have entered wrong movie name");
				return;
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static void processCancelTickets(InitService initService, BufferedReader scan) {
		try {
			CancelTicketService cancelTicketService = new CancelTicketServiceImpl();
			Helper helper = new Helper();

			System.out.println("PLEASE ENTER THE MOVIE NAME WHICH YOU WANT TO CANCEL YPUR TICKET");

			String movieName = scan.readLine();

			System.out.println("PLEASE ENTER THE SHOW TIMINGS");

			String showTime = scan.readLine();

			System.out.println("ENTER THE SEAT NUMBER ");

			String seatNumber = scan.readLine();

			boolean isTicketCanceled = cancelTicketService.cancelTicket(helper.getX(seatNumber),
					helper.getY(seatNumber), showTime.trim(), movieName.trim());

			if (isTicketCanceled) {

				System.out.println("TICKET IS CANCELLED");
			} else {

				System.out.println("TICKET IS NOT CANCELLED");
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
