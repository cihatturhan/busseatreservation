package com.cihatturhan.busseatreservation.com.main.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Service;

import com.cihatturhan.busseatreservation.com.main.model.Role;
import com.cihatturhan.busseatreservation.com.main.model.User;
import com.cihatturhan.busseatreservation.com.main.repository.RoleRepository;
import com.cihatturhan.busseatreservation.com.main.repository.UserRepository;

@Service
@Transactional
public class UserServiceImp implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;

	@Override
	public void saveOrUpdate(User user) {
		user.setPassword(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(user.getPassword()));
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



	@Override
	public boolean ExistsByUsername(String username) {
		return userRepository.existsByUsername(username);
	}

	@Override
	public void createNewAccount(User user) {
		user.setEnabled(true);
		user.setPassword(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(user.getPassword()));
		userRepository.save(user);
		
		Role role= new Role();
		role.setRole("ROLE_CLIENT");
		role.setUsername(user.getUsername());
		roleRepository.save(role);
		
	}

}
