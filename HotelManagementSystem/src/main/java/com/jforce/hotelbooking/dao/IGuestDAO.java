package com.jforce.hotelbooking.dao;

import com.jforce.hotelbooking.model.Guest;
import com.jforce.hotelbooking.model.Login;

public interface IGuestDAO {
	public int insertGuest(Guest guest);
	public int validateGuest(Login login);
}
