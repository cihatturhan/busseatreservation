package com.cihatturhan.busseatreservation.com.main.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cihatturhan.busseatreservation.com.main.model.Trip;
import com.cihatturhan.busseatreservation.com.main.repository.TripRepository;

@Service
@Transactional
public class TripServiceImp implements TripService {

	@Autowired
	TripRepository tripRespository;

	@Override
	public void saveOrUpdate(Trip trip) {
		tripRespository.save(trip);

	}

	@Override
	public Trip getById(int id) {

		return tripRespository.getById(id);
	}

	@Override
	public void deleteById(int id) {
		tripRespository.deleteById(id);

	}

	@Override
	public List<Trip> getAll() {

		return tripRespository.findAll();
	}

}
