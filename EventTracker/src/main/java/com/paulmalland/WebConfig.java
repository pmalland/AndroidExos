package com.paulmalland;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


/**
 * @Configuration and @EnableWebMvc makes that we don't need application context 
 * and dispatcher Servlet or our servlet-config that we add all in.xml files in previous 
 * approaches : servlet-config.xml appContext.xml and web.xml with in it a listener,
 *  to define a servlet and insite that servlet create mapping.
 * we'll do all the config in java POJO.
 * When the application loads, spring will go through all the files white these 2 annotations and 
 * create a context out of it.
 * @EnableWebMcv get ride of our servlet-congif.xml. There will still be a context:component-scan annotation
 * the internal view resolver is define be default with @EnableWebMvc. We can still go fine grained with java config way
 * Remember : Spring is about Convention over Configuration and still we can jump deep into it if we need to
 * 
 * As if Spring 5 WebMvcConfigurerAdapter is deprecated. So instead of extends WebMvcConfigurerAdapter
 * just implements WebMvcConfigurer. It is because java 8 introduced default methods on interfaces
 * cover the functionality of the WebMvcConfigurerAdapter class 
 * 
 * @author paulm
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.paulmalland")
public class WebConfig implements WebMvcConfigurer {

	
	/**
	 * To enable Internationalization we configured 3 beans : a messageSource with the ResourceBundleMessageSource
	 * to be able to search our messages_**.properties files
	 * a Locale Resolver to retrieve what is the current Locale
	 * an interceptor to detect when the Locale change
	 * Thoses 3 beans are autowired by name so the names are not random her. messageSource(), localeResolver() are mandatory
	 * addInterceptors() is an override so it's name is also set.  
	 * We went to our jsp page to had some href to trigger a manual change of Locale by adding ?language=en or ?language=es at the end 
	 * of our Url
	 */
	/**
	 * ResourceBundle Loader
	 * "messages" is a prefix of the files we gonna create to hold the messages in different languages
	 *  Here messages.properties
	 * 
	 */
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		
		return messageSource; 
	} 
	
	/**
	 * Locale Resolver
	 * set our default Locale and also store it in our session, session scope
	 * @return
	 */
	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver resolver = new SessionLocaleResolver();
		resolver.setDefaultLocale(Locale.ENGLISH);
		return resolver;
		
	}
	
	/**
	 * here "language" is just the string that we want spring to look to detect when there
	 * might be a change of Locale
	 * interprete our urls
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	//	WebMvcConfigurer.super.addInterceptors(registry);
		LocaleChangeInterceptor changeInterceptor = new LocaleChangeInterceptor();
		changeInterceptor.setParamName("language");
		registry.addInterceptor(changeInterceptor);
		
	}
	
	
	/**
	 * InternalResourceViewResolver setting, has a bean, just like in xml
	 * Autowiring by type
	 * @return
	 */
	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		
		return resolver;
		
	}
	
	
	/**
	 * Static resource handler
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
//		WebMvcConfigurer.super.addResourceHandlers(registry);
		registry.addResourceHandler("/pdfs/**").addResourceLocations("/WEB-INF/pdf/");
		registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/css/");
		
	}
}
