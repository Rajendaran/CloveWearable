package com.clovewearable.cove.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clovewearable.cove.constants.ICoveConstant;
import com.clovewearable.cove.exception.OpenWeatherMapCustomException;
import com.clovewearable.cove.model.Temperature;
import com.clovewearable.cove.service.impl.OpenWeatherMapService;
import com.clovewearable.cove.util.OpenWeatherMapUtil;

/**
 * @author Rajendaran
 *
 */

@RestController
@RequestMapping(value = "/openWeatherMap")
public class OpenWeatherMapController {
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(OpenWeatherMapController.class);
	
	@Autowired
	OpenWeatherMapUtil openWeatherMapUtil;
	
	@Autowired
	OpenWeatherMapService openWeatherMapService;
	
	/**
	 * @param pincode
	 * @param country
	 * @return current temperature
	 * @throws OpenWeatherMapCustomException
	 */
	@RequestMapping(value = "/getTemperatureByPincode")
	public ResponseEntity<String> getTemperatureByPincode(@RequestParam("pincode") String pincode,
			@RequestParam("country") String country) throws OpenWeatherMapCustomException {
		logger.info(ICoveConstant.BEGINS_OWM_CONTROLLER_GETTEMPBYPINCODE_METHOD);
		Temperature temperature = openWeatherMapService.getCurrentTemperature(pincode, country);
		Double currentTemp = openWeatherMapService.getTemperatureByPincode(temperature);
		return new ResponseEntity<String>(ICoveConstant.CURRENT_TEMP + currentTemp, HttpStatus.OK);
	}
	
}
