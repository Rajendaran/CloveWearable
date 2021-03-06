package com.clovewearable.cove.schduler;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.clovewearable.cove.constants.ICoveConstant;
import com.clovewearable.cove.exception.OpenWeatherMapCustomException;
import com.clovewearable.cove.model.Temperature;
import com.clovewearable.cove.service.impl.OpenWeatherMapService;

/**
 * @author Rajendaran
 *
 */

@Configuration
@EnableScheduling
public class OpenWeatherMapScheduler {
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(OpenWeatherMapScheduler.class);
	
	@Autowired
	OpenWeatherMapService openWeatherMapService;

	/**
	 * @throws OpenWeatherMapCustomException
	 */
	@Scheduled(fixedDelay=60000)
	public void updateTemperatureByEveryMinute() throws OpenWeatherMapCustomException {
		logger.info(ICoveConstant.BEGINS_OWM_SCHEDULER_UPDATETEMP_EVERY_MINUTE_METHOD);
		List<Temperature> temperatureList = openWeatherMapService.getAllTemperature();
		logger.info(ICoveConstant.TEMPERATURE_LIST_SIZE + temperatureList.size());
		for (Temperature temp : temperatureList) {
			Temperature temperature = openWeatherMapService.getCurrentTemperature(temp.getPincode(), temp.getCountry());
			openWeatherMapService.updateTemperatureByEveryMinute(temperature);
		}
		
	}

}
