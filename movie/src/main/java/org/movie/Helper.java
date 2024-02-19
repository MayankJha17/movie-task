package org.movie;

public class Helper {

	public int getX(String seatNumber) {
		return Integer.valueOf(seatNumber.substring(1, 2));

	}

	public int getY(String seatNumber) {

		return Integer.valueOf(seatNumber.substring(3, 4));
	}

}
