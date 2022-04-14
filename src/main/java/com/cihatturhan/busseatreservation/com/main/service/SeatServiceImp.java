package com.cihatturhan.busseatreservation.com.main.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cihatturhan.busseatreservation.com.main.model.Seat;
import com.cihatturhan.busseatreservation.com.main.repository.SeatRepository;

@Service
@Transactional
public class SeatServiceImp implements SeatService {

	@Autowired
	SeatRepository seatRepository;

	@Override
	public void saveOrUpdate(Seat seat) {
		seatRepository.save(seat);

	}

	@Override
	public Seat getById(int id) {

		return seatRepository.getById(id);
	}

	@Override
	public void deleteById(int id) {
		seatRepository.deleteById(id);

	}

}
