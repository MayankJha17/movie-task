package org.movie.serviceImpl;

import org.movie.service.InitService;

public final class InitServiceFactory {

	private static InitServiceImpl instance = null;

	public static InitService getInstance() {

		if (instance == null) {
             
			 instance = new InitServiceImpl();
			 return instance;
		}

		return instance;
	}

}
