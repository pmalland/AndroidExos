package com.paulmalland.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.paulmalland.model.Event;
/**
 * @SessionAttributes("event") say that we want the object under the name "event" to be bound to our Session
 * i.e that lifecycle of our app. So session scope
 * @author paulm
 *
 */
@Controller
@SessionAttributes("event")
public class EventController {

	@RequestMapping(value = "/event", method = RequestMethod.GET)
	public String displayEventPage(Model model){
		Event event = new Event();
		event.setName("Java User Group");
		model.addAttribute("event", event);
		
		return "event";
	}
	
	/**
	 * with redirect: the request is rebuild from scratch and the precedent response objects are 
	 * lost. We basically go out of the application and build a new request then enter the app.
	 * The redirect: change the url in the browser adress bar the forward would not change it
	 * @param event @ModelAttribute("event") say that event is bount to our Model under the name "event"
	 * so "event" is set up to a request scope
	 * @return
	 */
	@RequestMapping(value ="/event", method = RequestMethod.POST)
	public String processEvent(@ModelAttribute("event") Event event) {
		System.out.println(event);
		return "redirect:index.html";
	}
	
}
