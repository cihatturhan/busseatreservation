package com.cihatturhan.busseatreservation.com.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cihatturhan.busseatreservation.com.main.model.Bus;

@Repository
public interface BusRepository extends JpaRepository<Bus,Integer> {

}
