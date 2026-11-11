package com.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtility {
	
	private static Logger logs;

	private LoggerUtility() {
		
	}
	
	public static Logger getLogger(Class<?> clazz) {
		if(logs==null) {
			logs= LogManager.getLogger(clazz);
		}
		return logs;
	}
	
	

}
