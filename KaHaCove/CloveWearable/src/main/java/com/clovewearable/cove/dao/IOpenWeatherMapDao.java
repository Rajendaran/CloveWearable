package com.clovewearable.cove.dao;

import java.util.List;

import com.clovewearable.cove.exception.OpenWeatherMapCustomException;
import com.clovewearable.cove.model.Temperature;

/**
 * @author Rajendaran
 *
 */
public interface IOpenWeatherMapDao {
	
	public Double getTemperatureByPincode(Temperature temperature) throws OpenWeatherMapCustomException;
	
	public void updateTemperatureByEveryMinute(Temperature temperature) throws OpenWeatherMapCustomException;
	
	public List<Temperature> getAllTemperature() throws OpenWeatherMapCustomException;

}
