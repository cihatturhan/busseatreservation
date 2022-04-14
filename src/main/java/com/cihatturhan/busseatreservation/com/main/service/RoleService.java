package com.cihatturhan.busseatreservation.com.main.service;

import com.cihatturhan.busseatreservation.com.main.model.Role;

public interface RoleService {

	public void seveOrUpdate(Role role);

	public Role getById(int id);
	
	public void deleteById(int id);
}
