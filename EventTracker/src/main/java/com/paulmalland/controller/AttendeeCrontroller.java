package com.paulmalland.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.paulmalland.model.Attendee;

@Controller
public class AttendeeCrontroller {

	@RequestMapping(value = "/attendee", method = RequestMethod.GET)
	public String displayAttendeePage(Model model) {
		Attendee attendee = new Attendee();
		model.addAttribute("attendee", attendee);
		
		return "attendee";
		
	}
	
	/**
	 * There is a design pattern called POST redirect GET, it says, once somebody POSTed to our page 
	 * we're going to redirect the to another page that gonna be accassed using a GET. Now the user can't utilse the back boutton to 
	 * modify the page that he was on. The pattern help with back button issues inside of our browser
	 * @param attendee
	 * @return
	 * 
	 * initial signature PRE validation String processAttendee(@ModelAttribute("attendee") Attendee attendee)
	 * Post validation String processAttendee(@Valid Attendee attendee, BindingResult result, Model m)
	 * @Valid trigger the verification according to the annotation in the model object
	 * BindingResult will trap any error message our trouble we had validation this object.
	 * So the process isn't automatic you actually had to do something we the BindingResult to see
	 * if something wrong appened
	 */
	@RequestMapping(value = "/attendee", method = RequestMethod.POST)
	public String processAttendee(@Valid Attendee attendee, BindingResult result, Model m) {
		System.out.println(attendee);
		
		// if there is an error we re send back to attendee, the same page, it's not a redirect
		// otherwise we would have no idea an error occured
		if (result.hasErrors())
			return "attendee";
					
		
		return "redirect:index.html";
	}
}
