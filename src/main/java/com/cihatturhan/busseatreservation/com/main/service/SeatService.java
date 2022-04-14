package com.cihatturhan.busseatreservation.com.main.service;

import com.cihatturhan.busseatreservation.com.main.model.Seat;

public interface SeatService {
	
	public void saveOrUpdate(Seat seat);
	
	public Seat getById(int id);
	
	public void deleteById(int id);

}
