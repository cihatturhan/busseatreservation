package com.cihatturhan.busseatreservation.com.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cihatturhan.busseatreservation.com.main.model.Seat;
@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer> {

}
