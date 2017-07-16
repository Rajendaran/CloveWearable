package com.clovewearable.cove.util;

import java.text.ParseException;
import java.util.Date;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.clovewearable.cove.constants.ICoveConstant;
import com.clovewearable.cove.model.TimeDifference;

/**
 * @author Rajendaran
 *
 */

@Service
public class CalculateTimeDifferenceUtil {
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CalculateTimeDifferenceUtil.class);

	/**
	 * @param date1
	 * @param date2
	 * @return TimeDifference
	 */
	public TimeDifference calculateTimeDifference(Date date1, Date date2) {
	    Date parseDate1 = null;
	    Date parseDate2 = null;
	    try {
	    	parseDate1 = ICoveConstant.SIMPLE_DATE_FORMAT.parse(ICoveConstant.SIMPLE_DATE_FORMAT.format(date1));
	    	parseDate2 = ICoveConstant.SIMPLE_DATE_FORMAT.parse(ICoveConstant.SIMPLE_DATE_FORMAT.format(date2));
	    } catch (ParseException e) {
	        logger.error(e.getMessage());
	    }

	    long timeDiff = parseDate2.getTime() - parseDate1.getTime();
	    long diffInSeconds = timeDiff / 1000 % 60;
	    long diffInMinutes = timeDiff / (60 * 1000) % 60;
	    long diffInHours = timeDiff / (60 * 60 * 1000);
	    int diffInDays = (int) timeDiff / (1000 * 60 * 60 * 24);
	    
	    TimeDifference timeDifference = new TimeDifference();
	    timeDifference.setSeconds(diffInSeconds);
	    timeDifference.setMinutes(diffInMinutes);
	    timeDifference.setHours(diffInHours);
	    timeDifference.setDays(diffInDays);
	    
		return timeDifference;
		
	}
}
