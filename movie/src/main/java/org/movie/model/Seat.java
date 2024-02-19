package org.movie.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Seat {
	
	private int x;
	private int y;
	private boolean isConfirmed=false;

}
