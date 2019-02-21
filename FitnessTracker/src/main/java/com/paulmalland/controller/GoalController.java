package com.paulmalland.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.paulmalland.model.Goal;

@Controller
@SessionAttributes("goal")
public class GoalController {
	/**
	 * 
	 * @param model this model is a reference, we will use it to return data back to our JSP page
	 * @Annotation method = RequestMethod.GET means that method just gonna handle http request of GET
	 * and a POST request will get an error. we want only GET request to go to this method
	 * @return
	 */
	@RequestMapping(value = "addGoal", method = RequestMethod.GET)
	public String addGoal(Model model) {
		Goal goal = new Goal();
		goal.setMinutes(10);
		model.addAttribute("goal",goal);
		return "addGoal";
	}
	/**
	 * 
	 * @param goal @ModelAttribute is our wiring/binding to the model
	 * @Valid check if the goal that i'm setting here is valid but we still need to have
	 * something to check the result of that binding, and so the BindingResult argument
	 * @param result, this object will contain the respond of the @Valid test and tell us if it is 
	 * okay or not and has any errors
	 * @return
	 */
	@RequestMapping(value ="addGoal", method = RequestMethod.POST)
	public String updateGoal(@Valid @ModelAttribute("goal") Goal goal, BindingResult result ) {
		
		/**
		 * It's not business logic , it's navigation logic, the controller is responsible to select
		 * witch view to fire so it's the write place to do it 
		 */
		System.out.println("result has errors: " + result.hasErrors());
		
		System.out.println("Minutes updated: " + goal.getMinutes());
		if(result.hasErrors()) {
			return "addGoal";
		}
		
		
		return "redirect:addMinutes.html";
	}
	
}

