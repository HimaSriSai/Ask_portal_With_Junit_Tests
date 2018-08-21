package com.prokarma.searchquery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.prokarma.searchquery.service.SearchServiceImpl;

/**
 * @author prokarma
 *
 */
@RestController
@EnableWebMvc
@RequestMapping("/ask")
public class SearchController {

	/**
	 * 
	 */
	@Autowired
	@Qualifier("searchService")
	private SearchServiceImpl searchServiceImpl;

	/**
	 * @return
	 */	
	@RequestMapping(value = "/getCategories", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<List<String>> resetRequest() {

		final List<String> category = searchServiceImpl.getcategory();

		return new ResponseEntity<>(category, HttpStatus.OK);

	}

}
