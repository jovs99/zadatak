package com.zadatak.service.impl;

import java.sql.SQLException;
import com.zadatak.dao.MainDao;
import com.zadatak.service.UserService;

public class UserServiceImpl implements UserService{

	MainDao mainDao;



	public MainDao getMainDao() {
		return mainDao;
	}



	public void setMainDao(MainDao mainDao) {
		this.mainDao = mainDao;
	}



	@Override
	public boolean isValidUser(String username, String password) throws SQLException{
		return mainDao.isValidUser(username, password);
	}

}

