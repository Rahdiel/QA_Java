package com.tests.utils;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimeSettings {
	
	
	private static final Logger log = LoggerFactory.getLogger(TimeSettings.class);  
	private static int maxYear = Integer.parseInt(PropertyReader.readProperty("maxYear"));
	
	public static void wiatForSeoncd(int seconds){
		try        
		{	
			log.info("Wait for: "+seconds+" seconds.");
			//wait for how many seconds
		    Thread.sleep(seconds*1000);
		    log.info("Done waiting.");
		} 
		catch(InterruptedException ex) 
		{
		    Thread.currentThread().interrupt();
		}
	}
	
	public static Long getTimeStamp(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        log.info(String.valueOf(timestamp.getTime()));
        long l=timestamp.getTime();
        Long result=Long.valueOf(l);
        return result;
	}
	
	public static Long generateRandomDate() {
		Date date = new Date();
		GregorianCalendar gc = new GregorianCalendar();
		int yearMin = gc.get(Calendar.YEAR);
		int yearMax = yearMin + maxYear;

		long offset = new Timestamp(System.currentTimeMillis()).getTime();
		long end = Timestamp.valueOf(String.valueOf(yearMax) + "-01-01 00:00:00").getTime();
		long diff = end - offset + 1;
		Timestamp rand = new Timestamp(offset + (long) (Math.random() * diff));

		date = rand;
		log.info(String.valueOf(date));
		
		Long result=Long.valueOf(rand.getTime());

		return result;
	}
	
	public static Long generateFutureRandomDate() {
		Date date = new Date();
		GregorianCalendar gc = new GregorianCalendar();
		int yearMin = gc.get(Calendar.YEAR);
		int yearMax = yearMin + maxYear;

		long offset = new Timestamp(System.currentTimeMillis()).getTime();
		long end = Timestamp.valueOf(String.valueOf(yearMax) + "-01-01 00:00:00").getTime();
		long diff = end - offset + 1;
		Timestamp rand = new Timestamp(offset + (long) (Math.random() * diff));

		date = rand;
		log.info(String.valueOf(date));
		
		Long result=Long.valueOf(rand.getTime());
		Long minimum =Long.valueOf(rand.getTime()+86400000L);
		
		if(result<minimum){
			result=minimum;
		}

		return result;
	}

	public static Long generateRandomPeriod() {
		Date date = new Date();
		GregorianCalendar gc = new GregorianCalendar();
		int yearMin = gc.get(Calendar.YEAR);
		int yearMax = yearMin + maxYear;

		long offset = new Timestamp(System.currentTimeMillis()).getTime();
		long end = Timestamp.valueOf(String.valueOf(yearMax) + "-01-01 00:00:00").getTime();
		long diff = end - offset + 1;
		Timestamp rand = new Timestamp(offset + (long) (Math.random() * diff));

		long period = end - rand.getTime();

		date = rand;
		log.info(String.valueOf(date));
		
		Long result=Long.valueOf(period);

		return result;
	}

}
