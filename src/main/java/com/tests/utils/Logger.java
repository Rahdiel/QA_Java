package com.tests.utils;


public class Logger {
	
	private static Logger logger;
	private boolean debug;
	
	private Logger(){

		if(PropertyReader.readProperty("debug").equals("true")){
			this.debug=true;
		}else {
			this.debug=false;
		}
		
		
	}
    
    public static Logger getLogger() {
        if(logger == null) {
        	logger = new Logger();
        	
        }
        return logger;
    }
	
	public void log(String testName, String msg) {
        if(debug){
        	if (testName.isEmpty()) {
                System.out.println(msg);
            } else {
                System.out.println(testName + ": " + msg);
            }
        	
        }
		
    }

}
