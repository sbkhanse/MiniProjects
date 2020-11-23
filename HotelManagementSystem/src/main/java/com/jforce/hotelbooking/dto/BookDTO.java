package com.jforce.hotelbooking.dto;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;

@Data
public class BookDTO implements Serializable {
	private int roomId;
	private String roomType;
	private String status;
	private Date startDate;
	private Date endDate;
}
