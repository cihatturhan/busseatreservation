package com.cihatturhan.busseatreservation.com.main.service;

import java.util.List;

import com.cihatturhan.busseatreservation.com.main.model.Bus;

public interface BusService {
	
	public void saveOrUpdate(Bus bus);
	
	public Bus getById(int id);
	
	public void deleteById(int id);
	
	public List<Bus> getAll();

}
