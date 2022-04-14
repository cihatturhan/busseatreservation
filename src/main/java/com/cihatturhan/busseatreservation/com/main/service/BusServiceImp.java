package com.cihatturhan.busseatreservation.com.main.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cihatturhan.busseatreservation.com.main.model.Bus;
import com.cihatturhan.busseatreservation.com.main.repository.BusRepository;

@Service
@Transactional
public class BusServiceImp implements BusService {

	@Autowired
	BusRepository busRepository;

	@Override
	public void saveOrUpdate(Bus bus) {

		busRepository.save(bus);

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
