package com.cihatturhan.busseatreservation.com.main.service;

import com.cihatturhan.busseatreservation.com.main.model.User;

public interface UserService {

	public void saveOrUpdate(User user);
	
	public User getById(int id);
	
	public void deleteById(int id);
	
	
}
