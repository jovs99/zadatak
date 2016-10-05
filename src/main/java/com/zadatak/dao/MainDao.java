package com.zadatak.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.zadatak.model.Sequence;


public interface MainDao {
	
	public boolean isValidUser(String username, String password) throws SQLException;

}
