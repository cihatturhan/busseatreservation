package com.cihatturhan.busseatreservation.com.main.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cihatturhan.busseatreservation.com.main.model.Bus;
import com.cihatturhan.busseatreservation.com.main.service.BusService;

@Controller
public class BusController {
	
	@Autowired
	BusService busService;
	
	@GetMapping("/addBus")
	public String showBusForm(Model model){
		model.addAttribute("bus", new Bus());
		
		return "bus-form";
		
	}
	
	@PostMapping("/processBusForm")
	public String saveOrUpdateBus(@Valid @ModelAttribute Bus bus, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "bus-form";
		}
		busService.saveOrUpdate(bus);
		return "redirect:/";
	}
	

}
