package com.jforce.hotelbooking.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@Table
public class Guest {
	private String gstName;
	private String email;
	private long mobile;
	private String username;
	private String password;
}
