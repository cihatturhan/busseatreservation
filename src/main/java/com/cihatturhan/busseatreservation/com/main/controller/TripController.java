package com.cihatturhan.busseatreservation.com.main.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cihatturhan.busseatreservation.com.main.model.Bus;
import com.cihatturhan.busseatreservation.com.main.model.Trip;
import com.cihatturhan.busseatreservation.com.main.service.BusService;
import com.cihatturhan.busseatreservation.com.main.service.TripService;


@Controller
public class TripController {

	@Autowired
	TripService tripService;
	
	@Autowired
	BusService busService;
	
	@GetMapping("/addTrip")
	public String showTripFrom(Model model) {
		model.addAttribute("trip", new Trip());
		return "trip-form";
	}
	
	@PostMapping("/processTripForm")
	public String saveOrUpdate(@Valid @ModelAttribute Trip trip, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			System.out.println(bindingResult.toString());
			return "trip-form";
		}
		tripService.saveOrUpdate(trip);
		
		return "redirect:/";
	}
	
	@GetMapping("/showTrips")
	public String showTrips(Model model) {
		List<Trip> trips = tripService.getAll();
		model.addAttribute("trips",trips);
		return "trips";
	}
	@GetMapping("/addTripToBusses/{tripId}")
	public String showAddTrpiToBusses(@PathVariable int tripId, Model model ) {
		
		Trip trip = tripService.getById(tripId);
		List<Bus> busses = busService.getAll();
		model.addAttribute("trip",trip);
		model.addAttribute("busses", busses);
		
		return "trips-to-bus-form";
	}

	@PostMapping("/processTripToBuesFrom/{tripId}")
	public String addBusToTrip(@PathVariable int tripId, @RequestParam(name="bus") int busId ) {
		System.out.println("trip id+ " + tripId);
		System.out.println("bus id: " + busId);
		Trip trip=tripService.getById(tripId);
		Bus bus= busService.getById(busId);
		trip.setBus(bus);
		tripService.saveOrUpdate(trip);
		return "redirect:/";

	}
}
