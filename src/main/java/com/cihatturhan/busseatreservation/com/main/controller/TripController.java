package com.cihatturhan.busseatreservation.com.main.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cihatturhan.busseatreservation.com.main.model.Trip;
import com.cihatturhan.busseatreservation.com.main.service.TripService;


@Controller
public class TripController {

	@Autowired
	TripService tripService;
	
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
}
