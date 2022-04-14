package com.cihatturhan.busseatreservation.com.main.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cihatturhan.busseatreservation.com.main.model.User;
import com.cihatturhan.busseatreservation.com.main.repository.UserRepository;


@Service
@Transactional
public class UserServiceImp implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public void saveOrUpdate(User user) {
		userRepository.save(user);
		
	}

	@Override
	public User getById(int id) {
		
		return userRepository.getById(id);
	}

	@Override
	public void deleteById(int id) {
		userRepository.deleteById(id);
		
	}

}
