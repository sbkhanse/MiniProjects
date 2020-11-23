package com.jforce.hotelbooking.model;

import java.sql.Date;

import lombok.Data;

@Data
public class Book {
	private int roomId;
	private String roomType;
	private String status;
	private Date startDate;
	private Date endDate;
}
