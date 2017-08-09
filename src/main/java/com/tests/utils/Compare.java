package com.tests.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Compare {
	
	private static final Logger log = LoggerFactory.getLogger(Compare.class);  
	
    public static boolean equalString(String one, String two){
    	if(one==null&&two==null){
    		return true;
    	}else {
    		if(one==null||two==null){
    			log.error("Strings are different: "+one+" "+two);
    			return false;
    		}else{
    			if(!one.equals(two)){
    				log.error("Strings are different: "+one+" "+two);
    				
    				return false;
    			}else{
    				return true;
    			}
    			
    		}
    		
    	}

    }
    
    public static boolean equalLong(Long one, Long two){
    	if(one==null&&two==null){
    		return true;
    	}else {
    		if(one==null||two==null){
    			log.error("Longs are different: "+one+" "+two);
    			return false;
    		}else{
    			if(!one.equals(two)){
    				log.error("Longs are different: "+one+" "+two);
    				
    				return false;
    			}else{
    				return true;
    			}
    			
    		}
    		
    	}

    }
    


}
