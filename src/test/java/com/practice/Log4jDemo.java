package com.practice;

import org.apache.log4j.Logger;

public class Log4jDemo {
	static Logger logger ;
public static void main(String[] args) {
	logger = Logger.getLogger("Log4jDemo");
	
	System.out.println("Hello word");
	logger.info("this is info message");
	logger.error("this is error message");
	logger.fatal("this is fatal message");
	logger.warn("this is fatal message");
	System.out.println("execution finish");
}
}
