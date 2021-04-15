package com.cognizant.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.Country;
import com.cognizant.controller.CountryController;
import com.cognizant.service.exception.CountryNotFoundException;

@Service
public class CountryService {
	Logger LOGGER = LoggerFactory.getLogger(CountryController.class);
	ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

	public Country getCountry(String code) throws CountryNotFoundException{
		LOGGER.info("START");
		List<Country> countries = (List<Country>) context.getBean("countryList");
		LOGGER.info("Calling CountryService.getCountry() with code=" + code);
		Country country = countries.stream().filter(c -> c.getCode().equalsIgnoreCase(code)).findAny().orElse(null);
		LOGGER.debug("Country: {}", country);
		if(country==null)
		{
			throw new CountryNotFoundException();
		}
		
		LOGGER.info("END");
		return country;
	}
public Country addCountry(Country country) {
	ArrayList<Country> list = (ArrayList<Country>) context.getBean("countryList");
		if(list.add(country))
			return country;
		
		return null;
	}
}
