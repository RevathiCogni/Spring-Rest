package com.cognizant.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.Country;
import com.cognizant.service.CountryService;
import com.cognizant.service.exception.CountryNotFoundException;

@RestController
public class CountryController {
	
	Logger LOGGER=LoggerFactory.getLogger(CountryController.class);
	ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
	
	@Autowired
	private CountryService countryService;
	
	@RequestMapping("/country")
	public Country getCountryIndia()
	{
		LOGGER.info("Start");
		
		LOGGER.info("End");
		return (Country) context.getBean("in");
		
	}
	
	@GetMapping("/countries")
	public List<Country> getAllCountries() {
		LOGGER.info("START");
		LOGGER.info("END");
		return (List<Country>) context.getBean("countryList");
	}
	
	@GetMapping("/countries/{code}") 
	public Country getCountry(@PathVariable String code) throws CountryNotFoundException  {
		LOGGER.info("START");
		LOGGER.info("END");
		return countryService.getCountry(code);
	}

}
