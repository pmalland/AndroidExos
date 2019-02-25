package com.paulmalland;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


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
 * 
 * @author paulm
 *
 */
@Configuration
@EnableWebMvc
public class WebConfig {

}
