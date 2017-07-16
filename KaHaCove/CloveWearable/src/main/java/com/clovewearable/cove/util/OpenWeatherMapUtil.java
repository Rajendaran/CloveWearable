package com.clovewearable.cove.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.clovewearable.cove.constants.ICoveConstant;
import com.clovewearable.cove.exception.OpenWeatherMapCustomException;

/**
 * @author Rajendaran
 *
 */

@Service
public class OpenWeatherMapUtil {
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(OpenWeatherMapUtil.class);
	
	/**
	 * @param ownApiUrl
	 * @return JSONObject
	 * @throws OpenWeatherMapCustomException
	 */
	public JSONObject getOpenWeatherMapData(String ownApiUrl) throws OpenWeatherMapCustomException {
		JSONObject weatherByPincodeObj = null;
		String weatherByPincode = "";
		try {
			URL url = new URL(ownApiUrl);
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			while (null != (weatherByPincode = br.readLine())) {
				weatherByPincodeObj = new JSONObject(weatherByPincode);
			}
		} catch (Exception e) {
			logger.error(ICoveConstant.ERROR_WHILE_GETTING_OWM_DATA + "\n" + e.getMessage());
		}
		return weatherByPincodeObj;
	}

}
