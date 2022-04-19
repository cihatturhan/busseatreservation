package com.cihatturhan.busseatreservation.com.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.cihatturhan.busseatreservation.com.main.enums.SeatStatus;


@Entity
@Table(name="seat")
public class Seat {
	

	

	public Seat() {
	
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	
	@NotNull
	private String seatNumber;
		
	@ManyToOne
	@JoinColumn(name="trip_id")
	private Trip trip;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	private SeatStatus seatStatus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public SeatStatus getSeatStatus() {
		return seatStatus;
	}

	public void setSeatStatus(SeatStatus seatStatus) {
		this.seatStatus = seatStatus;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}
	
	
	
	

}
