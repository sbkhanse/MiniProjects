package com.jforce.hotelbooking.service;

import java.util.List;

import com.jforce.hotelbooking.dto.BookDTO;
import com.jforce.hotelbooking.dto.GuestDTO;
import com.jforce.hotelbooking.dto.LoginDTO;
import com.jforce.hotelbooking.dto.RoomDTO;
import com.jforce.hotelbooking.model.Search;

public interface IGuestMgmtService {
	public String registerGuest(GuestDTO dto);
	public String verifyGuest(LoginDTO dto);
	public List<RoomDTO> getAvaliableRooms(Search search);
	public String processRoomBoking(BookDTO bkDTO);
}
