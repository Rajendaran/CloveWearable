package com.clovewearable.cove.service;

import java.util.List;

import com.clovewearable.cove.exception.OpenWeatherMapCustomException;
import com.clovewearable.cove.model.Temperature;

/**
 * @author Rajendaran
 *
 */
public interface IOpenWeatherMapService {
	
	public Double getTemperatureByPincode(Temperature temperature) throws OpenWeatherMapCustomException;
	
	public void updateTemperatureByEveryMinute(Temperature temperature) throws OpenWeatherMapCustomException;
	
	public Temperature getCurrentTemperature(String pincode, String country) throws OpenWeatherMapCustomException;
	
	public List<Temperature> getAllTemperature() throws OpenWeatherMapCustomException;

}