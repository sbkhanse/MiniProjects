package com.jforce.hotelbooking.model;

import java.sql.Date;

import lombok.Data;

@Data
public class Search {
	private String roomType;
	private Date checkIn;
	private Date checkOut;
}
