package com.paulmalland.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping(value = "/greeting")
	public String sayHello(Model model) {
		model.addAttribute("greeting", "Hello World");
		
		// we don't need to return the .jsp of "hello.jsp" cause now we have already set an InternalViewResolver
		// that known where an and to search i.e , some .jsp files in /WEB-INF/jsp/
		// Remember, that viewResolver only manage access to file in /WEB-INF/jsp/
		// that means the index.jsp is still accessible in deep access style
		// (accessing a page with the kwnolegde of its url instead of navigating from another page)
		return "hello";
	}
	
	/**
	 * With forward: the response object are passed forward too, the original request is passed on to 
	 * to index.jsp. 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/index")
	public String index(Model model) {
		return "forward:index.jsp";
	}
}
