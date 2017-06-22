/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.web;

import com.javatunes.service.Catalog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;

// TODO: Annotate as a controller
// TODO: Annotate to handle /content/home URL
@Controller
@RequestMapping({"/", "home"})
public class HomeController {

	@Inject
	private Catalog catalog;

	// TODO: Annotate to respond to HTTP GET requests
	@RequestMapping(method = RequestMethod.GET)
	//@ResponseBody // Just needed for this lab05.2 - will do in a better way soon in Lab05.3. a
	// and the ResponseBody is used as HTML code starting Controller as return statment ex:  return "<HTML><h1>Siddharth</h1></HTML>"
	public String get() {

		//return "<h1>Hello Spring MVC</h1>"; //  enable this only if @ResponseBody annotation is used
		return "home";
	}
}