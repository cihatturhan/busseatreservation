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
	
	@GetMapping("/showBuses")
	public String showBuses(Model model) {
		List<Bus> buses= busService.getAll();
		model.addAttribute("buses",buses);
		return "buses";
	}
	
	
	@GetMapping("/editBus/{busId}")
	public String editBus(@PathVariable int busId, Model model) {
		Bus bus =busService.getById(busId);
		model.addAttribute("bus", bus);
		return "bus-edit-form";
		
		
	}
	
}
