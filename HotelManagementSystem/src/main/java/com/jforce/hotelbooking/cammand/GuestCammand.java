package com.jforce.hotelbooking.cammand;

import lombok.Data;

@Data
public class GuestCammand {
	private String gstName;
	private String email;
	private long mobile;
	private String username;
	private String password;
	private String confirmPassword;
	private String vflag;
}
