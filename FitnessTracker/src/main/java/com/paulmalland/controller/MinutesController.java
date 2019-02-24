package com.paulmalland.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.paulmalland.model.Activity;
import com.paulmalland.model.Exercise;
import com.paulmalland.service.ExerciseService;

@Controller
public class MinutesController {

	@Autowired
	private ExerciseService exerciseService;
	
	/**
	 * @RequestMapping(value="/addMinutes") /addMinutes refer to the url that we
	 *                                      looking for i.e
	 *                                      http://localhost/FitnessTracker/addMinutes.html
	 * @param exercise
	 * @return
	 */
	@RequestMapping(value = "/addMinutes")
	public String addMinutes(@ModelAttribute("exercise") Exercise exercise) {

		System.out.println("exercise: " + exercise.getMinutes());
		System.out.println("exercise activity: " + exercise.getActivity());

		// typically we would call her our datbase and do something with it and then navigate to another page
		
		
		/**
		 * This "addMinutes" that we return is used by our InternatRessourceViewResolver
		 * or ViewResolver in the servlet-config.xml file to search for the right .jsp
		 * file to fire up. If the return is just 'return "forward:addMoreMinutes";' the
		 * page breack cause it doesn't know where is FitnessTracker/addMoreMinutes it
		 * has to be return '"forward:addMoreMinutes.html";' so the RequestMapping of
		 * the addMore%Minutes method can work. "forward:addMoreMinutes.html"; is going
		 * OUTSIDE of our frameword and comming back IN and remember, the servlet
		 * mapping in the web.xml file say that we look for request that looks like
		 * "*.html"
		 * 
		 * "forward: " bypass our view resolver, the same request enter addMoreMinutes
		 */
		// return "forward:addMoreMinutes.html";

		// "redirect:" also lead to addMoreMinutes put it closes our request and reopen
		// a new one
		// so the first exercise object is lost
		// return "redirect:addMoreMinutes.html";
		return "addMinutes";
	}

	/**
	 * Here an example of chaining. From the addMinutes method, who return
	 * "forward:addMoreMinutes.html"; that bypass our view resolver and enter back
	 * throug as a request and enter the addMoreMinutes method and the view resolver
	 * but it is the same request
	 * 
	 * The second ewample of chaining is with "redirect:" that close the incoming
	 * request and opening a new one, loosing the precedent.
	 * 
	 * @RequestMapping(value="/addMoreMinutes") /addMinutes refer to the url that we
	 *                                          looking for i.e
	 *                                          http://localhost/FitnessTracker/addMoreMinutes.html
	 * @param exercise
	 * @return
	 */
//	@RequestMapping(value="/addMoreMinutes")
//	public String addMoreMinutes(@ModelAttribute ("exercise") Exercise exercise) {
//		
//		System.out.println("exercising: " + exercise.getMinutes() );
//		
//		
//		/** this "addMinutes" that we return is used by our InternatRessourceViewResolver or ViewResolver
//		 * in the servlet-config.xml file to search for the right .jsp file to fire up. 
//		 */
//		return "addMinutes";	
//	}

	/**
	 * @ResponseBody says what you return is the actual content that I want to expose. So it's saying
	 * that I am returning the content
	 * 
	 * @return
	 */
	@RequestMapping(value = "/activities", method = RequestMethod.GET)
	public @ResponseBody List<Activity> findAllActivities(){
		List<Activity> activities = new ArrayList<Activity>();
/*
 * Moving this to our service class, where the business logic should be 
 * 		List<Activity> activities = new ArrayList<Activity>();
		Activity run = new Activity();
		run.setDesc("Run");
		activities.add(run);
		
		Activity bike = new Activity();
		bike.setDesc("Bike");
		activities.add(bike);
		
		Activity swim = new Activity();
		swim.setDesc("Swim");
		activities.add(swim);
*/		
		return exerciseService.findAllActivities();
	}

}
