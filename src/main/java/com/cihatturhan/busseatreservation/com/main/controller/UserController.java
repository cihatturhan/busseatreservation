package com.cihatturhan.busseatreservation.com.main.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cihatturhan.busseatreservation.com.main.model.User;
import com.cihatturhan.busseatreservation.com.main.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/addUser")
	public String AddUser(Model model) {
		User user = new User();
		model.addAttribute("user", user);

		return "user-form";

	}

	@GetMapping("/editUser/{userId}")
	public String editUser(@PathVariable int userId, Model model) {

		User user = userService.getById(userId);
		model.addAttribute("user", user);

		return "user-update-form";
	}

	@PostMapping("/processUserForm")
	public String saveNewUser(@Valid @ModelAttribute User user, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {

		if (bindingResult.hasErrors()) {
			return "user-form";
		}

		boolean redirectAttributesError = false;

		if (!user.getPassword().equals(user.getConfirmedPassword())) {

			redirectAttributes.addAttribute("differentPassword", "Passwords are different");
			redirectAttributesError = true;
		}

		if (userService.ExistsByUsername(user.getUsername())) {
			redirectAttributes.addAttribute("usernameExist", "Username has already been taken");
			redirectAttributesError = true;
		}

		if (redirectAttributesError) {
			return "redirect:/addUser";
		}

		userService.createNewAccount(user);

		return "redirect:/";
	}

	@PostMapping("/processUserUpdateForm")
	public String updateUser(@Valid @ModelAttribute User user, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {

		if (bindingResult.hasErrors()) {
			return "user-update-form";
		}
		boolean redirectAttributesError = false;

		if (!user.getPassword().equals(user.getConfirmedPassword())) {

			redirectAttributes.addAttribute("differentPassword", "Passwords are different");
			redirectAttributesError = true;
		}
		if (redirectAttributesError) {
			return "redirect:/editUser"+user.getId();
			}

		userService.saveOrUpdate(user);
		return "redirect:/";

	}

}
