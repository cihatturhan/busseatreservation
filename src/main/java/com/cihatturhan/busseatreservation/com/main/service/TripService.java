package com.cihatturhan.busseatreservation.com.main.service;

import java.util.List;

import com.cihatturhan.busseatreservation.com.main.model.Trip;

public interface TripService {

	public void saveOrUpdate(Trip trip);

	public Trip getById(int id);

	public void deleteById(int id);

	public List<Trip> getAll();

}
