package com.library.common;

import java.io.File;
import java.io.IOException;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class StepResultLogger  {
	
	public ExtentTest logger;
	public ExtentReports reports;
	StepCounter sc=new StepCounter();
	CommonLibrary clib=new CommonLibrary();
	public void startTest(String htmlreport,String testnum,String testName) throws IOException
	{
		
		/*File file = new java.io.File(htmlreport);
		//file.mkdirs(); // wrong! 
		file.getParentFile().mkdirs(); // correct!
		if (!file.exists()) {
		    file.createNewFile();
		}*/ 

		reports=new ExtentReports(htmlreport,false);
		logger=reports.startTest(testnum+":"+testName);
	}
	public void endTest()
	{
		reports.endTest(logger);
		reports.flush();
	}
	public void passStep(String comment,String resultpath) throws Exception
	{
		logger.log(LogStatus.PASS, comment);
		/*
		File f=new File(resultpath);
		
		if (!f.exists()) {
		    System.out.println("creating directory: " + f.getName());
		    boolean result = false;
		    f.mkdir();
		    System.out.println("file created");
		}*/
		clib.screenShotSelenium(resultpath, "pass_", sc.stepNumber());
	}
	public void failStep(String comment,String resultpath) throws Exception
	{
		logger.log(LogStatus.FAIL, comment);
		clib.screenShotSelenium(resultpath, "fail_", sc.stepNumber());
	}
	public void warningStep(String comment,String resultpath) throws Exception
	{
		logger.log(LogStatus.WARNING, comment);
		clib.screenShotSelenium(resultpath, "warning_", sc.stepNumber());
	}
	public void infoStep(String comment,String resultpath) throws Exception
	{
		logger.log(LogStatus.INFO, comment);
		clib.screenShotSelenium(resultpath, "info_", sc.stepNumber());
	}
	public void errorStep(String comment,String resultpath) throws Exception
	{
		logger.log(LogStatus.ERROR, comment);
		clib.screenShotSelenium(resultpath, "error_", sc.stepNumber());
	}
	public void skipStep(String comment,String resultpath) throws Exception
	{
		logger.log(LogStatus.SKIP, comment);
		clib.screenShotSelenium(resultpath, "skip_", sc.stepNumber());
	}
	public void fatalStep(String comment,String resultpath) throws Exception
	{
		logger.log(LogStatus.FATAL, comment);
		clib.screenShotSelenium(resultpath, "fatal_", sc.stepNumber());
	}
	public void unknownStep(String comment,String resultpath) throws Exception
	{
		logger.log(LogStatus.UNKNOWN, comment);
		clib.screenShotSelenium(resultpath, "unknown_", sc.stepNumber());
	}
	public void pass(String comment,String resultPath) throws Exception, Exception
	{
		logger.log(LogStatus.PASS, comment);
		clib.windowScreenshot(resultPath, "pass_",  sc.stepNumber());
		
	}
	public void fail(String comment,String resultPath) throws Exception, Exception
	{
		logger.log(LogStatus.FAIL, comment);
		clib.windowScreenshot(resultPath, "fail_",  sc.stepNumber());
	}
	public void info(String comment,String resultPath) throws Exception, Exception
	{
		logger.log(LogStatus.INFO, comment);
		clib.windowScreenshot(resultPath, "info_",  sc.stepNumber());
	}
	public void error(String comment,String resultPath) throws Exception, Exception
	{
		logger.log(LogStatus.ERROR, comment);
		clib.windowScreenshot(resultPath, "error_",  sc.stepNumber());
		
	}
	
}
