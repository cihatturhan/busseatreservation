package com.cihatturhan.busseatreservation.com.main.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.cihatturhan.busseatreservation.com.main.enums.City;

@Entity
@Table(name = "trip")
public class Trip {

	public Trip() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	@Size(min = 2, max = 30)
	private String name;

	@NotNull
	@Pattern(regexp = "^([A-Z]){2}-([A-Z]){2}", message = "Excepted format is LL-LL where L stands for Lethers")
	private String code;

	@NotNull
	private City departureCity;

	@NotNull
	private City arrivalCity;

	@Future
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "departure_date")
	private Date departureDate;

	@Column(name = "departure_time")
	private String departureTime;// input type time olarak frontendden alacağız

	@Future
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "arrival_date")
	private Date arrivalDate;

	@Column(name = "arrival_time")
	private String arrivalTime;

	@ManyToOne
	@JoinColumn(name = "bus_id")
	private Bus bus;;

	@OneToMany(mappedBy = "trip", cascade = CascadeType.ALL)
	private List<Seat> seats;
	
	private boolean hasAnyReservation;

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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public City getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(City departureCity) {
		this.departureCity = departureCity;
	}

	public City getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(City arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	public boolean isHasAnyReservation() {
		return hasAnyReservation;
	}

	public void setHasAnyReservation(boolean hasAnyReservation) {
		this.hasAnyReservation = hasAnyReservation;
	}
	
	

}
