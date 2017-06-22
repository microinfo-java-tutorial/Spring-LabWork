/*
 * This code is sample code, provided as-is, and we make no warranties as to its
 * correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. Copyright 2013 LearningPatterns Inc.
 */
package com.javatunes.web;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.env.Environment;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.javatunes.domain.MusicItem;
import com.javatunes.service.Catalog;


@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String keywordUserEntered = request.getParameter("keyword");
		
		WebApplicationContext spring = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		Environment environment = spring.getEnvironment();
		
		Catalog catalog = spring.getBean(Catalog.class);
		
		System.out.println(catalog);

		
		Collection<MusicItem> results = catalog.findByKeyword(keywordUserEntered);
		
		request.setAttribute("matches", results);
		request.setAttribute("environment", environment);
		
		getServletContext().getRequestDispatcher("/").forward(request, response);
	}

}
