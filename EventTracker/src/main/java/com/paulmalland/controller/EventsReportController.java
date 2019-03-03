package com.paulmalland.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paulmalland.model.Event;
/**
 * In our EventsRepostController class :
 * the  @RestController condense the @Controller and the @BodyResponse annotations,
 * whit that, all of our configuration is now set up to return a RestFull 
 * web services out of this controller, just by adding that annotation on there
 * 
 * Remember before the use of @RestController annotation we had to add the @ResponseBody
 * annotation to getEvent method signature, and what the ResponseBody did for us was
 * it said I am returning the content to you, I don't want you to necessarily go out and try
 * and find a JSP page for this, or to do something different with this, so by annotating this
 * as a REST controller we automatically get our RequestMappings bound and our 
 * ResponseBody set for us to handle JSON or XML output from our controller. 
 * 
 * So to do our ContentNegotingViewResolver equivalent with the @RestController we had to
 * 		add @RestController annotation to our EventsReportController
 * 			fill a getEvent or a businessLogic method with the @RequestMapping	
 * 				here we simply create some fake data to be processed and return a List<Event>
 * 		DispatcherMapping : add 2 more dispatchers to our DispatcherServlet in our WebAppInitializer.java on the onStartUp method
 * 			dispatcher.addMapping("*.json"); dispatcher.addMapping("*.xml"); more mapping here for. json and xml 
 * 			and that's just so that it get's routed through our DispatcherServlet
 * 		and now we gonna bind it to an Angular FrontEnd
 * Remember this RestController is bind to the /events URL, make a list of event and send it has a response
 * to the ViewController.
 * 		created an events.js javascript angular page to bind the response to a $scope variable
 * 		created a eventReports.jsp  file, we kept .jsp cause our dispatcher has been told to handle .html
 * 				but the file is html*ish. Here we bind our JSON response to an Angular frontend
 * 				we can see our frontend result at /EventTracker/eventReports.jsp
 * 
 * 
 * @author paulm
 *
 */
@RestController
public class EventsReportController {
	/**
	 * 
	 * @return events : events, so we're just going to return our array list,
	 *  and it's going to go through and automatically bind that to our JSON response
	 *  and produce a JSON collection from this method type, there's no other configuration
	 *  that we need to do, nothing else needs to be bound, no other settings,
	 *   no configuration as far as the ContentNegotiatingViewResolver this is all done for us
	 *   now. 
	 */
	@RequestMapping(value ="/events")
	public List<Event> getEvent(){
		
		List<Event> events= new ArrayList<>();
		
		Event event1 = new Event();
		event1.setName("Java User Group");
		events.add(event1);
		
		Event event2 = new Event();
		event2.setName("Angular User Group");
		events.add(event2);
		
		return events;
	}
	
	// Without the use of @RestController annotation
//	@RequestMapping(value ="/events")
//	public @ResponseBody List<Event> getEvent(){
//		
//	}
	
}
