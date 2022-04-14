package com.cihatturhan.busseatreservation.com.main.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cihatturhan.busseatreservation.com.main.model.Role;
import com.cihatturhan.busseatreservation.com.main.repository.RoleRepository;


@Service
@Transactional
public class RoleServiceImp implements RoleService{

	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public void seveOrUpdate(Role role) {
		roleRepository.save(role);
		
	}

	@Override
	public Role getById(int id) {
		return roleRepository.getById(id);
	}

	@Override
	public void deleteById(int id) {
		roleRepository.deleteById(id);
		
	}

}
