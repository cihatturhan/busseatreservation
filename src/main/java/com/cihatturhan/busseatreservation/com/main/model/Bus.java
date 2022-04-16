package com.cihatturhan.busseatreservation.com.main.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;


@Entity
@Table(name="bus")
public class Bus {

	public Bus() {
		
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	@Size(min = 2, max = 30)
	private String name;
	
	@NotNull
	@Range(min=2, max=50)
	private int numberOfSeat;
	
	
	private boolean hasAnyReservation;

	
	
	@ManyToMany
	@JoinTable(name="bus2trip",
				joinColumns= @JoinColumn(name="bus_id"),
				inverseJoinColumns= @JoinColumn(name="trip_id"))
	private List<Trip> trips;
	
	@OneToMany(mappedBy = "bus", cascade = CascadeType.ALL)
	private List<Seat> seats;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	public int getNumberOfSeat() {
		return numberOfSeat;
	}

	public void setNumberOfSeat(int numberOfSeat) {
		this.numberOfSeat = numberOfSeat;
	}

	public boolean isHasAnyReservation() {
		return hasAnyReservation;
	}

	public void setHasAnyReservation(boolean hasAnyReservation) {
		this.hasAnyReservation = hasAnyReservation;
	}

	public List<Trip> getTrips() {
		return trips;
	}

	public void setTrips(List<Trip> trips) {
		this.trips = trips;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}
	
	


}
