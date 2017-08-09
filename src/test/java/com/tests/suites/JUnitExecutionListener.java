package com.tests.suites;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JUnitExecutionListener extends RunListener {
private final Logger log = LoggerFactory.getLogger(this.getClass());
	
    @Override
	public void testRunFinished(Result result) throws Exception {
        log.info("Number of tests Executed: " + result.getRunCount());
        log.info("Number of tests Failed: " + result.getFailureCount());
        if(result.getFailureCount()>0){
            if(result.getFailures().size()>0){
            	for(Failure fail:result.getFailures()){
                    log.info("Failed test header: " + fail.getTestHeader());
                    log.info("Failed test message: \n" + fail.getMessage());
            		
            	}
            	
            }
        	
        }


    }

    @Override
	public void testStarted(Description description) throws Exception {
        log.info("Starting: " + description.getMethodName());
    }

    @Override
	public void testFinished(Description description) throws Exception {
        log.info("Finished: " + description.getMethodName());
    }

    @Override
	public void testFailure(Failure failure) throws Exception {
        log.info("Failed: " + failure.getDescription().getMethodName());
    }

    @Override
	public void testAssumptionFailure(Failure failure) {
        log.info("Failed: " + failure.getDescription().getMethodName());
    }

    @Override
	public void testIgnored(Description description) throws Exception {
        log.info("Ignored: " + description.getMethodName());
    }
}
