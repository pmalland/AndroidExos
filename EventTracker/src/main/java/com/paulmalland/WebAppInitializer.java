package com.paulmalland;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
/**
 * This is where we gonna replace our web.xml content i.e servlet declaration and servlet mapping
 * The file is familiar, it's exactly what we use to do in web.xml, but now it's in java and we rejoice and
 * all the content assist and the readability of java for us .... java folks
 * 
 * @author paulm
 *
 */

public class WebAppInitializer implements WebApplicationInitializer {

	/**
	 * 
	 */
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		WebApplicationContext context = getContext();
		servletContext.addListener(new ContextLoaderListener(context));
		ServletRegistration.Dynamic dispatcher =
				servletContext.addServlet("DispatcherServlet", new DispatcherServlet(context));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("*.html");
		dispatcher.addMapping("*.pdf");
		dispatcher.addMapping("*.json");
		dispatcher.addMapping("*.xml");
		
	}

	private AnnotationConfigWebApplicationContext getContext() {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		// older version of Spring MVC use context.setConfigLocation("")
//		context.setConfigLocation("com.paulmalland.WebConfig");
		// recent versions use context.register(WebConfig.class)
		context.register(WebConfig.class);
		return context;
	}

}
