package com.cihatturhan.busseatreservation.com.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cihatturhan.busseatreservation.com.main.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
