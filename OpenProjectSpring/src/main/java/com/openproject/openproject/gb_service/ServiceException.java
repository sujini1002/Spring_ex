package com.openproject.openproject.gb_service;

import java.sql.SQLException;

public class ServiceException extends Exception {

	public ServiceException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public ServiceException(String arg0, SQLException e) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	
}
