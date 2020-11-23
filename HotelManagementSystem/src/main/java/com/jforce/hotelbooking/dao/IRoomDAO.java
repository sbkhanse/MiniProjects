package com.jforce.hotelbooking.dao;

import java.util.List;

import com.jforce.hotelbooking.model.Book;
import com.jforce.hotelbooking.model.Room;
import com.jforce.hotelbooking.model.Search;

public interface IRoomDAO {
	public List<Room> searchRoom(Search search);
	public int updateBooking(Book book);
}
