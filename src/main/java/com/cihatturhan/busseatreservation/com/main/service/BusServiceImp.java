package com.cihatturhan.busseatreservation.com.main.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cihatturhan.busseatreservation.com.main.enums.SeatStatus;
import com.cihatturhan.busseatreservation.com.main.model.Bus;
import com.cihatturhan.busseatreservation.com.main.model.Seat;
import com.cihatturhan.busseatreservation.com.main.repository.BusRepository;
import com.cihatturhan.busseatreservation.com.main.repository.SeatRepository;

@Service
@Transactional
public class BusServiceImp implements BusService {

	@Autowired
	BusRepository busRepository;

	@Autowired
	SeatRepository seatRepository;

	@Override
	public void saveOrUpdate(Bus bus) {

		bus = busRepository.saveAndFlush(bus);

	}

	@Override
	public Bus getById(int id) {

		return busRepository.getById(id);// BusnotFound Exception will be added and findById will be used
	}

	@Override
	public void deleteById(int id) {

		busRepository.deleteById(id);

	}

	@Override
	public List<Bus> getAll() {

		return busRepository.findAll();
	}

}
