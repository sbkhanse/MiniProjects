package com.jforce.hotelbooking.cammand;

import java.sql.Date;

import lombok.Data;

@Data
public class BookCammand {
	private int roomId;
	private String roomType;
	private String status;
	private Date startDate;
	private Date endDate;
}
