package com.jforce.hotelbooking.cammand;

import java.sql.Date;

import lombok.Data;

@Data
public class SearchRoomCammand {
	private String roomType;
	private Date checkIn;
	private Date checkOut;
}
